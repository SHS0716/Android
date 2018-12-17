package com.example.student.p431;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Person> persons;
    MyAdapter myAdapter;

    public void getData(){
        persons = new ArrayList<>();
        persons.add(new Person(R.drawable.p1,"id01","jisung01","SALES"));
        persons.add(new Person(R.drawable.p2,"id02","geunyoung01","MAKETTING"));
        persons.add(new Person(R.drawable.p3,"id03","haeri01","HR"));
        persons.add(new Person(R.drawable.p4,"id04","iu01","LOEN"));
        persons.add(new Person(R.drawable.p5,"id05","suzy01","JYP"));
        persons.add(new Person(R.drawable.p6,"id06","sk01","SM"));
        persons.add(new Person(R.drawable.p7,"id07","momo01","JYP"));
        persons.add(new Person(R.drawable.p8,"id08","yw01","SALES"));
        persons.add(new Person(R.drawable.p9,"id09","ns01","SALES"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        listView = findViewById(R.id.listView);
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);

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
            view = View.inflate(MainActivity.this,R.layout.person_view,null);
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
