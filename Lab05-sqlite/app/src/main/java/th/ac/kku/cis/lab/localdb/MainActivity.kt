package th.ac.kku.cis.lab.localdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddToDb.setOnClickListener {
            val dbHandler = DBHelper(this, null)
            val user = Task(etName.text.toString())
            dbHandler.addTask(user)
            Toast.makeText(this, etName.text.toString() + "Added to database", Toast.LENGTH_LONG).show()
        }

        btnShowDatafromDb.setOnClickListener {
            tvDisplayName.text = ""
            val dbHandler = DBHelper(this, null)
            val cursor = dbHandler.getAllTask()

            cursor!!.moveToFirst()

            do {
                val id = (cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ID)))
                val name = (cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME)))
                tvDisplayName.append( id + "). "+ name)
                tvDisplayName.append("\n")
            }while (cursor.moveToNext())
        cursor.close()
        }

        btnDelete.setOnClickListener {
            //read id
            val input = etEdit.text.toString()
            val dbHandler = DBHelper(this, null)
            val result = dbHandler.deleteTask(input.toInt())
        }
        btnEdit.setOnClickListener {
            //read id
            val input = etEdit.text.toString()
            val parts = input.split(" ")
            val task = Task(parts[0].toInt(),parts[1])

            val dbHandler = DBHelper(this, null)
            val result = dbHandler.updateTask(task)
        }
    }
}
