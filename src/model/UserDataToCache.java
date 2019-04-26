package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDataToCache implements Runnable {

	public UserDataToCache(EntityManager entitymanager) {
		// TODO Auto-generated constructor stub
	}

	public UserDataToCache() {
		// TODO Auto-generated constructor stub
	}

	// Fetching userinfo from Database and storing into cache
	@SuppressWarnings({ "rawtypes" })
	public HashMap<String, HashMap<String, Long>> fetchUserData(
			EntityManager entitymanager) {
		HashMap<String, HashMap<String, Long>> userCreds = new HashMap<String, HashMap<String, Long>>();
		try {
			javax.persistence.Query qResult = entitymanager
					.createQuery("SELECT m FROM McbUserInfo m");
			entitymanager.setProperty("javax.persistence.cache.storeMode",
					"USE");
			System.out.println("DB Object:" + qResult.getResultList());
			qResult.setHint("javax.persistence.cache.storeMode", "USE");
			Cache cache = entitymanager.getEntityManagerFactory().getCache();

			System.out.println("from cache checking:"
					+ cache.contains(McbUserInfo.class, 8L));
			/*
			 * javax.persistence.Query SerResult =
			 * entitymanager.createQuery("SELECT s FROM McbServicesInfo s");
			 * SerResult.setHint("javax.persistence.cache.storeMode", "USE");
			 */
			System.out.println("DB Object:" + qResult.getResultList());
			List resultList = qResult.getResultList();
			Iterator iterator = resultList.iterator();

			while (iterator.hasNext()) {
				McbUserInfo userData = (McbUserInfo) iterator.next();
				HashMap<String, Long> userObj = new HashMap<String, Long>();
				System.out.println(" UserId:" + userData.getUserId());

				userObj.put(userData.getPasswordHash(), userData.getUserId());

				userCreds.put(userData.getUserName(), userObj);

			}

		}

		catch (Exception e) {
			System.out.println("Exception message :" + e);
		}
		return userCreds;

	}

	// Removing cache and updating the cache
	public void clearCache() throws IOException {

		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("UserDataManagement");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction txn = entitymanager.getTransaction();

		txn.begin();
		javax.persistence.Cache cache = entitymanager.getEntityManagerFactory()
				.getCache();
		System.out.println("from Cache:" + cache);
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("javax.persistence.cache.retrieveMode", "REFRESH");

		McbUserInfo mm = entitymanager.find(McbUserInfo.class, 9L, props);
		System.out.println("mm before evictall:" + mm);
		//Below one is used to debug the cache
		System.out.println("from cache Before evictAll():"
				+ cache.contains(McbUserInfo.class, 14));
		cache.evictAll();

		System.out.println("from cache after evictAll():"
				+ cache.contains(McbUserInfo.class, 1));
		Properties prop=new Properties();
		FileInputStream ip;
		

		try {
			ip = new FileInputStream("config.properties");
			prop.load(ip);
			System.out.println("from property file:"+prop.getProperty("cache.refresh.interval"));
		
			Thread.sleep(Integer.parseInt(prop.getProperty("cache.refresh.interval")));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		fetchUserData(entitymanager);
		System.out.println("from cache After  fetchUserData():"
				+ cache.contains(McbUserInfo.class, 14));
		fetchUserSrvMapInfo(entitymanager);
		
		txn.commit();
		entitymanager.close();

	}

	// Fetching User swrvice Map info from Database and storing into cache
	public HashMap<Long, HashMap<Long, String>> fetchUserSrvMapInfo(
			EntityManager entitymanager) {
		HashMap<Long, HashMap<Long, String>> serviceMapObj = new HashMap<Long, HashMap<Long, String>>();
		try {
			javax.persistence.Query usrSerMap = entitymanager
					.createQuery("SELECT mi FROM McbUserServiceMapInfo mi");
			entitymanager.setProperty("javax.persistence.cache.storeMode",
					"USE");
			System.out.println("DB Object:" + usrSerMap.getResultList());

			usrSerMap.setHint("javax.persistence.cache.storeMode", "USE");

			System.out.println("DB Object:" + usrSerMap.getResultList());
			// System.out.println("index based:"+usrSerMap.getResultList().indexOf(1));
			@SuppressWarnings("rawtypes")
			List resultList = usrSerMap.getResultList();
			@SuppressWarnings("rawtypes")
			Iterator iterator = resultList.iterator();
			HashMap<Long, String> serviceDetails = new HashMap<Long, String>();

			while (iterator.hasNext()) {
				McbUserServiceMapInfo userserviceaccess = (McbUserServiceMapInfo) iterator
						.next();
				System.out.println("record split:" + userserviceaccess);

				serviceDetails.put(userserviceaccess.getId().getServiceId(),
						userserviceaccess.getHasAccess());
				serviceMapObj.put(userserviceaccess.getId().getUserId(),
						serviceDetails);
				System.out.println("serviceDetails:" + serviceDetails);
			}
		} catch (Exception e) {

			System.out.println("Exception Message:" + e.getMessage());
		}
		return serviceMapObj;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			clearCache();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
