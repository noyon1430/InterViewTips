package com.example.noyon.interviewtips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button test, topics, resume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics=(Button) findViewById(R.id.buttonTopics);
        topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,TopicsCategory.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Successfully clicked Topics button", Toast.LENGTH_SHORT).show();
            }
        });

        test=(Button) findViewById(R.id.buttonTest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ScreenStartedActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Successfully clicked Test button", Toast.LENGTH_SHORT).show();
            }
        });

        resume=(Button) findViewById(R.id.buttonResume);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Download.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Successfully clicked Resume button", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
