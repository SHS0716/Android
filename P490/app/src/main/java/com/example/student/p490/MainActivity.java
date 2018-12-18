package com.example.student.p490;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SeekBar seekBar1, seekBar2;
    TextView textView1, textView2;
    Myhandler myhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        myhandler = new Myhandler();


    }
    Thread t= new Thread(){
        public void run(){
            for(int i=0;i<10;i++){
                Message ms = new Message();
                Bundle bundle = ms.getData();
                bundle.putInt("data",i);
                myhandler.handleMessage(ms);
                SystemClock.sleep(200);

            }
        }
    };

    class Myhandler extends Handler {
        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            int result = bundle.getInt("data");
            Log.i("data~~~~~~~~~~",result+"");
            textView1.setText(result+"");
            seekBar1.setProgress(result);
        }
    }

    @Override
    public void onClick(View v) {
        t.start();

//        Thread t1 = new Thread() {
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    seekBar1.setProgress(seekBar1.getProgress() + 1);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            textView1.setText(seekBar1.getProgress() + "%");
//                        }
//                    });
//                    SystemClock.sleep(100);
//                }
//            }
//        };
//        Thread t2 = new Thread() {
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    seekBar2.setProgress(seekBar2.getProgress() + 2);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            textView2.setText(seekBar2.getProgress() + "%");
//                        }
//                    });
//
//                    SystemClock.sleep(100);
//                }
//            }
//
//        };
//        t1.start();
//        t2.start();

        }
    }

