package model;

import java.sql.SQLTimeoutException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserServiceImpl {

	public static void main(String[] args) throws SQLTimeoutException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("UserDataManagement");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction txn = entitymanager.getTransaction();
		UserDataToCache udc = new UserDataToCache(entitymanager);
		// udc.fetchUserData(entitymanager);

		Thread thread = new Thread(new UserDataToCache());

		thread.start();
	}

}
