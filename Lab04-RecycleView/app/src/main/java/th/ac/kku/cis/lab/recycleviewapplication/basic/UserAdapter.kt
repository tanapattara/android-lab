package th.ac.kku.cis.lab.recycleviewapplication.basic

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.nasa_item_layout.view.*
import th.ac.kku.cis.lab.recycleviewapplication.NASA.Photo
import th.ac.kku.cis.lab.recycleviewapplication.NASA.PhotoActivity
import th.ac.kku.cis.lab.recycleviewapplication.NASA.RecyclerAdapter
import th.ac.kku.cis.lab.recycleviewapplication.R

class UserAdapter(val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(userList[position].name, userList[position].title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(
            v
        );
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindItem(name: String, title: String) {
            txtName.text = name
            txtTitle.text = title
        }
        override fun onClick(v: View) {
            Log.d("RecyclerView", txtName.text.toString() + " CLICK!")
        }
    }
}