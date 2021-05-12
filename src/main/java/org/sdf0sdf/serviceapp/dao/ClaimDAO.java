package org.sdf0sdf.serviceapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sdf0sdf.serviceapp.entitites.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Claim> index() {
		Session session = this.sessionFactory.openSession();
		List<Claim> claims = session.createQuery("select c from Claim c", Claim.class).getResultList();
		session.close();
		return claims;
	}
	
	public Claim show(int id) {
		Session session = this.sessionFactory.openSession();
		Claim claim = session.get(Claim.class, id);
		session.close();
		return claim;
	}
	
	public void save(Claim claim) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(claim);
		tx.commit();
		session.close();
	}
	
	public void update(int id, Claim updatedClaim) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(updatedClaim);
		tx.commit();
		session.close();
	}
	
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Claim claim = (Claim)session.load(Claim.class,id);
	    session.delete(claim);
		tx.commit();
		session.close();

	}
}
