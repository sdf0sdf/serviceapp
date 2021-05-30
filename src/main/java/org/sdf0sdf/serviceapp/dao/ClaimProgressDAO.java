package org.sdf0sdf.serviceapp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sdf0sdf.serviceapp.entitites.ClaimProgress;
import org.sdf0sdf.serviceapp.entitites.ClaimStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimProgressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ClaimProgress> show(int claimId) {
		Session session = this.sessionFactory.openSession();
		List<ClaimProgress> claimprogress = session
				.createQuery("select cp \n" + "  from ClaimProgress cp where claim_id = :claimId ", ClaimProgress.class)
				.setParameter("claimId", claimId).getResultList();
		session.close();
		return claimprogress;
	}

	public void save(ClaimProgress claimprogress) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(claimprogress);
		tx.commit();
		session.close();
	}

	public List<ClaimStatus> getClaimStatuses() {
		Session session = this.sessionFactory.openSession();
		List<ClaimStatus> claimstatuses = session
				.createQuery("select pt \n" + "  from ClaimStatus pt ", ClaimStatus.class).getResultList();
		session.close();
		return claimstatuses;
	}
}
