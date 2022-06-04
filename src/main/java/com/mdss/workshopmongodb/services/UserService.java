package com.mdss.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdss.workshopmongodb.domain.User;
import com.mdss.workshopmongodb.dto.UserDto;
import com.mdss.workshopmongodb.repository.UserRepository;
import com.mdss.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Not Found"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
