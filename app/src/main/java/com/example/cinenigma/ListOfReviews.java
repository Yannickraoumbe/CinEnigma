package com.example.cinenigma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListOfReviews extends AppCompatActivity {
    private TextView resultatsTxtView;
    private ArrayList<review> items ;
    private Critiques dataBaseHelper;
    private SQLiteDatabase db;
    private Integer idIndex;
    private Cursor cursor;
    private Button revenir;
    private Intent goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_reviews);
        dataBaseHelper = new Critiques(this);
        db = dataBaseHelper.getReadableDatabase();
        resultatsTxtView = (TextView) findViewById(R.id.Results);
        getAllReviews();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private void getAllReviews() {
        items = new ArrayList<review>();
        cursor = db.query(CritiquesEntry.Critique_TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        //final int idIndex = cursor.getColumnIndex(CritiquesEntry._ID);

        final int titleIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_TITLE);
        final int dateIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_DATE);
        final int timeIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_TIME);
        final int notesRIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_NOTE_REAL);
        final int noteSIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_NOTE_SCE);
        final int notesMIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_NOTE_MUSIC);
        final int critiqueIndex = cursor.getColumnIndex(CritiquesEntry.MOVIE_CRIT);
        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            review r = new review(
                    cursor.getString(titleIndex),
                    cursor.getString(dateIndex),
                    cursor.getString(timeIndex),
                    cursor.getInt(noteSIndex),
                    cursor.getInt(notesRIndex),
                    cursor.getInt(notesMIndex),
                    cursor.getString(critiqueIndex)
            );
            items.add(r);
        }
        cursor.close();
        ShowReviews();
    }

    public void ReturnToForm(View view) {
        finish();
    }
    public void ShowReviews() {
        for (review reviews : items) {
            resultatsTxtView.append("\n le film :" + reviews.title + "a des notes en réalisation :" + reviews.noteReal + ", en Scenario : " + reviews.noteSCe + ", en musique :" + reviews.noteMusique);
        }
    }
}

 class review {
    String title;
    String Date;
    String Time ;
    Integer noteReal;
    Integer noteMusique;
    Integer noteSCe;
    String Critique;
    public review(String t, String d, String tm, Integer nS, Integer nR, Integer nM, String c) {
        this.title = t; this.Date = d ; this.Time = tm; this.noteSCe = nS ; this.noteReal = nR; this.noteMusique = nM; this.Critique = c ;
    }
}
