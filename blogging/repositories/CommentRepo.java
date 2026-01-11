package com.blog.blogging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogging.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
