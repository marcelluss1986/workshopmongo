package com.mdss.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mdss.workshopmongodb.domain.Post;
import com.mdss.workshopmongodb.domain.User;
import com.mdss.workshopmongodb.dto.AuthorDto;
import com.mdss.workshopmongodb.repository.PostRepository;
import com.mdss.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User larissa = new User(null, "Larissa", "larissa@gmail.com");
		User marcelo = new User(null, "Marcelo", "marcelo@gmail.com");
		User izabella = new User(null, "Izabella", "izabella@gmail.com");
		
		userRepository.saveAll(Arrays.asList(larissa, marcelo, izabella));
		
		Post post1 = new Post(null, sdf.parse("04/06/2022"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDto(izabella));
		Post post2 = new Post(null, sdf.parse("04/06/2021"), "Bom dia", "Acordei Feliz", new AuthorDto(marcelo));
		Post post3 = new Post(null, sdf.parse("06/06/2022"), "Bora trabalha", "Arduo, mas valeu a pena", new AuthorDto(larissa));
		Post post4 = new Post(null, sdf.parse("05/06/20222"), "O grande dia chegou", "Pé na estrada", new AuthorDto(izabella));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
		
		
		
	}

}
