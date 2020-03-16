package com.example.afiq.sigh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 = "Bookdatabase.db";
    public static final String TABLE_NAME2 = "book_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "IC";
    public static final String COL_4 = "TEL";
    public static final String COL_5 = "HALL";
    public static final String COL_6 = "DATE";
    public static final String COL_7 = "PURPOSE";
    private SQLiteDatabase db;

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME2, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+  TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, IC TEXT, TEL INTEGER, HALL TEXT, DATE TEXT, PURPOSE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertData(String name, String ic, String tel, String hall, String date, String purpose){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,ic);
        contentValues.put(COL_4,tel);
        contentValues.put(COL_5,hall);
        contentValues.put(COL_6,date);
        contentValues.put(COL_7,purpose);
        long result = db.insert(TABLE_NAME2, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME2,null);
        return res;
    }

//    public String searchPass(String uname) {
//        db = this.getReadableDatabase();
//        String query = "select uname, pass from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);
//        String a, b;
//        b = "not found";
//        if (cursor.moveToFirst()) {
//            do {
//                a = cursor.getString(0);
//                if (a.equals(uname)) {
//                    b = cursor.getString(1);
//                    break;
//                }
//            }
//            while (cursor.moveToNext());
//        }
//        return b;
//    }

    public boolean updateData(String id, String name,String ic, String tel, String hall,String date, String purpose){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,ic);
        contentValues.put(COL_4,tel);
        contentValues.put(COL_5,hall);
        contentValues.put(COL_6,date);
        contentValues.put(COL_7,purpose);
        db.update(TABLE_NAME2, contentValues, "id = ?" ,new String[]{id});
        return true;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "ID = ?", new String[]{id});

    }

}
