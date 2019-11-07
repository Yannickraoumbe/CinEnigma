package com.example.cinenigma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.StaticLayout;


public final class Critiques extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CRITIQUES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CRITIQUES);
        onCreate(db);
    }
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CinEnigma.db";
    public Critiques(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_CRITIQUES = "CREATE TABLE " + CritiquesEntry.Critique_TABLE_NAME + " (" +
            CritiquesEntry._ID + " INTEGER PRIMARY KEY," +
            CritiquesEntry.MOVIE_TITLE + " TEXT, " +
            CritiquesEntry.MOVIE_DATE + " TEXT, " +
            CritiquesEntry.MOVIE_TIME + " TEXT, " +
            CritiquesEntry.MOVIE_NOTE_SCE + " INTEGER, " +
            CritiquesEntry.MOVIE_NOTE_REAL + " INTEGER, " +
            CritiquesEntry.MOVIE_NOTE_MUSIC + " INTEGER, " +
            CritiquesEntry.MOVIE_CRIT + " TEXT ) ;" ;
    private static final String SQL_DELETE_CRITIQUES = "DROP TABLE IF EXISTS " + CritiquesEntry.Critique_TABLE_NAME;
    // Critiques is the contract

}

class CritiquesEntry implements BaseColumns {
    public static final String Critique_TABLE_NAME = "Critiques";
    public static final String MOVIE_TITLE = "movie_title";
    public static final String MOVIE_DATE  = "movie_date";
    public static final String MOVIE_TIME = "movie_time";
    public static final String MOVIE_NOTE_SCE = "movie_note_sce";
    public static final String MOVIE_NOTE_REAL = "movie_note_real";
    public static final String MOVIE_NOTE_MUSIC = "movie_note_music";
    public static final String MOVIE_CRIT = "movie_crit";
}