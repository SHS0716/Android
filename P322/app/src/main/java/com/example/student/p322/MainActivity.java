package com.example.student.p322;

import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
     Button btnp, buttonex;
     RadioButton btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnp = findViewById(R.id.btnp);

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = (View)View.inflate(MainActivity.this,R.layout.img_dig, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(view);
                ImageView imageView = view.findViewById(R.id.imageView);

                if(btn1.isChecked()){
                    dlg.setTitle(btn1.getText().toString());
                    imageView.setImageResource(R.drawable.p1);
                    dlg.
                }else if(btn2.isChecked()){
                    dlg.setTitle(btn2.getText().toString());
                    imageView.setImageResource(R.drawable.p2);
                }else  if(btn3.isChecked()){
                    dlg.setTitle(btn3.getText().toString());
                    imageView.setImageResource(R.drawable.p3);
                }else  if(btn4.isChecked()) {
                    dlg.setTitle(btn4.getText().toString());
                    imageView.setImageResource(R.drawable.p4);
                }dlg.show();
            }
        });
    }
}
