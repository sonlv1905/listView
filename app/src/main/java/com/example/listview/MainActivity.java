package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.models.Technology;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Technology> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        list.addAll(getAll());
        ListViewAdapter adapter = new ListViewAdapter(this,list);


//        String[] st = getResources().getStringArray(R.array.technology);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item,st);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int i= 0 ; i< adapter.getCount() ; i++){
                    parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                parent.getChildAt(position).setBackgroundColor(Color.CYAN);
                Toast.makeText(MainActivity.this,"Select:"+adapter.getItem(position).getTitle(),Toast.LENGTH_LONG);

            }
        });
    }

    private List<Technology> getAll(){
        List<Technology> t = new ArrayList<>();
        t.add(new Technology(R.drawable.facebook,"Facebook","facebook","facebook"));
        t.add(new Technology(R.drawable.googleplus,"Googleplus","googleplus","googleplus"));
        t.add(new Technology(R.drawable.instagram,"Instagram","instagram","instagram"));
        t.add(new Technology(R.drawable.spotify,"Spotify","spotify","spotify"));
        return t;
    }
}