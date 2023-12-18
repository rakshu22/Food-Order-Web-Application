package food_order_webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_order_webapp.dto.UserCart;

public class UserCartDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("rakshu").createEntityManager();
	}
	
	public UserCart saveItemToCart(UserCart userCart) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(userCart);
		entityTransaction.commit();
		
		return userCart;
	}

	public List<UserCart> getAllCartItems() 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserCart u");
		return query.getResultList();
	}


	public List<UserCart> getAllCartItemsByUserEmail(String email) 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserCart u where u.umail=?1");
		query.setParameter(1, email);
		return query.getResultList();
	}

	public UserCart deleteItemFromCart(int cartid) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserCart userCart=entityManager.find(UserCart.class, cartid);
		
		entityTransaction.begin();
		entityManager.remove(userCart);
		entityTransaction.commit();
		
		return userCart;
		
	}

	public void decQuantity(int quantity, int cartid) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserCart userCart=entityManager.find(UserCart.class, cartid);
		
		entityTransaction.begin();
		userCart.setFquantity(quantity);
		entityManager.merge(userCart);
		entityTransaction.commit();
		
	}

	public void incQuantity(int quantity, int cartid) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserCart userCart=entityManager.find(UserCart.class, cartid);
		
		entityTransaction.begin();
		userCart.setFquantity(quantity);
		entityManager.merge(userCart);
		entityTransaction.commit();
	}

}
