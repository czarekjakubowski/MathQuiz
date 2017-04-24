package com.example.android.mathquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int pointsForQ1 = 0;
    int pointsForQ2 = 0;
    int pointsForQ3 = 0;
    int pointsForQ4 = 0;
    int pointsForQ5 = 0;
    boolean wrongNames = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method counts points in question 1

    public void onRadioButtonClickedQ1(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.q1A:
                if (checked)
                    pointsForQ1 = 0;
                    break;
            case R.id.q1B:
                if (checked)
                    pointsForQ1 = 1;
                    break;
            case R.id.q1C:
                if (checked)
                    pointsForQ1 = 0;
                    break;
            case R.id.q1D:
                if (checked)
                    pointsForQ1 = 0;
                    break;
        }
    }

    //This method counts points in question 2

    public void onRadioButtonClickedQ2(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.q2A:
                if (checked)
                    pointsForQ2 = 0;
                    break;
            case R.id.q2B:
                if (checked)
                    pointsForQ2 = 1;
                    break;
            case R.id.q2C:
                if (checked)
                    pointsForQ2 = 0;
                    break;
            case R.id.q2D:
                if (checked)
                    pointsForQ2 = 0;
                    break;
        }
    }

    // Checking if answer to question 3 is correct

    public void checkingQ3() {
        String Q3RightAnswer = "Fibonacci";
        EditText answer = (EditText) findViewById(R.id.q3answer);
        String q3answer = answer.getText().toString();
        if (q3answer.equals( Q3RightAnswer )) {
            pointsForQ3 = 1;
        } else {
            pointsForQ3 = 0;
        }
    }

    //This method counts points in question 4

    public void onRadioButtonClickedQ4(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.q4A:
                if (checked)
                    pointsForQ4 = 0;
                    break;
            case R.id.q4B:
                if (checked)
                    pointsForQ4 = 0;
                    break;
            case R.id.q4C:
                if (checked)
                    pointsForQ4 = 1;
                    break;
            case R.id.q4D:
                if (checked)
                    pointsForQ4 = 0;
                    break;
        }
    }

    // Checking if all answers in question 5 are correct AND NO WRONG ANSWERS ARE CHOSEN

    public void onCheckboxClicked(View view) {

        int pointForName1 = 0;
        int pointForName3 = 0;
        int pointForName4 = 0;
        int pointForName5 = 0;
        int pointForName8 = 0;
        int pointForName9 = 0;

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        boolean checkbox_1 = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_2);
        boolean checkbox_2 = checkBox2.isChecked();

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_3);
        boolean checkbox_3 = checkBox3.isChecked();

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_4);
        boolean checkbox_4 = checkBox4.isChecked();

        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox_5);
        boolean checkbox_5 = checkBox5.isChecked();

        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkbox_6);
        boolean checkbox_6 = checkBox6.isChecked();

        CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkbox_7);
        boolean checkbox_7 = checkBox7.isChecked();

        CheckBox checkBox8 = (CheckBox) findViewById(R.id.checkbox_8);
        boolean checkbox_8 = checkBox8.isChecked();

        CheckBox checkBox9 = (CheckBox) findViewById(R.id.checkbox_9);
        boolean checkbox_9 = checkBox9.isChecked();

        if (checkbox_2||checkbox_6||checkbox_7)
            wrongNames = true;
        if (checkbox_1)
            pointForName1 = 1;
        if (checkbox_3)
            pointForName3 = 1;
        if (checkbox_4)
            pointForName4 = 1;
        if (checkbox_5)
            pointForName5 = 1;
        if (checkbox_8)
            pointForName8 = 1;
        if (checkbox_9)
            pointForName9 = 1;
        if (!wrongNames) {
            pointsForQ5 = pointForName1 + pointForName3 + pointForName4 + pointForName5 + pointForName8 + pointForName9;
        } else {
            pointsForQ5 = 0;
            wrongNames = false;
        }
    }

    //Method activated when Submit Answers button is pressed.

    public void submitAnswers(View view){
        checkingQ3();
        int score = pointsForQ1 + pointsForQ2 + pointsForQ3 + pointsForQ4 + pointsForQ5;
        String toastText;

        EditText name = (EditText) findViewById(R.id.name_field);
        String username = name.getText().toString();

        if (score < 10) {
            toastText = "Hi " + username + "\n" + "You scored: " + score + " out of 10 points." + "\n" + "Please review Your answers.";
        } else {
            toastText = "Hi " + username + "\n" + "You scored: " + score + " out of 10 points." + "\n" + "Bravo!";
        }

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();

    }

}