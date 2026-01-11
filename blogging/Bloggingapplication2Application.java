package com.blog.blogging;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.blogging.entities.Category;
import com.blog.blogging.entities.Post;
import com.blog.blogging.entities.User;
import com.blog.blogging.payload.CategoryDto;
import com.blog.blogging.payload.PostDto;
import com.blog.blogging.payload.UserDto;

@SpringBootApplication
public class Bloggingapplication2Application implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Bloggingapplication2Application.class, args);
	}
     
	
	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper=new ModelMapper();
		
		
		
		TypeMap<Post, PostDto> postTypeMap = modelMapper.createTypeMap(Post.class, PostDto.class);
        postTypeMap.addMappings(mapper -> {
            mapper.map(Post::getPostTitle, PostDto::setTitle);
            mapper.map(Post::getContent, PostDto::setContent);
            mapper.map(Post::getImageName, PostDto::setImageName);
            mapper.map(Post::getCategory, PostDto::setCategory); // nested mapping
            mapper.map(Post::getUser, PostDto::setUser);         // nested mapping
        });
        
        modelMapper.createTypeMap(Category.class, CategoryDto.class);

        // User → UserDto mapping
        modelMapper.createTypeMap(User.class, UserDto.class);
        
        modelMapper.typeMap(Post.class, PostDto.class).addMappings(m -> {
            m.map(src -> src.getCategory(), PostDto::setCategory);
            m.map(src -> src.getUser(), PostDto::setUser);
        });
        
        
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("abc2123"));
		
	}
}
