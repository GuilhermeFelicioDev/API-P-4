package com.sistemapi4.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sistemapi4.projeto.entities.Comment;
import com.sistemapi4.projeto.entities.Post;
import com.sistemapi4.projeto.entities.User;
import com.sistemapi4.projeto.repositories.CommentRepository;
import com.sistemapi4.projeto.repositories.PostRepository;
import com.sistemapi4.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Jao","jao@mail.com","123456");
		User u2 = new User(null,"malia","malia@mail.com","123456");
		
		Post o1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"),"novo perfil","perfil novo galera", u1);
		Post o2 = new Post(null, Instant.parse("2019-07-21T03:42:10Z"),"viagem para SP","nao recomendo kk", u2);
		Post o3 = new Post(null, Instant.parse("2019-07-22T15:21:22Z"),"mandem os wpp","(64)99999-9999", u1); 
		
		Comment c1 = new Comment(null, Instant.parse("2019-06-20T19:53:07Z"),"e ae cara", o1);
		Comment c2 = new Comment(null, Instant.parse("2019-07-22T15:23:22Z"),"(34)98888-8888", o3);
		Comment c3 = new Comment(null,Instant.parse("2019-07-22T15:27:22Z"),"(34)97777-7777",  o3); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		postRepository.saveAll(Arrays.asList(o1,o2,o3));
		commentRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}
	
}
