package com.example.student.p325;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button button, button2, button3;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream in = getResources().openRawResource(R.raw.my);
                try {
                    byte[] txt = new byte[in.available()];
                    in.read(txt);
                    textView.setText(new String(txt));
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeData();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });
    } //onCreate
    public void writeData(){
        String str = editText.getText().toString();
        try {
            FileOutputStream out = openFileOutput("myfile.txt",Context.MODE_PRIVATE);
            out.write(str.getBytes());
            out.close();
            Toast.makeText(this, "WRITE OK", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "WRITE FAIL", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public void readData(){
            try{
            FileInputStream in = openFileInput("myfile.txt");
            byte [] txt = new byte[50];
            in.read(txt);
            String str = new String(txt);
            textView.setText(str);
        }catch (Exception e){
            Toast.makeText(this, "READ FAIL", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
