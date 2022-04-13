package com.zensar.training.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zensar.training.bean.Person;
import com.zensar.training.db.PersonDAO;

public class PersonService {

	    @Autowired
		PersonDAO dao;
		
		public PersonDAO getDao() {
			return dao;
		}

		public void setDao(PersonDAO dao) {
			this.dao = dao;
		}

		public Person addPerson(Person person) {
			Person person1=null;
			person1=dao.save(person);//not found save the record
			return person1;
		}
		
		public Person updatePerson(Person person) {
			Person person1=null;
			person1=dao.save(person);//if found update the record
			return person1;
		}
		public boolean deletePerson(Person person ) {
			boolean result=true;
			try {
				dao.delete(person);
			}catch(Exception e) {
				e.printStackTrace();
				result = false;
			}
			return result;
		}
		public Person findById(int id) {
			Optional<Person> optional;//Predefined interface in java.util package 
			optional =dao.findById(id);
			if(optional.isPresent())
				return optional.get();
			else
				return null;
		}
		public List<Person> findAllPersons() {
			return this.dao.findAll();
		}
	}

