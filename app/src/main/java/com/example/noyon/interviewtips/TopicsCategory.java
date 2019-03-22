package com.example.noyon.interviewtips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TopicsCategory extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6,
           button7, button8, button9, button10, button11;
    public static int MyWebValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_category);

        button1= findViewById(R.id.button_android);
        button2= findViewById(R.id.button_java);
        button3= findViewById(R.id.button_python);
        button4= findViewById(R.id.button_cplus);
        button5= findViewById(R.id.button__net);
        button6= findViewById(R.id.button_html);
        button7= findViewById(R.id.button_css);
        button8= findViewById(R.id.button_javascript);
        button9= findViewById(R.id.button_os);
        button10= findViewById(R.id.button_database);
        button11= findViewById(R.id.button_electronics);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=1;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked Android button", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=2;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked Java button", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=3;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked Python button", Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=4;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked C++ button", Toast.LENGTH_SHORT).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=5;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked .NET button", Toast.LENGTH_SHORT).show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=6;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked HTML button", Toast.LENGTH_SHORT).show();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=7;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked CSS button", Toast.LENGTH_SHORT).show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=8;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked JavaScript button", Toast.LENGTH_SHORT).show();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=9;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked OS button", Toast.LENGTH_SHORT).show();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=10;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, "Successfully clicked Database button", Toast.LENGTH_SHORT).show();
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebValue=11;
                Intent intent= new Intent(TopicsCategory.this,webView.class);
                startActivity(intent);
                Toast.makeText(TopicsCategory.this, " Successfully clicked Electronics button ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
