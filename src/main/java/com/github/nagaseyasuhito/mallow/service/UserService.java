package com.github.nagaseyasuhito.mallow.service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import com.github.nagaseyasuhito.mallow.dao.UserDao;
import com.github.nagaseyasuhito.mallow.entity.User;

@Transactional
public class UserService {

	@Inject
	private UserDao userDao;

	public User register(@NotNull String mailAddress) {
		User user = new User();
		user.setMailAddress(mailAddress);

		this.userDao.persist(user);
		return user;
	}
}
