package com.github.nagaseyasuhito.mallow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7774377784725988851L;

	private Integer id;
}
