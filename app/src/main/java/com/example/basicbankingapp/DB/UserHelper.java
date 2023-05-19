package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Trilok Patidar', 'tp2134@gmail.com','9484','9977641238', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Akshat Prajapati', 'akshatp34@gmail.com','5558','7641541238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Ravi Bhati', 'bhatiravi@gmail.com','1996','9495945896', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Anurag Kumar', 'anuragkumar221@gmail.com','9952','8895640038', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Priyanka Kumari', 'priyak2@gmail.com','7769','7780648962', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Ishan Roy', 'ishan221@gmail.com','1085','9184640238', 1200)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Dinesh Sharma', 'dinesh192@gmail.com','3007','9522640215', 7200)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Rohit Singh', 'rohits22@gmail.com','5922','7823021539', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ramesh Chandra', 'rameshc12@gmail.com','3582','9293565238', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Urmila Desai', 'urmiladsi@gmail.com','5550','919391201', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anuradha varma', 'anuvarma2@gmail.com','1256','9581641200', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Sunu Singh', 'sonu911@gmail.com','9803','7724641999', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Vasudev Sankla', 'sanklavasudev@gmail.com','1166','8581541001', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Priya Patel', 'priya1212@gmail.com','5436','7295642205', 12500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Sahil Khan', 'sahilk2@gmail.com','1292','8591641266', 9110)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}