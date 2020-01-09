package th.ac.kku.cis.lab.recycleviewapplication.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nasa.*
import th.ac.kku.cis.lab.recycleviewapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val rv = findViewById<RecyclerView>(R.id.simple_recyclerView)
        simple_recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        gridLayoutManager = GridLayoutManager(this, 2)

        val users = ArrayList<User>()
        users.add(
            User(
                "Paul",
                "Mr"
            )
        )
        users.add(
            User(
                "Jane",
                "Miss"
            )
        )
        users.add(
            User(
                "John",
                "Dr"
            )
        )
        users.add(
            User(
                "Amy",
                "Mrs"
            )
        )

        var adapter = UserAdapter(users)
        simple_recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_recycler_manager) {
            changeLayoutManager()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun changeLayoutManager() {
        if (simple_recyclerView.layoutManager == linearLayoutManager) {
            simple_recyclerView.layoutManager = gridLayoutManager
        } else {
            //3
            simple_recyclerView.layoutManager = linearLayoutManager
        }
    }
}
