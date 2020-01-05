package th.ac.kku.cis.lab.listview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import th.ac.kku.cis.lab.listview.Model.Task
import th.ac.kku.cis.lab.listview.R


public class TaskAdapter(var mCtx: Context, var resource:Int, var items:List<Task>)
    : ArrayAdapter<Task>( mCtx , resource , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //super.getView(position, convertView, parent)

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource, null)

        val ivIcon: ImageView = view.findViewById(R.id.taskicon)
        var taskName : TextView = view.findViewById(R.id.taskname)
        var taskCategory : TextView = view.findViewById(R.id.taskcategory)

        var task: Task = items[position]

        ivIcon.setImageDrawable(mCtx.resources.getDrawable(task.icon))
        taskName.text = task.name
        taskCategory.text = task.category

        return view
    }
}