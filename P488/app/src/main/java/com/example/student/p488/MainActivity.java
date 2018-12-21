package com.example.student.p488;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        progressBar = findViewById(R.id.progressBar);
        new Thread(r).start();
    }

    public void display(final int num){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("Car Data: "+num);
            }
        });
    }
    //Thread
    Runnable r = new Runnable() {
            Random ran = new Random();
        @Override
        public void run() {
            while(true) {
                int num = ran.nextInt(10) + 1;
                display(num);
                SystemClock.sleep(5000);
            }
        }
    };
    //AsyncTask



    class NetworkTask extends AsyncTask<Integer, Integer, Integer>{
        int sendData;

        public NetworkTask(int data){
            sendData = data;
        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }

}
