package com.blog.blogging.payload;

import java.util.List;


public class PostResponse {
	
	private int pageNumber;
    private int pageSize;
    
    private long totalElements;
    private int totalPages;
    private List<PostDto> content;
    private boolean lastPage;
	@Override
	public String toString() {
		return "PostResponse [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalElements=" + totalElements
				+ ", totalPages=" + totalPages + ", content=" + content + "]";
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public void setLastPage(boolean last) {
		this.lastPage=lastPage;
		// TODO Auto-generated method stub
		
	}
}
