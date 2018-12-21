package com.example.student.p487;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button;
    ProgressDialog progressDialog;
    int result;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressBar = findViewById(R.id.progressBar);
    }

    class MyTask extends AsyncTask<String,Integer,Integer>{
        String ip;
        public MyTask(String ip){
            this.ip = ip;
        }

        @Override
        protected void onPreExecute() {
            textView.setText("onPreExecute");
            button.setEnabled(false);
            button.setTextColor(Color.WHITE);
            progressDialog.setTitle("Progress");
            progressDialog.setMessage(ip+"..connect...");
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int cnt = values[0].intValue();
            progressBar.setProgress(cnt);
        }

        @Override
        protected Integer doInBackground(String... strings) {
            int result = 0;
            for(int i=0;i<10;i++){
                SystemClock.sleep(1000);
                result += i;
                publishProgress(result);
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            result = integer;
            textView.setText("onPostExecute:"+integer);
            button.setEnabled(true);
            button.setTextColor(Color.WHITE);
            progressDialog.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        MyTask task = new MyTask("70.12.112.130");
        task.execute();
    }
}
