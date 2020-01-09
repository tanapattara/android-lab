package th.ac.kku.cis.lab.recycleviewapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import th.ac.kku.cis.lab.recycleviewapplication.NASA.NasaActivity
import th.ac.kku.cis.lab.recycleviewapplication.basic.MainActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonBasic.setOnClickListener { v ->
            var i: Intent = Intent(this,
                MainActivity::class.java)
            startActivity(i)
        }
        buttonNASA.setOnClickListener { v ->
            var i: Intent = Intent(this,
                NasaActivity::class.java)
            startActivity(i)
        }
    }
}
