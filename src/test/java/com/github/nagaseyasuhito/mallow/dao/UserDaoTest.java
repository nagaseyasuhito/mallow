package com.github.nagaseyasuhito.mallow.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.nagaseyasuhito.mallow.entity.User;
import com.google.common.collect.Maps;

public class UserDaoTest {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void before() {
		// overriding original persistence.xml
		Map<String, String> properties = Maps.newHashMap();
		properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
		properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:;DB_CLOSE_DELAY=-1");
		properties.put("javax.persistence.jdbc.user", "");
		properties.put("javax.persistence.jdbc.password", "");
		properties.put("javax.persistence.jtaDataSource", "");

		properties.put("eclipselink.logging.level", "WARNING");
		properties.put("eclipselink.logging.level" + ".sql", "FINE");
		properties.put("eclipselink.ddl-generation", "create-tables");

		this.entityManagerFactory = Persistence.createEntityManagerFactory("mallow", properties);
	}

	@After
	public void after() {
		this.entityManagerFactory.close();
	}

	@Test
	public void persistSuccess() {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		User user = new User();
		user.setMailAddress("mallow@example.com");
		entityManager.persist(user);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
