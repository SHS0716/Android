package com.example.student.p111;

import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button,button2;
    EditText editText;
    RadioButton radioButton,radioButton2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeUi();
    }

    private void MakeUi() {
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        radioButton.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            String str = editText.getText().toString();
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button2){
            String str = editText.getText().toString();
            Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+str));
            startActivity(mIntent);
        }else if(v.getId() == R.id.radioButton){
            imageView.setImageResource(R.drawable.p1);
        }else if(v.getId() == R.id.radioButton2){
            imageView.setImageResource(R.drawable.p2);
        }
    }
}
