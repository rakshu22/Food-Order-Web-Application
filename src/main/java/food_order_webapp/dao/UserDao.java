package food_order_webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_order_webapp.dto.User;

public class UserDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("rakshu").createEntityManager();
	}
	
	public void saveUser(User user) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
	}

	public List<User> getAllUser() 
	{
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select u from User u");
		
		return query.getResultList();
	}

	public User getUserByEmail(String email) 
	{
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		User user=(User) query.getSingleResult();
		
		return user;
	}

	public User getUserById(int id) 
	{
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select u from User u where u.id=?1");
		query.setParameter(1, id);
		User user=(User) query.getSingleResult();
		
		return user;
	}

	public void updateUser(User user) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		
	}

	public List<User> getRemainingUser(int id) 
	{
		EntityManager entityManager=getEntityManager();
		Query query= entityManager.createQuery("select u from User u where u.id!=?1");
		query.setParameter(1, id);
		
		return query.getResultList();
	}

	public void updateAddressandPhone(int userid, String address, long phone) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User dbUser=entityManager.find(User.class, userid);
		
		entityTransaction.begin();
		dbUser.setAddress(address);
		dbUser.setPhone(phone);
		entityManager.merge(dbUser);
		entityTransaction.commit();
	}

	

}
