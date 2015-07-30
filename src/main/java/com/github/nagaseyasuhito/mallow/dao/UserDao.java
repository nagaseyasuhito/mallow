package com.github.nagaseyasuhito.mallow.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.github.nagaseyasuhito.mallow.entity.User;

public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(@Valid User entity) {
		this.entityManager.persist(entity);
	}
}
