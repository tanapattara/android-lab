package th.ac.kku.cis.lab.mytaskapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class myTaskAdapter extends ArrayAdapter<myTask> {

    private Activity context;
    private List<myTask> tasks;

    public myTaskAdapter(Activity context, int resource, List<myTask> objects) {
        super(context, resource, objects);
        this.context = context;
        this.tasks = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

    }
}
