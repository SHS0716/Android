package com.example.student.p416;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.i("my","onCreate-------------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("my","onStart-------------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("my","onResume-------------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("my","onPause-------------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("my","onStop-------------------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("my","onRestart-------------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("my","onDestroy-------------------");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.util.Log.i("my","OnBackPressd----------------");
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Close");
        dlg.setMessage("Are you Exit?");
        dlg.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dlg.setNegativeButton("NO",null);
        dlg.show();
    }
}
