package com.sistemapi4.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sistemapi4.projeto.entities.Post;
import com.sistemapi4.projeto.entities.User;
import com.sistemapi4.projeto.repositories.PostRepository;
import com.sistemapi4.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Jao","jao@mail.com","123456");
		User u2 = new User(null,"malia","malia@mail.com","123456");
		
		Post o1 = new Post(null, Instant.parse("2019-06-20T19:53:07Z"),"novo perfil","perfil novo galera", u1);
		Post o2 = new Post(null, Instant.parse("2019-07-21T03:42:10Z"),"viagem para SP","nao recomendo kk", u2);
		Post o3 = new Post(null, Instant.parse("2019-07-22T15:21:22Z"),"mandem os wpp","(64)99999-9999", u1); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		postRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
