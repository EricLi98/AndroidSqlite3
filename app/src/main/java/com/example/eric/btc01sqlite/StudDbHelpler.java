package com.example.eric.btc01sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eric on 2017/2/18.
 */

public class StudDbHelpler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="stud.db";
    public static final int DATABASE_VERSION=1;
    public static final String SQL_CREATE_STUDINFO="create table "+StudContract.StudInfo.TABLE_NAME+"("+
            StudContract.StudInfo._ID+" INTEGER PRIMARY KEY,"+ StudContract.StudInfo.COLUMN_NAME_AGE+" INTEGER,"+ StudContract.StudInfo.COLUMN_NAME_NAME+
            " TEXT,"+ StudContract.StudInfo.COLUMN_NAME_HEIGHT+" INTEGER)";

    StudDbHelpler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STUDINFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
