package com.blog.blogging.repositories;
import com.blog.blogging.entities.Category;
import com.blog.blogging.entities.Post;
import com.blog.blogging.entities.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepo extends JpaRepository<Post,Integer>{
	
	List<Post>findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String keyword);

}
