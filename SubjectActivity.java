package com.example.studymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SubjectActivity extends AppCompatActivity {

    private TextView txtSubjectName;
    private TextView txtExplanation;
    private EditText editQuiz;
    private EditText editAssignment;
    private EditText editFinal;
    private final String tag = "Lifecycle Step";

    private String subjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        txtSubjectName = findViewById(R.id.txtSubjectName);
        txtExplanation = findViewById(R.id.txtExplanation);
        editQuiz = findViewById(R.id.editQuiz);
        editAssignment = findViewById(R.id.editAssignment);
        editFinal = findViewById(R.id.editFinal);

        Intent intent = getIntent();
        subjectName = intent.getStringExtra("subjectName");
        String explanation = intent.getStringExtra("explanation");

        txtSubjectName.setText(subjectName);
        txtExplanation.setText(explanation);

        Log.d(tag, "In the onCreate() event");
    }

    public void showResult(View view) {
        String quizText = editQuiz.getText().toString().trim();
        String assignmentText = editAssignment.getText().toString().trim();
        String finalText = editFinal.getText().toString().trim();

        if (quizText.isEmpty()) {
            quizText = "0";
        }
        if (assignmentText.isEmpty()) {
            assignmentText = "0";
        }
        if (finalText.isEmpty()) {
            finalText = "0";
        }

        double quiz = Double.parseDouble(quizText);
        double assignment = Double.parseDouble(assignmentText);
        double finalExam = Double.parseDouble(finalText);

        double total = quiz + assignment + finalExam;
        String result = total >= 50 ? "Pass" : "Fail";

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("subjectName", subjectName);
        intent.putExtra("quiz", quiz);
        intent.putExtra("assignment", assignment);
        intent.putExtra("finalExam", finalExam);
        intent.putExtra("total", total);
        intent.putExtra("result", result);
        startActivity(intent);
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
