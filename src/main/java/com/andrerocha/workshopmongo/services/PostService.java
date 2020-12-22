package com.andrerocha.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
		//return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSeach(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
