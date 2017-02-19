package com.example.eric.btc01sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.eric.btc01sqlite.StudContract.StudInfo.COLUMN_NAME_AGE;

/**
 * Created by Eric on 2017/2/18.
 */

public class StudDao {
    public static void insert(Student stud, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_AGE, stud.getAge());
        cv.put(StudContract.StudInfo.COLUMN_NAME_NAME, stud.getName());
        cv.put(StudContract.StudInfo.COLUMN_NAME_HEIGHT, stud.getHeight());

        db.insert(StudContract.StudInfo.TABLE_NAME, null, cv);
    }
    public static void update(Student stud, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_AGE, stud.getAge());
        cv.put(StudContract.StudInfo.COLUMN_NAME_NAME, stud.getName());
        cv.put(StudContract.StudInfo.COLUMN_NAME_HEIGHT, stud.getHeight());

        String where= StudContract.StudInfo._ID+"=?";
        String[] args={stud.getId()+""};

        db.update(StudContract.StudInfo.TABLE_NAME, cv,where,args);
    }
    public static ArrayList query(String id, SQLiteDatabase db) {
        ArrayList al=new ArrayList();

        String[] selColumns={StudContract.StudInfo._ID,COLUMN_NAME_AGE,StudContract.StudInfo.COLUMN_NAME_HEIGHT,StudContract.StudInfo.COLUMN_NAME_NAME};
        String where="1=1 ";
        ArrayList<String> args=new ArrayList();
        if(id!=null){
            where+=" and "+StudContract.StudInfo._ID+"=?";
            args.add(id);
        }
        String sortOrder=StudContract.StudInfo.COLUMN_NAME_HEIGHT+" DESC";
        String[] c=args.toArray(new String[] {});
        Cursor cursor=db.query(StudContract.StudInfo.TABLE_NAME,selColumns,where,c,null,null,sortOrder);
        while (cursor.moveToNext()){
            al.add(convert2Stud(cursor));
        }
        cursor.close();
        return al;
    }
    public static void delete(String id, SQLiteDatabase db) {
        ArrayList al=new ArrayList();

        String where="1=1 ";
        ArrayList<String> args=new ArrayList();
        if(id!=null){
            where+=" and "+StudContract.StudInfo._ID+"=?";
            args.add(id);
        }

        String[] c=args.toArray(new String[] {});
        db.delete(StudContract.StudInfo.TABLE_NAME,where,c);

    }
    private static Student convert2Stud(Cursor cursor){
        Student student=new Student();
        student.setId(cursor.getInt(cursor.getColumnIndex(StudContract.StudInfo._ID)));
        student.setName(cursor.getString(cursor.getColumnIndex(StudContract.StudInfo.COLUMN_NAME_NAME)));
        student.setHeight(cursor.getInt(cursor.getColumnIndex(StudContract.StudInfo.COLUMN_NAME_HEIGHT)));
        student.setAge(cursor.getInt(cursor.getColumnIndex(StudContract.StudInfo.COLUMN_NAME_AGE)));
        return student;
    }
}
