package com.mdss.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mdss.workshopmongodb.domain.User;
import com.mdss.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User larissa = new User(null, "Larissa", "larissa@gmail.com");
		User marcelo = new User(null, "Marcelo", "marcelo@gmail.com");
		User izabella = new User(null, "Izabella", "izabella@gmail.com");
		
		userRepository.saveAll(Arrays.asList(larissa, marcelo, izabella));
		
	}

}
