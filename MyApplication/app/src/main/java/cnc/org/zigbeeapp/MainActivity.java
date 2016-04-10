package cnc.org.zigbeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, R.layout.listitem, R.id.item, new ArrayList<String>());

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        pollTest();
    }

    private void pollTest() {
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
               new GetNew(adapter).execute();
            }
        };
        timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 1000 ms
    }
}
