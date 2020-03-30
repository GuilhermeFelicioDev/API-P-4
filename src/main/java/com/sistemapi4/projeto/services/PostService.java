package com.sistemapi4.projeto.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemapi4.projeto.entities.Post;
import com.sistemapi4.projeto.entities.User;
import com.sistemapi4.projeto.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		return obj.get();
	}
	
	public Post insert(Post obj) {
		return repository.save(obj);	
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Post update(Long id, Post obj) {
		Post entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Post entity, Post obj) {
		entity.setTitle(obj.getTitle());
		entity.setBody(obj.getBody());
}

	
	
}
