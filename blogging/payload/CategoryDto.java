package com.blog.blogging.payload;

import lombok.Data;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	
	private String categoryTitle;
	
	
	private String categoryDescription;


	public String getCategoryTitle() {
		// TODO Auto-generated method stub
		return categoryTitle;
	}


	public String getCategoryDescription() {
		// TODO Auto-generated method stub
		return categoryDescription;
	}


	


	


	
	
	

}
