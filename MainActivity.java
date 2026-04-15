package com.example.studymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editCustomSubject;
    private EditText editCustomExplanation;
    private final String tag = "Lifecycle Step";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCustomSubject = findViewById(R.id.editCustomSubject);
        editCustomExplanation = findViewById(R.id.editCustomExplanation);

        Log.d(tag, "In the onCreate() event");
    }

    public void openMath(View view) {
        openSubjectScreen("Mathematics", "This subject contains algebra, equations, and problem solving.");
    }

    public void openAndroid(View view) {
        openSubjectScreen("Android", "This subject explains activities, layouts, intents, and manifest.");
    }

    public void openOS(View view) {
        openSubjectScreen("Operating Systems", "This subject explains processes, memory, scheduling, and files.");
    }

    public void addCustomSubject(View view) {
        String subject = editCustomSubject.getText().toString().trim();
        String explanation = editCustomExplanation.getText().toString().trim();

        if (subject.isEmpty()) {
            subject = "New Subject";
        }

        if (explanation.isEmpty()) {
            explanation = "No explanation added.";
        }

        openSubjectScreen(subject, explanation);
    }

    private void openSubjectScreen(String subjectName, String explanation) {
        Intent intent = new Intent(this, SubjectActivity.class);
        intent.putExtra("subjectName", subjectName);
        intent.putExtra("explanation", explanation);
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
