package com.blog.blogging.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getAbout() {
		// TODO Auto-generated method stub
		return about;
	}

	

}
