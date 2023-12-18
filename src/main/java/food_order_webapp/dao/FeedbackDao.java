package food_order_webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_order_webapp.dto.Feedback;

public class FeedbackDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("rakshu").createEntityManager();
	}
	
	public Feedback saveFeedback(Feedback feed) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(feed);
		entityTransaction.commit();
		
		return feed;
	}
	
	public List<Feedback> getAllFeedbacks() 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select f from Feedback f");
		
		return query.getResultList();
	}
}
