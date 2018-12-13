package com.example.student.p303;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3, button4 ;
    String [] texts = {"RED","GREEN","BLUE"};
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView4 = findViewById(R.id.textView4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t1 = Toast.makeText(MainActivity.this,"Toast1",Toast.LENGTH_SHORT);
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int x = display.getWidth()/2;
                int y = display.getHeight()/2;
                t1.setGravity(Gravity.TOP | Gravity.LEFT,x,y);
                t1.show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast t2 = new Toast(MainActivity.this);
                    View view = (View)View.inflate(MainActivity.this,R.layout.mytoast, null);
                    TextView tv = view.findViewById(R.id.textView2);
                        tv.setText("Toast2");
                        t2.setView(view);
                        t2.show();


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //알림창 위치
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("My Dialog");
                //dlg.setMessage("This is Dialog");
                dlg.setIcon(R.drawable.good);
                //각각의 String text에 이벤트 처리
                dlg.setItems(texts, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button3.setText(texts[which]);
                    }
                });
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button.setVisibility(View.INVISIBLE);
                    }
                });
                dlg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button2.setVisibility(View.INVISIBLE);
                    }
                });
                dlg.show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = (View)View.inflate(MainActivity.this,R.layout.mydialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("My Dialog");
                //dlg.setMessage("This is Dialog");
                dlg.setIcon(R.drawable.good);
                dlg.setView(view);
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = findViewById(R.id.editText);
                        EditText editText2 = findViewById(R.id.editText2);
                        String id = editText.getText().toString();
                        String pwd = editText2.getText().toString();

                        textView4.setText(id+" "+pwd);
                    }
                });
                dlg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();
            }
        });
    }


}
