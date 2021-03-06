package com.ksaitarun.udacity_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }
    private void checkQuestionOneAnswers(){
        CheckBox questionOneMario = (CheckBox) findViewById(R.id.checkboxQuest1AnswerMario);
        CheckBox questionOneDonkey = (CheckBox) findViewById(R.id.checkboxQuest1AnswerDonkey);
        CheckBox questionOnePortal = (CheckBox) findViewById(R.id.checkboxQuest1AnswerPortal);
        boolean isQuestionOneMarioChecked = questionOneMario.isChecked();
        boolean isQuestionOneDonkeyChecked = questionOneDonkey.isChecked();
        boolean isQuestionOnePortalChecked = questionOnePortal.isChecked();

        if (isQuestionOneMarioChecked && isQuestionOneDonkeyChecked && !isQuestionOnePortalChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButton1989 = (RadioButton) findViewById(R.id.radio_1989);
        boolean isQuestionTwo1989Checked = radioButton1989.isChecked();
        if (isQuestionTwo1989Checked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userInputLastName = (EditText) findViewById(R.id.answerInputUserLastName);
        String name = userInputLastName.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("croft")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonPortal = (RadioButton) findViewById(R.id.radio_portal);
        boolean isQuestionTwoPortalChecked = radioButtonPortal.isChecked();
        if (isQuestionTwoPortalChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveGameBoy = (CheckBox) findViewById(R.id.checkboxQuest5GameBoy);
        CheckBox questionFivePSP = (CheckBox) findViewById(R.id.checkboxQuestPSP);
        CheckBox questionFiveWii = (CheckBox) findViewById(R.id.checkboxQuest5Wii);
        boolean isQuestionFiveGameBoyChecked = questionFiveGameBoy.isChecked();
        boolean isQuestionFivePSPChecked = questionFivePSP.isChecked();
        boolean isQuestionFiveWiiChecked = questionFiveWii.isChecked();

        if (isQuestionFiveGameBoyChecked && !isQuestionFivePSPChecked && isQuestionFiveWiiChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}
