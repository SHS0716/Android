package com.example.student.p486;

import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    ImageView imageView;
    int imgs [] = {R.drawable.p1,R.drawable.p2,
                    R.drawable.p3,R.drawable.p4,
                    R.drawable.p5,R.drawable.p6,
                    R.drawable.p7,R.drawable.p8,
                    R.drawable.p9,R.drawable.p10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
    }

    public void display(final int status){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("Input Data: "+status);
                imageView.setImageResource(imgs[status]);
            }
        });
    }

    Runnable r = new Runnable() {
        Random ran = new Random();
        @Override
        public void run() {
            while (true){
                int i = ran.nextInt(10);
                display(i);
                SystemClock.sleep(3000);
            }
        }
    };

    @Override
    public void onClick(View v) {
        Thread t = new Thread(r);
        t.start();
    }
}
