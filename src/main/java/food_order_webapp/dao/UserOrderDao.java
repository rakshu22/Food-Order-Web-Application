package food_order_webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_order_webapp.dto.UserOrder;
import food_order_webapp.dto.UserOrderItems;

public class UserOrderDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("rakshu").createEntityManager();
	}
	
	public UserOrder saveOrder(UserOrder userOrder)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(userOrder);
		entityTransaction.commit();
		return userOrder;
	}

	//for users
	public List<UserOrder> getAllOrdersByEmail(String cmail) 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserOrder u where u.umail=?1 order by u.datetime desc");
		query.setParameter(1, cmail);
		return query.getResultList();
	}

	//for admin
	public List<UserOrder> getAllOrders() 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserOrder u");
		return query.getResultList();
	}

	public List<UserOrder> getOrdersById(int order_id) 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserOrder u where u.order_id=?1");
		query.setParameter(1, order_id);
		return query.getResultList();
	}

	public void updateOrderStatus(int order_id, String payment_status, String order_status) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserOrder dbOrder=entityManager.find(UserOrder.class, order_id);
		
		entityTransaction.begin();
		dbOrder.setPayment_status(payment_status);
		dbOrder.setOrder_status(order_status);
		entityManager.merge(dbOrder);
		entityTransaction.commit();
		
	}

	public UserOrderItems saveOrderItems(UserOrderItems uItems) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(uItems);
		entityTransaction.commit();
		return uItems;
	}

	public List<UserOrderItems> getAllOrderItemsByEmail(String cmail, String order_ref) 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select u from UserOrderItems u where u.umail=?1 and u.order_ref=?2");
		query.setParameter(1, cmail);
		query.setParameter(2, order_ref);
		return query.getResultList();
	}

	public void updateUserOrderinItems(UserOrder uOrder, String order_ref) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("update UserOrderItems u set u.userOrder=?1 where u.order_ref=?2");
		query.setParameter(1, uOrder);
		query.setParameter(2, order_ref);

	}
}
