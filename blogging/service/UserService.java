package com.blog.blogging.service;

import java.util.List;

import com.blog.blogging.payload.UserDto;

public interface UserService {
	
	
	UserDto createUser(UserDto user);
	
	
	UserDto updateUser(UserDto user,Integer UserId);
	
	UserDto getUserById (Integer userId);
	
	List<UserDto>getAllUsers();
	
	void deleteUser(Integer userId);

}
