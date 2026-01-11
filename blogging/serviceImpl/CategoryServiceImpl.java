package com.blog.blogging.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogging.entities.Category;
import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.repositories.CategoryRepo;
import com.blog.blogging.service.CategoryService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	//create
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

         Category cat=this.modelMapper.map(categoryDto, Category.class);
         
         Category addedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class) ;
	}
    
	//update
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
		
	cat.setCategoryTitle(categoryDto.getCategoryTitle());
	cat.setCategoryDescription(categoryDto.getCategoryDescription());
	
	Category updatedcat=this.categoryRepo.save(cat);
				return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	
	//delete
	
	@Override
	public void deleteCategory(Integer categoryId) {
       
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryid",categoryId));
		
            this.categoryRepo.delete(cat);

	}
	
	//get

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		 Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","category id",categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}
	
	//getCategories

	@Override
	public List<CategoryDto> getCategories() {
		List<Category>categories=this.categoryRepo.findAll();
		List<CategoryDto>catDtos=categories.stream().map((cat)->
		 this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
