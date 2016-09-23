package com.example.naveenkumark.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private ArrayAdapter<String> adapter;
    private  String[] myResArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        myResArray = getResources().getStringArray(R.array.item_list);
        //List<String> stringList = Arrays.asList(myResArray);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myResArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView) view.findViewById(android.R.id.text1);
        tv.setText(myResArray[i] + " clicked");
        Toast.makeText(this, myResArray[i], Toast.LENGTH_SHORT).show();
    }
}
