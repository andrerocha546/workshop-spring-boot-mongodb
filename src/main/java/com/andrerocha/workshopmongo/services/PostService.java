package com.andrerocha.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrerocha.workshopmongo.domain.Post;
import com.andrerocha.workshopmongo.repository.PostRepository;
import com.andrerocha.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	//INSTANCIAR ALTOMATICAMENTE UM OBJETO
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	
}
