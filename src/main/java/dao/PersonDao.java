package dao;

import java.util.List;

import classes.Person;
import impl.PersonDaoException;

public interface PersonDao {
	
	void createPeopleTable() throws PersonDaoException;
	
	void insertPerson(Person person) throws PersonDaoException;
	
	List<Person> retrievePeople() throws PersonDaoException;
}