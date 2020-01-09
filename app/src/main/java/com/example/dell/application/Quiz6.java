package com.example.dell.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz6 extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);
        b1=(Button)findViewById(R.id.button9);
        b2=(Button)findViewById(R.id.button10);
        t1=(TextView)findViewById(R.id.textView20);
        r1=(RadioButton)findViewById(R.id.radioButton17);
        r2=(RadioButton)findViewById(R.id.radioButton18);
        r3=(RadioButton)findViewById(R.id.radioButton19);
        r4=(RadioButton)findViewById(R.id.radioButton20);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r3.isChecked()) {
                    ++Quiz1.score;


                }
                else {
                    --Quiz1.score;

                }
                Intent i = new Intent(Quiz6.this,Result.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Quiz6.this,Quiz5.class);
                startActivity(i);
                finish();
            }
        });
    }
}
