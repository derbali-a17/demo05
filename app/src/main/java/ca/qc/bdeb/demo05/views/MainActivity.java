package ca.qc.bdeb.demo05.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ca.qc.bdeb.demo05.R;
import ca.qc.bdeb.demo05.models.dao.IPersonDAO;
import ca.qc.bdeb.demo05.models.dao.PersonDAOImpl;
import ca.qc.bdeb.demo05.models.database.MyDbHelper;
import ca.qc.bdeb.demo05.models.entities.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IPersonDAO dao = new PersonDAOImpl(this);
        List<Person> people = dao.getPeople();
        for (Person p:
             people) {
            Log.d("DBTest", p.toString());
        }
    }
}