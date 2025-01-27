package com.nagarro.bench.docker.advance.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.bench.docker.advance.assignment.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

}
