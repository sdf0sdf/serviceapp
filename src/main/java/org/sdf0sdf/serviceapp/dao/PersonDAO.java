package org.sdf0sdf.serviceapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sdf0sdf.serviceapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Person> index() {
		Session session = this.sessionFactory.openSession();
		List<Person> persons = session.createQuery("select p from Person p", Person.class).getResultList();
		session.close();
		return persons;
	}

	public Person show(int id) {
		Session session = this.sessionFactory.openSession();
		Person person = session.get(Person.class, id);
		session.close();
		return person;
	}

	public void save(Person person) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(person);
		tx.commit();
		session.close();
	}

	public void update(int id, Person updatedPerson) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(updatedPerson);
		tx.commit();
		session.close();
	}

	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Person person = (Person)session.load(Person.class,id);
	    session.delete(person);
		tx.commit();
		session.close();

	}
}