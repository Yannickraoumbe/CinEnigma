package com.example.cinenigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Intent toReviews;
    private SQLiteDatabase dbCritiques ;
    private Critiques dbHelper ;
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
        dbHelper = new Critiques(this);
        dbCritiques = dbHelper.getReadableDatabase();
         toReviews = new Intent(this, ListOfReviews.class);


    }
    private void addValuesToDb(String title, String date, String time, Integer nS, Integer nR, Integer nM, String critique) {
        ContentValues values = new ContentValues();
        values.put(CritiquesEntry.MOVIE_TITLE, title);
        values.put(CritiquesEntry.MOVIE_DATE, date);
        values.put(CritiquesEntry.MOVIE_TIME, time);
        values.put(CritiquesEntry.MOVIE_NOTE_SCE, nS);
        values.put(CritiquesEntry.MOVIE_NOTE_REAL, nR);
        values.put(CritiquesEntry.MOVIE_NOTE_MUSIC, nM);
        values.put(CritiquesEntry.MOVIE_CRIT, critique);
        long newRowId = dbCritiques.insert(CritiquesEntry.Critique_TABLE_NAME, null, values);
        System.out.println("On viens d'ajouter une entrée à la ligne " + newRowId);
    }
    public void sendBtnClicked(View view) {
    System.out.println("Tu as ecrit comme title :" + mTitle.getText().toString());
    addValuesToDb(mTitle.getText().toString(),mDate.getText().toString(),mTime.getText().toString(),
            Integer.parseInt(mNoteScenar.getText().toString()), Integer.parseInt(mNoteReal.getText().toString()),Integer.parseInt(mNoteMusique.getText().toString()),
            mCritique.getText().toString());
    }
    public void seeReviews(View view) {
        startActivity(toReviews);
    }
}
