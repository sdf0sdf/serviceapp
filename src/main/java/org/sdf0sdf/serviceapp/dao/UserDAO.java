package org.sdf0sdf.serviceapp.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sdf0sdf.serviceapp.entitites.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public AppUser findByUsername(String username) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("From user where username=:username");
		query.setParameter("username", username);
		AppUser user = (AppUser) query.getSingleResult();
		session.close();
		return user;
	}
}
