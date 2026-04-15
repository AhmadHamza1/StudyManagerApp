package com.example.studymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtResultSubject;
    private TextView txtQuizMark;
    private TextView txtAssignmentMark;
    private TextView txtFinalMark;
    private TextView txtTotalMark;
    private TextView txtPassFail;
    private final String tag = "Lifecycle Step";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultSubject = findViewById(R.id.txtResultSubject);
        txtQuizMark = findViewById(R.id.txtQuizMark);
        txtAssignmentMark = findViewById(R.id.txtAssignmentMark);
        txtFinalMark = findViewById(R.id.txtFinalMark);
        txtTotalMark = findViewById(R.id.txtTotalMark);
        txtPassFail = findViewById(R.id.txtPassFail);

        Intent intent = getIntent();

        String subjectName = intent.getStringExtra("subjectName");
        double quiz = intent.getDoubleExtra("quiz", 0);
        double assignment = intent.getDoubleExtra("assignment", 0);
        double finalExam = intent.getDoubleExtra("finalExam", 0);
        double total = intent.getDoubleExtra("total", 0);
        String result = intent.getStringExtra("result");

        txtResultSubject.setText("Subject: " + subjectName);
        txtQuizMark.setText("Quiz: " + quiz);
        txtAssignmentMark.setText("Assignment: " + assignment);
        txtFinalMark.setText("Final Exam: " + finalExam);
        txtTotalMark.setText("Total Grade: " + total);
        txtPassFail.setText("Status: " + result);

        Log.d(tag, "In the onCreate() event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }
}
