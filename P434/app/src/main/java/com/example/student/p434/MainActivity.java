package com.example.student.p434;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Person> persons;
    MyAdapter myAdapter;

    public void getData(){
        persons = new ArrayList<>();
        persons.add(new Person(R.drawable.m1,"id01","james01","SALES"));
        persons.add(new Person(R.drawable.m2,"id02","james02","SALES"));
        persons.add(new Person(R.drawable.m3,"id03","james03","SALES"));
        persons.add(new Person(R.drawable.m4,"id04","james04","SALES"));
        persons.add(new Person(R.drawable.m5,"id05","james05","SALES"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

        gridView = findViewById(R.id.gridView);
        myAdapter = new MyAdapter(this);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View aview = null;
                aview = (View)View.inflate(MainActivity.this,
                        R.layout.grid,null);
                ImageView imageView = aview.findViewById(R.id.imageView);
                TextView textView = aview.findViewById(R.id.textView);
                TextView textView2 = aview.findViewById(R.id.textView2);
                TextView textView3 = aview.findViewById(R.id.textView3);
                imageView.setImageResource(persons.get(position).getImg());
                textView.setText(persons.get(position).getId());
                textView2.setText(persons.get(position).getName());
                textView3.setText(persons.get(position).getDept());


                AlertDialog.Builder dlg =
                        new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("Person Detail");
                dlg.setView(aview);
                //dlg.setMessage(persons.get(position).getId()+" "+
                //        persons.get(position).getName());
                dlg.setNegativeButton("Close",null);
                dlg.show();
            }
        });
    }

    class MyAdapter extends BaseAdapter{

        Context context;

        public MyAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return persons.size();
        }

        @Override
        public Object getItem(int position) {
            return persons.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            view = (View)View.inflate(MainActivity.this,
                    R.layout.grid,null);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);
            TextView textView2 = view.findViewById(R.id.textView2);
            TextView textView3 = view.findViewById(R.id.textView3);
            imageView.setImageResource(persons.get(position).getImg());
            textView.setText(persons.get(position).getId());
            textView2.setText(persons.get(position).getName());
            textView3.setText(persons.get(position).getDept());


            return view;
        }
    }

}


