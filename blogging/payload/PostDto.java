package com.blog.blogging.payload;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.blogging.entities.Category;
import com.blog.blogging.entities.Comment;
import com.blog.blogging.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	 private String title;
	 
	 private String content;
	 
	 private String imageName;
	 
	 private Date adddedDate;
	 
	 private CategoryDto category;
	 
	 private UserDto user;
	 
	 private List<CommentDto> comments=new ArrayList();
	 
	 
	 public Integer getPostId() {
		 return postId;
	 }
	 public void setPostId(Integer postId) {
		 this.postId=postId;
	 }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAdddedDate() {
		return adddedDate;
	}

	public void setAdddedDate(Date adddedDate) {
		this.adddedDate = adddedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostDto [title=" + title + ", content=" + content + ", imageName=" + imageName + ", adddedDate="
				+ adddedDate + ", category=" + category + ", user=" + user + "]";
	}

}