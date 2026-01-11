package com.blog.blogging.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.blogging.config.AppConstants;
import com.blog.blogging.payload.ApiResponse;
import com.blog.blogging.payload.PostDto;
import com.blog.blogging.payload.PostResponse;
import com.blog.blogging.service.FileService;
import com.blog.blogging.service.PostService;



@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@Autowired
	private FileService fileService;
	
	@Value ("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		PostDto createPost=this.postservice.createPost(postDto,userId,categoryId);
		
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException{
		
		PostDto postDto=this.postservice.getPostById(postId);
		
		String fileName=this.fileService.uploadImage(path, image);
		
		PostDto updatedPost=this.postservice.updatePost(postDto, postId);
		
		return new ResponseEntity<>(updatedPost,HttpStatus.OK);
		
		
		
		
		
	}
	
	
	//get By User
	   @GetMapping("/user/{userId}/posts")
		public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
			
		List<PostDto> posts=this.postservice.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts , HttpStatus.OK);
		
		}
	   
	 //get By Category
	   @GetMapping("/category/{categoryid}/posts")
		public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryid){
			
		List<PostDto> posts=this.postservice.getPostByCategory(categoryid);
		
		return new ResponseEntity<List<PostDto>>(posts , HttpStatus.OK);
		
		}
	   
	   //get All Posts
	   @GetMapping("/posts")
	   public ResponseEntity<PostResponse> getAllPost(
			   @RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required=false)Integer pageNumber,
			   @RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false)Integer pageSize,
			   @RequestParam(value="sortBy" ,defaultValue=AppConstants.SORT_BY,required=false)String sortBy,
			   @RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR,required=false)String sortDir
			   ){
		   
		  PostResponse postResponse= this.postservice.getAllPost(pageNumber ,pageSize,sortBy,sortDir);
		  return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	   }
	    
	   @GetMapping("/post/{postid}")
	   public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		   
			 PostDto postDto=this.postservice.getPostById(postId);
			  return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
		   }
	   
	   
	   //delete post
	   @DeleteMapping("/posts/{postid}")
	   public ApiResponse deletepost (@PathVariable("postid") Integer postId) {
		   this.postservice.deletePost(postId);
		   return new ApiResponse("post is successfully deleted",true);
		   
	   }
	   
	   //update post
	   @PutMapping("/posts/{postid}")
	   public ResponseEntity<PostDto> updatepost(@RequestBody PostDto postDto,@PathVariable Integer PostId){
		      PostDto updatepost=this.postservice.updatePost(postDto, PostId);
		      return new ResponseEntity<PostDto>(updatepost,HttpStatus.OK);
	   }
	   
	   @GetMapping("/posts/search/{keywords}")
	   public ResponseEntity<List<PostDto>> searchPosts(@PathVariable String keywords){
		   
		   List<PostDto> result=this.postservice.searchPosts(keywords);
		   return ResponseEntity.ok(result);
	   }
	   
	   

}
