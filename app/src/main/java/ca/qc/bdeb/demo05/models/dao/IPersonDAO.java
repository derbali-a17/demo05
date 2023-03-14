package ca.qc.bdeb.demo05.models.dao;

import java.util.List;

import ca.qc.bdeb.demo05.models.entities.Person;

public interface IPersonDAO {
    List<Person> getPeople();
}
