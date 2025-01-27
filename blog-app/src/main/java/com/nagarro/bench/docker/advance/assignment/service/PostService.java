package com.nagarro.bench.docker.advance.assignment.service;

import java.util.List;

import com.nagarro.bench.docker.advance.assignment.model.Post;

public interface PostService {
	
	Post createPost(Post postData);
	List<Post> getAllPosts();
	Post getPostById(String postId);
	Post updatePost(String postId, Post updatedPost);
	String deletePost(String postId);

}
