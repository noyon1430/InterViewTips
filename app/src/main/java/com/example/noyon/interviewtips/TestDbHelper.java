package com.example.noyon.interviewtips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.noyon.interviewtips.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class TestDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="InterviewTipsTest.db";
    private static final int DATABASE_VERSION= 1;

    private static  TestDbHelper instance;

    private SQLiteDatabase db;

    private TestDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized TestDbHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new TestDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_CREATE_CATEGORIES_TABLE = " CREATE TABLE " +
                TestContract.CatagoriesTable.TABLE_NAME + " ( " +
                TestContract.CatagoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TestContract.CatagoriesTable.COLUMN_NAME + " TEXT " +
                " ) " ;

        final String SQL_CREATE_QUESTIONS_TABLE= " CREATE TABLE " +
                TestContract.QuestionTable.TABLE_NAME + " ( " +
                TestContract.QuestionTable._ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                TestContract.QuestionTable.COLUMN_QUESTION + " TEXT ," +
                TestContract.QuestionTable.COLUMN_OPTION1 + " TEXT , " +
                TestContract.QuestionTable.COLUMN_OPTION2 + " TEXT , " +
                TestContract.QuestionTable.COLUMN_OPTION3 + " TEXT ," +
                TestContract.QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                TestContract.QuestionTable.COLUMN_DIFFICULTY + " TEXT , " +
                TestContract.QuestionTable.COLUMN_CATAGORY_ID + " INTEGER , "+
                " FOREIGN KEY( " + TestContract.QuestionTable.COLUMN_CATAGORY_ID + " ) REFERENCES " +
                TestContract.CatagoriesTable.TABLE_NAME + " ( " + TestContract.CatagoriesTable._ID +
                " ) " + " ON DELETE CASCADE " +
                " ) ";
        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS "+ TestContract.CatagoriesTable.TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS "+ TestContract.QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
    private void fillCategoriesTable()
    {
        Category c1= new Category("PROGRAMMING");
        insertCategory(c1);
        Category c2= new Category("GEOGRAPHY");
        insertCategory(c2);
        Category c3= new Category("MATH");
        insertCategory(c3);

    }
    public  void addCategory(Category category)
    {
        db=getWritableDatabase();
        insertCategory(category);
    }
    public void addCategories(List<Category> categories)
    {
        db= getWritableDatabase();
        for(Category category : categories)
        {
            insertCategory((category));
        }
    }
    private void insertCategory(Category category)
    {
      ContentValues cv = new ContentValues();
      cv.put(TestContract.CatagoriesTable.COLUMN_NAME, category.getName());
      db.insert(TestContract.CatagoriesTable.TABLE_NAME, null,cv);
    }


    private void fillQuestionsTable()
    {
        Question q1= new Question("How to kill an activity in Android?",
                "Finish()","finishActivity(int requestCode)","A & B",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q1);
        Question q2= new Question("What are the layouts available in android?",
                "Linear Layout","Frame Layout"," All of above",
                3, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q2);
        Question q3= new Question("What is broadcast receiver in android?",
                "It will react on broadcast announcements.","It will do background functionalities as services.",
                "It will pass the data between activities.",
                1, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q3);
        Question q4= new Question("What is the time limit of broadcast receiver in android?",
                "15 sec","10 sec","5 sec",
                2, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q4);
        Question q5= new Question("What is an anonymous class in android?",
                "Interface class","A class that does not have a name but have functionalities in it",
                "Java class",
                2, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q5);
        Question q6= new Question("What is APK in android?",
                "Android packages","Android pack","Android packaging kit",
                3, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q6);
        Question q7= new Question("What is JSON in android?",
                "Java Script Object Native","Java Script Oriented Notation",
                "Java Script Object Notation",
                3, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q7);
        Question q8= new Question("How many orientations does android support?",
                "4","10","None of the above",
                1, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q8);
        Question q9= new Question("What are commands needed to create APK in android?",
                " No need to write any commands","Create apk_android in command line",
                "Javac,dxtool, aapt tool, jarsigner tool, and zipalign",
                3, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q9);
        Question q10= new Question("What is anchor view?",
                "Same as list view","provides the information on respective relative positions",
                " Same as relative layout",
                2, Question.DIFFICULTY_EASY, Category.PROGRAMMING);
        insertQuestion(q10);
        Question q11= new Question("What is the size of byte variable?",
                "8 bit","16 bit","32 bit",
                1, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q11);
        Question q12= new Question("What is the size of boolean variable?",
                "8 bit","16 bit","32 bit",
                2, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q12);
        Question q13= new Question("What is the default value of Boolean variable?",
                "true","false","null",
                2, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q13);
        Question q14= new Question("What is the default value of int variable?",
                "0","0.0","null",
                1, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q14);
        Question q15= new Question("What is inheritance?",
                "It is the process where one object acquires the properties of another.",
                "inheritance is the ability of an object to take on many forms.",
                "inheritance is a technique to define different methods of same type.",
                1, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q15);
        Question q16= new Question("What is Set Interface?",
                "Set is a collection of element which contains elements along with their key.",
                "Set is a collection of element which contains hashcode of elements.",
                "Set is a collection of element which cannot contain duplicate elements.",
                3, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q16);
        Question q17= new Question("What is true about a final class?",
                "class declard final is a final class.",
                "Final classes are created so the methods implemented by that class cannot be overridden.",
                "All of the above.",
                3, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q17);
        Question q18= new Question("What is synchronization?",
                "Synchronization is the capability to control the access of multiple threads to shared resources.",
                "Synchronization is the process of writing the state of an object to another object.",
                "Synchronization is the process of writing the state of an object to byte stream.",
                1, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q18);
        Question q19= new Question("Deletion is faster in LinkedList than ArrayList.",
                "True","False","null",
                1, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q19);
        Question q20= new Question("When finally block gets executed?",
                "Always when a method get executed, no matter exception occured or not.",
                "Always when try block get executed, no matter exception occured or not.",
                "Always when a try block get executed, if exception do not occur.",
                2, Question.DIFFICULTY_MEDIUM, Category.PROGRAMMING);
        insertQuestion(q20);
        Question q21= new Question("You can add a row using SQL in a database with which of the following?",
                "ADD","INSERT","CREATE",
                2, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q21);
        Question q22= new Question("1 Gigabyte (Gb) =",
                "1,024 Mb","1,000 Mb","1,200 Mb",
                1, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q22);
        Question q23= new Question("Multi-processor system gives a",
                "Small system","Tightly coupled system",
                "loosely coupled system",
                2, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q23);
        Question q24= new Question("Logical extension of multiprogramming operating system is",
                "Time sharing","multi-tasking","both a and b",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q24);
        Question q25= new Question("Multiprocessor system have advantage of",
                "Increased Throughput","Expensive hardware",
                "both a and b",
                1, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q25);
        Question q26= new Question("Scheduling of threads are done by",
                "input","output","operating system",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q26);
        Question q27= new Question("Example of open source operating system is",
                "UNIX","Linux","both a and b",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q27);
        Question q28= new Question("Main memory of computer system is known to be",
                "non volatile","volatile","Restricted",
                2, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q28);
        Question q29= new Question("Another type of multiple-CPU system is the",
                "mini Computer","Super Computer","Clustered System",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q29);
        Question q30= new Question("Multiprogramming of computer system increases",
                "memory","storage","CPU utilization",
                3, Question.DIFFICULTY_HARD, Category.PROGRAMMING);
        insertQuestion(q30);




    }
    public void addQuestion(Question question)
    {
        db= getWritableDatabase();
        insertQuestion(question);
    }
    public void addQuestions(List<Question> questions)
    {
        db = getWritableDatabase();
        for( Question question : questions)
        {
            insertQuestion(question);
        }
    }

    private void insertQuestion(Question question)
    {
        ContentValues cv= new ContentValues();
        cv.put(TestContract.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(TestContract.QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(TestContract.QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(TestContract.QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(TestContract.QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(TestContract.QuestionTable.COLUMN_DIFFICULTY,question.getDifficulty());
        cv.put(TestContract.QuestionTable.COLUMN_CATAGORY_ID, question.getCategoryID());
        db.insert(TestContract.QuestionTable.TABLE_NAME,null,cv);
    }
    public List<Category> getAllCategories()
    {
        List<Category> categoryList = new ArrayList<>();
        db= getReadableDatabase();
        Cursor c= db.rawQuery(" SELECT * FROM " + TestContract.CatagoriesTable.TABLE_NAME, null);
         if(c.moveToFirst())
         {
             do {
                     Category category = new Category();
                     category.setId(c.getInt(c.getColumnIndex(TestContract.CatagoriesTable._ID)));
                     category.setName(c.getString(c.getColumnIndex(TestContract.CatagoriesTable.COLUMN_NAME)));
                     categoryList.add(category);

                 }
                 while(c.moveToNext());
             }
             c.close();
             return categoryList;

         }

    public ArrayList<Question> getAllQuestion()
    {
        ArrayList<Question> questionList = new ArrayList<>();
        db= getReadableDatabase();
        Cursor c= db.rawQuery("SELECT * FROM " + TestContract.QuestionTable.TABLE_NAME, null);

        if(c.moveToFirst())
        {
            do{
               Question question = new Question() ;

               question.setId(c.getInt(c.getColumnIndex(TestContract.QuestionTable._ID)));

               question.setQuestion(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(TestContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_DIFFICULTY)));

                question.setCategoryID(c.getInt(c.getColumnIndex(TestContract.QuestionTable.COLUMN_CATAGORY_ID)));
                questionList.add(question);

            }
            while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
    public ArrayList<Question> getAllQuestion(int categoryID, String difficulty)
    {
        ArrayList<Question> questionList = new ArrayList<>();
        db= getReadableDatabase();

        String selection = TestContract.QuestionTable.COLUMN_CATAGORY_ID + " = ? " +
                " AND " + TestContract.QuestionTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor c= db.query(
                TestContract.QuestionTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if(c.moveToFirst())
        {
            do{
                Question question = new Question() ;
                question.setId(c.getInt(c.getColumnIndex(TestContract.QuestionTable._ID)));

                question.setQuestion(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(TestContract.QuestionTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(TestContract.QuestionTable.COLUMN_DIFFICULTY)));

                question.setCategoryID(c.getInt(c.getColumnIndex(TestContract.QuestionTable.COLUMN_CATAGORY_ID)));

                questionList.add(question);

            }
            while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
