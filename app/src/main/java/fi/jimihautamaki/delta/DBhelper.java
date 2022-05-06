package fi.jimihautamaki.delta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper( Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails (PvM INT primary key, ylatalja INT, kulmapaino INT, alatalja INT, kasipaino INT, hauistalja INT, hauisEz INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata (String PvM, String ylatalja, String kulmapaino, String alatalja, String kasipaino, String hauistalja, String hauisEz)
    {
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("PvM", PvM);
        contentValues.put ("ylatalja", ylatalja);
        contentValues.put ("kulmapaino", kulmapaino);
        contentValues.put ("alatalja", alatalja);
        contentValues.put ("kasipaino", kasipaino);
        contentValues.put ("hauistalja", hauistalja);
        contentValues.put ("hauisEZ", hauisEz);
                long result=DB.insert("Userdetails", null, contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Boolean updateuserdata(String PvM, String ylatalja, String kulmapaino, String alatalja, String kasipaino, String hauistalja, String hauisEz)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("ylatalja", ylatalja);
        contentValues.put ("kulmapaino", kulmapaino);
        contentValues.put ("alatalja", alatalja);
        contentValues.put ("kasipaino", kasipaino);
        contentValues.put ("hauistalja", hauistalja);
        contentValues.put ("hauisEZ", hauisEz);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where PvM = ?", new String[]{PvM});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{PvM});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}
