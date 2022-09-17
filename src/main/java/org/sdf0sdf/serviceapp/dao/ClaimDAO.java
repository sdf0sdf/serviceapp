package org.sdf0sdf.serviceapp.dao;

import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sdf0sdf.serviceapp.entitites.Claim;
import org.sdf0sdf.serviceapp.entitites.ClaimsView;
import org.sdf0sdf.serviceapp.entitites.ProductType;
import org.sdf0sdf.serviceapp.entitites.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimDAO {

	@Autowired
	private SessionFactory sessionFactory;

//	public List<ClaimView> index() {
//		Session session = this.sessionFactory.openSession();
//		List<ClaimView> claims = session.createQuery("select NEW ClaimView (c, cp) \n" + 
//				"  from Claim c,\n" + 
//				"       ClaimProgress cp\n" + 
//				" where c.id = cp.claim\n" + 
//				"   and cp.claimprogressdate = \n" + 
//				"   (select max(cps.claimprogressdate) from ClaimProgress cps where cps.claim = c.id)", ClaimView.class).getResultList();
//		session.close();
//		return claims;
//	}

	public List<ClaimsView> index() {
		Session session = this.sessionFactory.openSession();
		List<Claim> claims = session.createQuery("select c \n" + "  from Claim c ", Claim.class).getResultList();
		List<ClaimsView> claimsview = claims.stream().map(x -> new ClaimsView(x)).collect(Collectors.toList());
		session.close();
		return claimsview;
	}

	public ClaimsView show(int id) {
		Session session = this.sessionFactory.openSession();
		Claim claim = session.get(Claim.class, id);
		ClaimsView claimsview = new ClaimsView(claim);
		session.close();
		return claimsview;
	}

	public void save(Claim claim) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(claim);
		tx.commit();
		session.close();
	}

	public void update(Claim updatedClaim) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(updatedClaim);
		tx.commit();
		session.close();
	}

	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Claim claim = (Claim) session.load(Claim.class, id);
		session.remove(claim);
		tx.commit();
		session.close();

	}

	public List<ProductType> getProductTypes() {
		Session session = this.sessionFactory.openSession();
		List<ProductType> producttypes = session
				.createQuery("select pt \n" + "  from ProductType pt ", ProductType.class).getResultList();
		session.close();
		return producttypes;
	}

	public List<ServiceCenter> getServiceCenters() {
		Session session = this.sessionFactory.openSession();
		List<ServiceCenter> servicecenters = session
				.createQuery("select pt \n" + "  from ServiceCenter pt ", ServiceCenter.class).getResultList();
		return servicecenters;
	}

}
