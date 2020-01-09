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

public class Signin extends AppCompatActivity {
    Button b1,b2;
    TextView t1,t2;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button3);
        e1=(EditText)findViewById(R.id.editText6);
        e2=(EditText)findViewById(R.id.editText7);
        t1=(TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(Signin.this, "Field is required", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase dat = openOrCreateDatabase("Profiles", MODE_PRIVATE, null);
                    String s4 = "select * from list where username='" + s1 + "' and password='" + s2 + "'";
                    Cursor cursor = dat.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Intent i = new Intent(Signin.this,Mainmenu1.class);
                        startActivity(i);
                        finish();
                    }
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signin.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
