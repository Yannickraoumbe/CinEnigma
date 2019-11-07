package com.example.cinenigma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mTitle;
    private Button sendBtn ;
    private EditText mDate ;
    private EditText mTime ;
    private EditText mNoteScenar ;
    private EditText mNoteReal ;
    private EditText mNoteMusique ;
    private EditText mCritique ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = (EditText) findViewById(R.id.movieTitle);
        sendBtn = (Button) findViewById(R.id.sendButton);
        mDate = (EditText) findViewById(R.id.movieDate);
        mTime = (EditText) findViewById(R.id.movieTime);
        mNoteScenar = (EditText) findViewById(R.id.noteScenar);
        mNoteReal = (EditText) findViewById(R.id.noteRealisation);
        mNoteMusique = (EditText) findViewById(R.id.noteMusique);
        mCritique  = (EditText) findViewById(R.id.movieCritique);
    }
    public void sendBtnClicked(View view) {
    System.out.println("Tu as ecrit comme title :" + mTitle.getText().toString());
    }

}
