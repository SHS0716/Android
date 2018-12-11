package com.example.student.p84;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            Toast.makeText(this, "This is SPARTA!!!", Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button2){
            button1.setVisibility(View.INVISIBLE);
        }else if(v.getId() == R.id.button3){
            button3.setBackgroundColor(Color.parseColor("#F15F5F"));
            button3.setTextColor(Color.parseColor("#FFFFFF"));
        }

    }
}
