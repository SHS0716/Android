package com.example.student.p225;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    EditText Num1, Num2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv;
    TextView result;
    Button numBts []  = new Button[10];
    int [] numButton = {R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,
            R.id.BtnNum4,R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,
            R.id.BtnNum9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = findViewById(R.id.Edit1);
        Num2 = findViewById(R.id.Edit2);

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        BtnMul = findViewById(R.id.BtnMul);
        BtnDiv = findViewById(R.id.BtnDiv);
        BtnAdd.setOnClickListener(this);
        BtnSub.setOnClickListener(this);
        BtnMul.setOnClickListener(this);
        BtnDiv.setOnClickListener(this);

        result = findViewById(R.id.TextResult);

        for(int i=0;i<numBts.length;i++) {
            numBts[i] = findViewById(numButton[i]);


            numBts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

    @Override
    public void onClick(View v) {
        String n1 = Num1.getText().toString();
        String n2 = Num2.getText().toString();
        double nn1 = Double.parseDouble(n1);
        double nn2 = Double.parseDouble(n2);
        double resultData = 0;
        if(v.getId() == R.id.BtnAdd){
            resultData = nn1 + nn2;
        }else if(v.getId() == R.id.BtnSub){
            resultData = nn1 - nn2;
        }else if(v.getId() == R.id.BtnMul){
            resultData = nn1 * nn2;
        }else if(v.getId() == R.id.BtnDiv){
            resultData = nn1 / nn2;
        }
        result.setText("Result:"+resultData);
    }
}
