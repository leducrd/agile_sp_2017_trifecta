package dao;

import classes.Person;
import impl.PersonDaoException;

public interface PersonDao {
	
	void createDatabase() throws PersonDaoException;
	
	void insertPerson(Person person) throws PersonDaoException;
	
}