package food_order_webapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_order_webapp.dto.AdminMenu;

public class AdminDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("rakshu").createEntityManager();
	}
	
	public void addItem(AdminMenu adminMenu) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(adminMenu);
		entityTransaction.commit();
		
		
	}

	public AdminMenu getItemById(int id) 
	{
		
		EntityManager entityManager=getEntityManager();
		AdminMenu dbAdminMenu=entityManager.find(AdminMenu.class, id);
		
		return dbAdminMenu;
	}

	public void updateItem(AdminMenu adminMenu) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(adminMenu);
		entityTransaction.commit();
		
	}

	public List<AdminMenu> getAllItems() 
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from AdminMenu a");
		
		return query.getResultList();
	}

	public AdminMenu deleteItemById(int id) 
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		AdminMenu adminMenu=entityManager.find(AdminMenu.class, id);
		
		entityTransaction.begin();
		entityManager.remove(adminMenu);
		entityTransaction.commit();
		
		return adminMenu;
		
	}	
}
