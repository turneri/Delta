package fi.jimihautamaki.delta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper2 extends SQLiteOpenHelper {
    public DBhelper2( Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails (PvM2 INT primary key, penkki INT, vinopenkki INT, peckdeck INT, kasipaino INT, hauistalja INT, vipunostotsivu INT, ojentajaez INT, ojentajatalja INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata (String PvM2, String penkki, String vinopenkki, String peckdeck, String kasipaino, String hauistalja, String vipunostosivu, String ojentajaez, String ojentajatalja)
    {
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("PvM", PvM2);
        contentValues.put ("ylatalja", penkki);
        contentValues.put ("kulmapaino", vinopenkki);
        contentValues.put ("alatalja", peckdeck);
        contentValues.put ("kasipaino", kasipaino);
        contentValues.put ("hauistalja", hauistalja);
        contentValues.put ("hauisEZ", vipunostosivu);
        contentValues.put ("hauistalja", ojentajaez);
        contentValues.put ("hauisEZ", ojentajatalja);
        long result=DB.insert("Userdetails", null, contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Boolean updateuserdata (String PvM2, String penkki, String vinopenkki, String peckdeck, String kasipaino, String hauistalja, String vipunostosivu, String ojentajaez, String ojentajatalja)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("ylatalja", penkki);
        contentValues.put ("kulmapaino", vinopenkki);
        contentValues.put ("alatalja", peckdeck);
        contentValues.put ("kasipaino", kasipaino);
        contentValues.put ("hauistalja", hauistalja);
        contentValues.put ("hauisEZ", vipunostosivu);
        contentValues.put ("hauistalja", ojentajaez);
        contentValues.put ("hauisEZ", ojentajatalja);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where PvM = ?", new String[]{PvM2});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{PvM2});
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
