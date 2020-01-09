package com.example.dell.application;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText4);
        e4=(EditText)findViewById(R.id.editText8);
        e5=(EditText)findViewById(R.id.editText5);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signin.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Field is required.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase dat = openOrCreateDatabase("Profiles", MODE_PRIVATE, null);
                    dat.execSQL("create table if not exists list(full name varchar,username varchar,email varchar,password varchar,phone varchar)");
                    String s6 = "select * from list where username='" + s2 + "'";
                    Cursor cursor = dat.rawQuery(s6, null);
                    if (cursor.getCount() > 0)
                    {
                        Toast.makeText(MainActivity.this, "UserID not available", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        dat.execSQL("insert into list values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "')");
                        Toast.makeText(MainActivity.this, "User successfully registered.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Signin.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

    }
}
