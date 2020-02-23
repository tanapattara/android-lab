package th.ac.kku.cis.lab.firebasedbapplication

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ItemRowListener {

    lateinit var mDatabase: DatabaseReference

    var toDoItemList: MutableList<ToDo>? = null
    lateinit var adapter: ToDoItemAdapter
    private var listViewItems: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Enable Firebase persistence for offline access
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        //create firebase object
        mDatabase = FirebaseDatabase.getInstance().reference
        listViewItems = findViewById<View>(R.id.items_list) as ListView

        toDoItemList = mutableListOf<ToDo>()
        adapter = ToDoItemAdapter(this, toDoItemList!!)
        listViewItems!!.setAdapter(adapter)
        mDatabase.orderByKey().addListenerForSingleValueEvent(itemListener)

        fab.setOnClickListener { view ->
            addNewItemDialog()
        }

    }

    var itemListener: ValueEventListener = object : ValueEventListener {

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // call function
            addDataToList(dataSnapshot)
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Item failed, display log a message
            Log.w("MainActivity", "loadItem:onCancelled", databaseError.toException())
        }
    }

    private fun addDataToList(dataSnapshot: DataSnapshot) {
        val items = dataSnapshot.children.iterator()
        // Check if current database contains any collection
        if (items.hasNext()) {
            val toDoListindex = items.next()
            val itemsIterator = toDoListindex.children.iterator()

            // check if the collection has any to do items or not
            while (itemsIterator.hasNext()) {
                // get current item
                val currentItem = itemsIterator.next()
                val map = currentItem.getValue() as HashMap<String, Any>
                // add data to object
                val todoItem = ToDo.create()
                todoItem.objectId = currentItem.key
                todoItem.done = map.get("done") as Boolean?
                todoItem.todoText = map.get("todoText") as String?
                toDoItemList!!.add(todoItem);
            }

            adapter.notifyDataSetChanged()
        }
    }

    //Add new item to DB
    private fun addNewItemDialog() {
        // Create dialog
        val alert = AlertDialog.Builder(this)
        val itemEditText = EditText(this)
        alert.setMessage("Add New Item")
        alert.setTitle("Enter To Do Item Text")
        alert.setView(itemEditText)
        // Set submit button dialog
        alert.setPositiveButton("Submit") { dialog, positiveButton ->
            // create new todoobject
            val todoItem = ToDo.create()
            todoItem.todoText = itemEditText.text.toString()
            todoItem.done = false
            // create new record
            val newItem = mDatabase.child("todo_item").push()
            // add new key to todoobject
            todoItem.objectId = newItem.key
            // set todoobject to new record on firebase db
            newItem.setValue(todoItem)
            // close dialog
            dialog.dismiss()
            // display data to user
            Toast.makeText(this,
                "Item saved with ID " + todoItem.objectId, Toast.LENGTH_SHORT).show()

            toDoItemList!!.add(todoItem);
            adapter.notifyDataSetChanged()
        }
        alert.show()
    }

    override fun modifyItemState(itemObjectId: String, index: Int, isDone: Boolean) {
        //get child reference in database via the ObjectID
        val itemReference = mDatabase.child("todo_item").child(itemObjectId)
        //set new value
        itemReference.child("done").setValue(isDone);

        toDoItemList!!.get(index).done = isDone
        adapter.notifyDataSetChanged()
    }

    override fun onItemDelete(itemObjectId: String, index: Int) {
        //get child reference in database via the ObjectID
        val itemReference = mDatabase.child("todo_item").child(itemObjectId)
        //deletion can be done via removeValue() method
        itemReference.removeValue()

        toDoItemList!!.removeAt(index)
        adapter.notifyDataSetChanged()
    }

}
