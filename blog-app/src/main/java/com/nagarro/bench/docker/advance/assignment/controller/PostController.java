package com.nagarro.bench.docker.advance.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nagarro.bench.docker.advance.assignment.model.Post;
import com.nagarro.bench.docker.advance.assignment.service.PostService;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post postData) {
        logger.info("Request received to create a new post: {}", postData);
        Post createdPost = postService.createPost(postData);
        logger.info("Post created successfully with ID: {}", createdPost.getId());
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Request received to fetch all posts");
        List<Post> posts = postService.getAllPosts();
        logger.info("Fetched {} posts successfully", posts.size());
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable String postId) {
        logger.info("Request received to fetch post with ID: {}", postId);
        Post post = postService.getPostById(postId);
        if (post != null) {
            logger.info("Post with ID: {} fetched successfully", postId);
        } else {
            logger.warn("Post with ID: {} not found", postId);
        }
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable String postId, @RequestBody Post updatedPost) {
        logger.info("Request received to update post with ID: {}. Updated data: {}", postId, updatedPost);
        Post post = postService.updatePost(postId, updatedPost);
        logger.info("Post with ID: {} updated successfully", postId);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        logger.info("Request received to delete post with ID: {}", postId);
        String message = postService.deletePost(postId);
        logger.info("Post with ID: {} deleted successfully. Message: {}", postId, message);
        return ResponseEntity.ok(message);
    }
}
