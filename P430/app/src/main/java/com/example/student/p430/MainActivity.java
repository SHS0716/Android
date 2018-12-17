package com.example.student.p430;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    ListView listView;
    ArrayList<String> list = new ArrayList<>();
    EditText editText;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("abc");
        list.add("def");

        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);

        adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        list.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb =
                        new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Item Delete");
                adb.setMessage("Are You OK");
                adb.setPositiveButton("OK ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();

                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        String str = editText.getText().toString();
        list.add(str);
        adapter.notifyDataSetChanged();
    }
}
