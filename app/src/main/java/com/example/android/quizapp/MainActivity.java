package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float correctAnswers = 0;
    float totalQuestions = 5;
    boolean qOneAnswered = false;
    boolean qTwoAnswered = false;
    boolean qThreeAnswered = false;
    boolean qFourAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void questionOneAnswered(View v) {
        if (v.getId() == R.id.q_one_a) {
            correctAnswers += 1;
        } else {
            if (qOneAnswered) {
                correctAnswers -= 1;
            }
        }
        qOneAnswered = true;
    }

    public void questionTwoAnswered(View v) {
        int i = v.getId();
        if (i == R.id.q_two_a) {
            correctAnswers += 0.33;

        } else if (i == R.id.q_two_b) {
            correctAnswers += 0.33;

        } else if (i == R.id.q_two_d) {
            correctAnswers += 0.34;

        } else {
            if (qTwoAnswered) {
                correctAnswers -= 1;
            }

        }
        qTwoAnswered = true;
    }

    public void questionThreeAnswered(View v) {
        if (v.getId() == R.id.q_three_d) {
            correctAnswers += 1;
        } else {
            if (qThreeAnswered) {
                correctAnswers -= 1;
            }
        }
        qThreeAnswered = true;
    }

    public void questionFourAnswered(View v) {
        if (v.getId() == R.id.q_four_b) {
            correctAnswers += 1;
        } else {
            if (qFourAnswered) {
                correctAnswers -= 1;
            }
        }
        qFourAnswered = true;
    }

    public void submitAnswersTapped(View v) {
        EditText qFive = findViewById(R.id.q_five_answer);
        if (qFive.getText().toString().equalsIgnoreCase("2014")) {
            correctAnswers += 1;
        }
        displayScore();

    }

    private void unCheckAllChildren(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
            }
        }
    }

    private void displayScore() {

        float score = correctAnswers / totalQuestions * 100;
        score = Math.round(score);
        String scoreMessage = "Score: " + score + "%";
        Toast.makeText(MainActivity.this, scoreMessage, Toast.LENGTH_LONG).show();
        resetQuiz();
    }

    private void resetQuiz() {
        RadioGroup one = findViewById(R.id.q_one_group);
        one.clearCheck();

        RadioGroup three = findViewById(R.id.q_three_group);
        three.clearCheck();

        RadioGroup four = findViewById(R.id.q_four_group);
        four.clearCheck();

        LinearLayout checkbox1 = findViewById(R.id.checkbox_question1);
        unCheckAllChildren(checkbox1);

        correctAnswers = 0;
        qOneAnswered = false;
        qTwoAnswered = false;
        qThreeAnswered = false;
        qFourAnswered = false;
    }

}
