package ca.qc.bdeb.demo05.models.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import ca.qc.bdeb.demo05.models.database.MyDbHelper;
import ca.qc.bdeb.demo05.models.entities.Person;

public class PersonDAOImpl implements IPersonDAO{
    Context context;
    MyDbHelper dbHelper;

    public PersonDAOImpl(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
    }

    @Override
    public List<Person> getPeople() {
        SQLiteDatabase db  = dbHelper.getReadableDatabase();
        String request = "SELECT * FROM Person";
        Cursor cursor = db.rawQuery(request, null);
        if(cursor != null) {
            List<Person> people = new ArrayList<>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                people.add(new Person(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                cursor.moveToNext();
            }
            return people;
        }
        return null;
    }
}
