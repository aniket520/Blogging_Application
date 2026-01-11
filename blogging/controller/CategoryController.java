package com.blog.blogging.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogging.payload.ApiResponse;
import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory =this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
	
		CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto, catId);
		
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);

}
	//delete
	@DeleteMapping("/{catId}")
	public void deletecategory(@PathVariable Integer catId){
		
		this.categoryService.deleteCategory(catId);
		
//		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!",true));
	}
   
	//get
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto>getcategory(@PathVariable Integer catId){
		
		CategoryDto categoryDto=this.categoryService.getCategory(catId);
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	//getAll
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>getcategories(){
		List<CategoryDto>categories=this.categoryService.getCategories();
		
		return ResponseEntity.ok(categories);
		
	}

}
