package com.example.student.p527;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(br, intentFilter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int result = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                textView.setText("Battery Remian"+result);
                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
                switch (plug){
                    case 0: textView2.setText("Unplugged..");
                        break;
                    case 1: textView2.setText("Plugged ..Adapter");
                        break;
                    case 2: textView2.setText("Plugged ..USB");
                        break;
                }
            }else if(action.equals("android.net.conn.CONNECTIVITY_CHANGE")){
                ConnectivityManager cManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo wifi = null;
                NetworkInfo lte = null;
                wifi = cManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                lte =  cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if(wifi != null && wifi.isConnected()){
                    imageView.setImageResource(R.drawable.wifi);
                }else if (lte != null && lte.isConnected()){
                    imageView.setImageResource(R.drawable.lte);
                }else {
                    imageView.setImageResource(R.drawable.wifidis);
                }
            }
        }
    };

}


