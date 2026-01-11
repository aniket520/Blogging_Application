package com.blog.blogging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogging.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
