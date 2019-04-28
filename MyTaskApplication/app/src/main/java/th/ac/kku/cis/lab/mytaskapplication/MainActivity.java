package th.ac.kku.cis.lab.mytaskapplication;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ArrayList tasks;
    private HashMap<String, myTask> myTasksMap;
    private ListView listView;
    private ArrayAdapter<String> _adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fabNew);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });

        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.tasks = new ArrayList<>();
        this.listView = findViewById(R.id.taskslist);
        this.myTasksMap = new HashMap<String, myTask>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    tasks.clear();
                    myTasksMap.clear();

                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        myTask mytask = data.getValue(myTask.class);
                        tasks.add(mytask.task);
                        myTasksMap.put(mytask.task,mytask);
                    }
                    Log.i("onResume", "Get data from database " + tasks.size() + " task.");
                    CreateList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("onResume","Can't load data from database");
            }
        });
    }

    private void CreateList() {
        Collections.sort(this.tasks);
        if(this._adapter == null)
            this._adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, this.tasks);

        // Assign adapter to ListView
        listView.setAdapter(this._adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String taskname = tasks.get(position).toString();
                myTask selectedTask = myTasksMap.get(taskname);
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                intent.putExtra("name", selectedTask.task);
                intent.putExtra("status", selectedTask.status);
                startActivity(intent);
            }
        });

        //when long click
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                String taskname = tasks.get(pos).toString();
                myTask selectedTask = myTasksMap.get(taskname);

                mDatabase.child(selectedTask.task).removeValue();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
