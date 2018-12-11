package com.example.student.p193;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    TextView Text1, Text2;
    Switch Sw1;
    RadioGroup RGroup1;
    RadioButton Rb1, Rb2, Rb3;
    Button BtnOK;
    ImageView ImgP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("인물 사진 보기");

        Text1 = (TextView) findViewById(R.id.Text1);
        Sw1 = (Switch) findViewById(R.id.Sw1);

        Text2 = (TextView) findViewById(R.id.Text2);
        RGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        Rb1 = (RadioButton) findViewById(R.id.Rb1);
        Rb2 = (RadioButton) findViewById(R.id.Rb2);
        Rb3 = (RadioButton) findViewById(R.id.Rb3);

        BtnOK = (Button) findViewById(R.id.BtnOK);
        ImgP = (ImageView)findViewById(R.id.ImgP);

        Sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(Sw1.isChecked() == true){
                    Text2.setVisibility(View.VISIBLE);
                    RGroup1.setVisibility(View.VISIBLE);
                    BtnOK.setVisibility(View.VISIBLE);
                    ImgP.setVisibility(View.VISIBLE);
                }else{
                    Text2.setVisibility(View.INVISIBLE);
                    RGroup1.setVisibility(View.INVISIBLE);
                    BtnOK.setVisibility(View.INVISIBLE);
                    ImgP.setVisibility(View.INVISIBLE);
                }
            }
        });

        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (RGroup1.getCheckedRadioButtonId()){
                    case R.id.Rb1:
                        ImgP.setImageResource(R.drawable.p1);
                        break;
                    case R.id.Rb2:
                    ImgP.setImageResource(R.drawable.p2);
                    break;
                    case R.id.Rb3:
                        ImgP.setImageResource(R.drawable.p3);
                        break;
                        default:
                            Toast.makeText(getApplicationContext(),"인물을 먼저 선택하세요",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
