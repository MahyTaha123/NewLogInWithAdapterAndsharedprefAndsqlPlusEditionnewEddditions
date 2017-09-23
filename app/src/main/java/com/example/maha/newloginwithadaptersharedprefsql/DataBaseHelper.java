package com.example.maha.newloginwithadaptersharedprefsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maha on 22/09/2017.
 *
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notes.db";
    public static final String TABLE_NAME = "notes_table";
    public static final int DATABASE_VERSION = 1;
    public static final String col_1 = "ID";
    public static final String col_2 = "NOTE_MESSAGE";





    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("creat table"+TABLE_NAME+"(" + col_1 +"integer primary key autoincrement"+col_2 +"text"+")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);

    }
}
