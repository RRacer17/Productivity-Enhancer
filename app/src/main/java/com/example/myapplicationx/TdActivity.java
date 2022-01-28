package com.example.myapplicationx;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TdActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox cb1,cb2,cb3;
    Button b1,b2,b3;
    TextView txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tdactivity);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);
        CheckBox cb3 = findViewById(R.id.cb3);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                if(cb1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Task 1 Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                if(cb2.isChecked()){
                    Toast.makeText(getApplicationContext(),"Task 2 Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                if(cb3.isChecked()){
                    Toast.makeText(getApplicationContext(),"Task 3 Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
                EditText t1 = findViewById(R.id.t1);
                String in1 = t1.getText().toString();
                t1.setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.txt1)).setText(in1);
                //b1.setVisibility(View.INVISIBLE);
                //t1.setText(in1);
                break;
            case R.id.b2:
                EditText t2 = findViewById(R.id.t2);
                String in2 = t2.getText().toString();
                t2.setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.txt2)).setText(in2);
                //t2.setText(in2);
                break;
            case R.id.b3:
                EditText t3 = findViewById(R.id.t3);
                String in3 = t3.getText().toString();
                t3.setVisibility(View.INVISIBLE);
                ((TextView)findViewById(R.id.txt3)).setText(in3);
                //t3.setText(in3);
                break;
        }
    }
}