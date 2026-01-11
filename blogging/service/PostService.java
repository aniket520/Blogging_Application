package com.blog.blogging.service;

import java.util.List;

import com.blog.blogging.entities.Post;
import com.blog.blogging.payload.PostDto;
import com.blog.blogging.payload.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost (PostDto postDto ,Integer userId,Integer categoryId);
	
	//update 
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete 
	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPost(Integer pageNumber ,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer CategoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//get all posts by keyword

	List<PostDto> searchPosts(String keyword);
	
	
	

	
	

	
	
	

}
