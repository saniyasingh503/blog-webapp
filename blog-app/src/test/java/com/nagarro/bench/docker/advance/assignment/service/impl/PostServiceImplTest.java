package com.nagarro.bench.docker.advance.assignment.service.impl;

import com.nagarro.bench.docker.advance.assignment.model.Post;
import com.nagarro.bench.docker.advance.assignment.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        post = new Post("1", "Title", "Subtitle", "Content", "Author");
    }

    @Test
    void createPost_ShouldSavePost() {
        when(postRepository.save(any(Post.class))).thenReturn(post);

        Post savedPost = postService.createPost(post);

        assertNotNull(savedPost);
        assertEquals("1", savedPost.getId());
        verify(postRepository, times(1)).save(post);
    }
    
    @Test
    void getAllPosts_ShouldReturnListOfPosts() {
        List<Post> posts = postService.getAllPosts();

        assertNotNull(posts);
//        assertFalse(posts.isEmpty());
    }

    // More test methods here...

}
