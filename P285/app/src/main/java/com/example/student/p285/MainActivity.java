package com.example.student.p285;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.tx);

    }

    //mymeny.xml을 붙이는 함수
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;


    }

    //이벤트 처리 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1:
                tx.setTextColor(Color.RED);
                tx.setRotation(30);
                return true;
            case R.id.m2:
                tx.setTextColor(Color.GREEN);
                tx.setScaleY(2);
                return true;
            case R.id.m3:
                tx.setTextColor(Color.BLUE);
                return true;
        }
        return false;
    }


}
