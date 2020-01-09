package com.example.dell.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz5 extends AppCompatActivity {
    Button b1,b2;
    RadioButton r1,r2,r3,r4;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);
        t1=(TextView)findViewById(R.id.textView);
        r1=(RadioButton)findViewById(R.id.radioButton13);
        r2=(RadioButton)findViewById(R.id.radioButton14);
        r3=(RadioButton)findViewById(R.id.radioButton15);
        r4=(RadioButton)findViewById(R.id.radioButton16);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    ++Quiz1.score;


                } else {
                    --Quiz1.score;

                }
                Intent i = new Intent(Quiz5.this,Quiz6.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Quiz5.this,Quiz3.class);
                startActivity(i);
                finish();
            }
        });
    }
}
