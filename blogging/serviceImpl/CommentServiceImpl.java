package com.blog.blogging.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogging.payload.CommentDto;
import com.blog.blogging.repositories.CommentRepo;
import com.blog.blogging.repositories.PostRepo;
import com.blog.blogging.service.CommentService;
import com.blog.blogging.entities.Comment;
import com.blog.blogging.entities.Post;
import com.blog.blogging.exception.ResourceNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		
		Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "postid" ,postId));
		
		Comment comments=this.modelMapper.map(commentDto, Comment.class);
		
		comments.setPost(post);
		
		Comment savedcomment=this.commentRepo.save(comments);
		
		return this.modelMapper.map(savedcomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","commentid",commentId));
		this.commentRepo.delete(com);
		// TODO Auto-generated method stub
		
	}

}
