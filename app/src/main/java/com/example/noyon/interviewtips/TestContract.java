package com.example.noyon.interviewtips;

import android.provider.BaseColumns;

public final class TestContract {

    private TestContract()
    {

    }

    public  static class CatagoriesTable implements BaseColumns
    {
        public static final String TABLE_NAME = "test_catagories";
        public static final String COLUMN_NAME = "name";
    }
    public static class QuestionTable implements BaseColumns
    {
        public static final String TABLE_NAME="test_question";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_ANSWER_NR="answer_nr";
        public static final String COLUMN_DIFFICULTY="difficulty";
        public  static final String COLUMN_CATAGORY_ID="catagoryId";
    }
}
