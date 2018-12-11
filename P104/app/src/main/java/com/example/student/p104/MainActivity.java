package com.example.student.p104;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeUi();
    }

    private void makeUi() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            Intent mIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.nate.com"));
            startActivity(mIntent);
        }else if(v.getId() == R.id.button2){
            Intent mIntent = new Intent(Intent.ACTION_CALL ,Uri.parse("tel:/911"));
            startActivity(mIntent);
        }else if(v.getId() == R.id.button3){
            Intent mIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
            startActivity(mIntent);
        }else if(v.getId() == R.id.button4) {
            finish();
        }
        button1.setBackgroundColor(Color.GREEN);
    }
}

