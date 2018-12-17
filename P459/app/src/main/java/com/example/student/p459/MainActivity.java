package com.example.student.p459;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText et_name, et_num;
    //TextView textView;
    MyDBHelper helper;
    SQLiteDatabase sqlDB;

    ListView listView;
    ArrayList<Idol> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeUi();
        helper = new MyDBHelper(this);
        list = new ArrayList<>();
        adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
    }

    public void makeUi(){
        et_name = findViewById(R.id.et_name);
        et_num = findViewById(R.id.et_num);
        listView = findViewById(R.id.listView);
        //textView = findViewById(R.id.textView);
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        public MyAdapter(Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            view = (View)View.inflate(MainActivity.this,
                    R.layout.item,null);
            TextView textView = view.findViewById(R.id.textView);
            TextView textView2 = view.findViewById(R.id.textView2);
            textView.setText(list.get(position).getName());
            textView2.setText(list.get(position).getNum()+"");
            return view;
        }
    }

    class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context){
            super(context,"idol",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE TB_IDOL (NAME CHAR(30) PRIMARY KEY, NUM INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS TB_IDOL");
            onCreate(db);
            Log.i("db","Update OK -------------------");
        }
    }

    public void initDB(){
        sqlDB = helper.getWritableDatabase();
        helper.onUpgrade(sqlDB,1,2);
        sqlDB.close();
    }
    public void inputDB(){
        String name = et_name.getText().toString();
        String num = et_num.getText().toString();
        sqlDB = helper.getWritableDatabase();
        String ssql = "INSERT INTO TB_IDOL VALUES ('";
        ssql += name +"',"+num;
        ssql += ");";
        try {
            sqlDB.execSQL(ssql);
            selDB();
            Toast.makeText(this, "Insert OK",
                    Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this, "Insert Fail",
                    Toast.LENGTH_SHORT).show();
        }finally {
            sqlDB.close();
        }


    }
    public void updateDB(){
        String name = et_name.getText().toString();
        String num = et_num.getText().toString();
        sqlDB = helper.getWritableDatabase();
        String ssql = "UPDATE TB_IDOL SET NUM="+num+",";
        ssql += "WHERE NAME='"+name+"';";
        sqlDB.execSQL(ssql);
        sqlDB.close();
        selDB();
        Toast.makeText(this, "Update OK",
                Toast.LENGTH_SHORT).show();
    }
    public void delDB(){
        String name = et_name.getText().toString();
        //String num = et_num.getText().toString();
        sqlDB = helper.getWritableDatabase();
        String ssql = "DELETE FROM TB_IDOL ";
        ssql += "WHERE NAME='"+name+"';";
        sqlDB.execSQL(ssql);
        sqlDB.close();
        selDB();
        Toast.makeText(this, "DELETE OK",
                Toast.LENGTH_SHORT).show();
    }
    public void selDB(){
        list.clear();
        sqlDB = helper.getReadableDatabase();
        String sql = "SELECT * FROM TB_IDOL;";
        Cursor cursor = sqlDB.rawQuery(sql,null);
        String result = "";
        while(cursor.moveToNext()){
            Idol idol =
                    new Idol(cursor.getString(0),
                            cursor.getInt(1));
            list.add(idol);
        }
        adapter.notifyDataSetChanged();
        //textView.setText(result);
        cursor.close();
        sqlDB.close();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_init){
            initDB();
        }else if(v.getId() == R.id.bt_input){
            inputDB();
        }else if(v.getId() == R.id.bt_update){
            updateDB();
        }else if(v.getId() == R.id.bt_del){
            delDB();
        }else if(v.getId() == R.id.bt_sel){
            selDB();
        }
    }
}
