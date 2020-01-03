package th.ac.kku.cis.lab.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import th.ac.kku.cis.lab.listview.Model.Student

class CustomListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var listView:ListView = this.findViewById(R.id.listView)
        var student_list = mutableListOf<Student>()

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

        listView.adapter = MyListAdapter(this,R.layout.student_list,student_list)

        listView.setOnItemClickListener{parent, view, position, id ->

            if (position==0){
                Toast.makeText(this, "Item One",   Toast.LENGTH_SHORT).show()
                //val intent = Intent(this@CustomListActivity,ProfileActivity::class.java)
                //intent.putExtra("Username","John Doe")
                //startActivity(intent)

                //get data from intent
//                val intent = intent
//                val name = intent.getStringExtra("Name")
//                val email = intent.getStringExtra("Email")
//                val phone = intent.getStringExtra("Phone")
            }
            if (position==1){
                Toast.makeText(this, "Item Two",   Toast.LENGTH_SHORT).show()
            }
            if (position==2){
                Toast.makeText(this, "Item Three", Toast.LENGTH_SHORT).show()
            }
            if (position==3){
                Toast.makeText(this, "Item Four",  Toast.LENGTH_SHORT).show()
            }
            if (position==4){
                Toast.makeText(this, "Item Five",  Toast.LENGTH_SHORT).show()
            }
        }
    }
}
