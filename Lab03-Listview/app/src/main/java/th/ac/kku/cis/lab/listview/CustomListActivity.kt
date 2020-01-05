package th.ac.kku.cis.lab.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import th.ac.kku.cis.lab.listview.Adapter.MyListAdapter
import th.ac.kku.cis.lab.listview.Model.Student

class CustomListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        val listView:ListView = findViewById(R.id.listView)
        val student_list = mutableListOf<Student>()

        student_list.add(Student("Title One",   "Description One...",   R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Three", "Description Three...", R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))
        student_list.add(Student("Title Five",  "Description Five...",  R.mipmap.ic_launcher  ))

        listView.adapter = MyListAdapter(
            this,
            R.layout.student_list,
            student_list
        )

        listView.setOnItemClickListener{parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Student
            Toast.makeText(this,selectedItem.name,Toast.LENGTH_SHORT).show()
        }
    }
}
