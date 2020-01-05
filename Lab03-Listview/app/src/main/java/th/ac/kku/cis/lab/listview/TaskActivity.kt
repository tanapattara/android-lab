package th.ac.kku.cis.lab.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import th.ac.kku.cis.lab.listview.Adapter.TaskAdapter
import th.ac.kku.cis.lab.listview.Model.Task

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val tasks_list = ArrayList<Task>()
        val taskAdapter = TaskAdapter(this,R.layout.task_list,tasks_list)
        val listView : ListView = findViewById(R.id.listView_task)
        listView.adapter = taskAdapter

        val addButton : Button = findViewById(R.id.addtaslbutton)
        addButton.setOnClickListener{ view ->
            val newTesk : EditText = findViewById(R.id.newTask)
            val newCategory : EditText = findViewById(R.id.newCategory)

            tasks_list.add(Task(newTesk.text.toString(), newCategory.text.toString(), R.mipmap.ic_launcher ))
            taskAdapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener{parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Task
            Toast.makeText(this,selectedItem.name,Toast.LENGTH_SHORT).show()
        }

        listView.setOnItemLongClickListener { parent, view, position, id ->
            tasks_list.removeAt(position)
            taskAdapter.notifyDataSetChanged()
            true
        }
    }
}
