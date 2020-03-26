package com.sistemapi4.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemapi4.projeto.entities.Comment;
import com.sistemapi4.projeto.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {
	
	@Autowired
	private CommentService service;
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAll() {
		List<Comment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Comment> findById(@PathVariable Long id){
		Comment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
