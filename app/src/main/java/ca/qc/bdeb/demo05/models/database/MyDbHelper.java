package ca.qc.bdeb.demo05.models.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "demo05.db";
    public static final int DB_VERSION = 1;

    public MyDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Person(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, gender TEXT)");
        //un jeu de données initiales
        db.execSQL("INSERT INTO Person (name, gender) VALUES ('Alfred Smith', 'Male')");
        db.execSQL("INSERT INTO Person (name, gender) VALUES ('Suzanne Lajoie', 'Female')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Person");
        this.onCreate(db);
    }
}
