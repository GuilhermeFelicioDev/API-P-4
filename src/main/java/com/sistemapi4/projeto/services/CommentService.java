package com.sistemapi4.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemapi4.projeto.entities.Comment;
import com.sistemapi4.projeto.entities.Post;
import com.sistemapi4.projeto.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	public List<Comment> findAll(){
		return repository.findAll();
	}
	
	public Comment findById(Long id) {
		Optional<Comment> obj = repository.findById(id);
		return obj.get();
	}
	public Comment insert(Comment obj) {
		return repository.save(obj);	
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Comment update(Long id, Comment obj) {
		Comment entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Comment entity, Comment obj) {
		entity.setText(obj.getText());
	}
}
