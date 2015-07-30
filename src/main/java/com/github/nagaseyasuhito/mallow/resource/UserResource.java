package com.github.nagaseyasuhito.mallow.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.nagaseyasuhito.mallow.entity.User;
import com.github.nagaseyasuhito.mallow.service.UserService;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Inject
	private UserService userService;

	@PUT
	@Path("{mailAddress}")
	public User register(@PathParam("mailAddress") String mailAddress) {
		return this.userService.register(mailAddress);
	}
}
