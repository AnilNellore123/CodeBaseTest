package com.zensar.training.db;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.training.bean.Person;
@Repository
public abstract class PersonDAO implements JpaRepository<Person,Integer>{

	

	}

