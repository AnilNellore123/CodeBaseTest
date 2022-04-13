package com.zensar.training.bean;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="persons20")
@XmlRootElement
public class Person {

	
		@Id
		@GeneratedValue
		int id;
		String name;
		LocalDate dateOfBirth;
		Gender gender;
		
		public Person(String name, LocalDate dateOfBirth, Gender gender) {
			super();
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			
		}
		public Person(int id, String name, LocalDate dateOfBirth, Gender gender) {
			super();
			this.id = id;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			
		}
		public Person() {
			super();
		}
		
		public Person(int id) {
			super();
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		
		
		
		
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			return id == other.id;
		}
			
	}

