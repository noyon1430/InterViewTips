package com.example.noyon.interviewtips;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class ScreenStartedActivity extends AppCompatActivity {

     private static final int REQUEST_CODE_QUIZ =1;

     //setDifficulty
     public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

     public static final String SHARED_PREFS = "sharedPrefs";
     public static final String KEY_HIGHSCORE="keyHighscore";

     private TextView textViewHighscore;
     private Spinner spinnerCategory;
     //setDifficulty
     private Spinner spinnerDifficulty;
     private int highscore;

     Button buttonStartTest;
    // private int difficultyLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_started);

        textViewHighscore =findViewById(R.id.text_view_highscore);

        spinnerCategory = findViewById(R.id.spinner_category);
        //setDifficulty
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);

        String[] difficultyLevels = Question.getAllDifficultyLevels();


        loadCategories();

        //loadDifficultyLevels
        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);

        loadHighscore();

        buttonStartTest=(Button) findViewById(R.id.button_start_test);
        buttonStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest();
            }
        });

        //TestDbHelper.getInstance(this).addCategories();
    }
    private void startTest()

    {
        Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
        int categoryID = selectedCategory.getId();
        String categoryName = selectedCategory.getName();

        String difficulty = spinnerDifficulty.getSelectedItem().toString();

        Intent intent=new Intent(ScreenStartedActivity.this,Test.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
        intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivityForResult(intent, REQUEST_CODE_QUIZ );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_QUIZ)
        {
            if(resultCode==RESULT_OK)
            {
                int score=data.getIntExtra(Test.EXTRA_SCORE,0);
                if(score >highscore)
                {
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadCategories()
    {
      TestDbHelper dbHelper = TestDbHelper.getInstance(this);
        List<Category> categories = dbHelper.getAllCategories();

        ArrayAdapter<Category> adapterCategories = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategories);
    }

    private void loadHighscore()
    {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore =prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(  int highscoreNew) {

        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
        
    }
}
