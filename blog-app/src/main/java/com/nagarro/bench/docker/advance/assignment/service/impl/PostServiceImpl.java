package com.nagarro.bench.docker.advance.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import com.nagarro.bench.docker.advance.assignment.model.Post;
import com.nagarro.bench.docker.advance.assignment.repository.PostRepository;
import com.nagarro.bench.docker.advance.assignment.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	
	private final PostRepository postRepository;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
	        this.postRepository = postRepository;
	}

	@Override
	@CachePut(value = "posts", key = "#postData.id")
	public Post createPost(Post postData) {
		return postRepository.save(postData);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	@Cacheable(value = "posts", key = "#postId")
	public Post getPostById(String postId) {
		return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
	}

	@Override
	@CachePut(value = "posts", key = "#postId")
	public Post updatePost(String postId, Post updatedPost) {
		Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setSubtitle(updatedPost.getSubtitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setAuthor(updatedPost.getAuthor());
        return postRepository.save(existingPost);
	}

	@Override
	@CacheEvict(value = "posts", key = "#postId")
	public String deletePost(String postId) {
		Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
        postRepository.delete(post);
        return "Post with ID " + postId + " has been deleted.";
	}

}
