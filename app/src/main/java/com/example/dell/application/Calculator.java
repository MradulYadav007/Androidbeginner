package com.example.dell.application;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4,b6,b5;
    TextView t1;
    TextToSpeech t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1=(Button)findViewById(R.id.button);
        b6=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView4);
        t2=new TextToSpeech(this,new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                t2.setLanguage(Locale.ENGLISH);
                t2.setSpeechRate(0.9f);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1+f2;
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "Enter the valid values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s3 = Float.toString(f3);
                    t1.setText(s3);
                    t2.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(Calculator.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1-f2;
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "Enter the valid values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s3 = Float.toString(f3);
                    t1.setText(s3);
                    t2.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(Calculator.this, "the answer is" + s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1*f2;
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "Enter the valid values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s3 = Float.toString(f3);
                    t1.setText(s3);
                    t2.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(Calculator.this, "the answer is" + s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Float f1=Float.parseFloat(s1);
                Float f2=Float.parseFloat(s2);
                Float f3=f1/f2;
                if(s1.equals("") || s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "Enter the valid values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s3 = Float.toString(f3);
                    t1.setText(s3);
                    t2.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(Calculator.this, "the answer is" + s3, Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Calculator.this,Mainmenu1.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("");
                e1.setText("");
                e2.setText("");
            }
        });
    }
}
