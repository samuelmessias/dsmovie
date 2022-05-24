package com.example.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dsmovie.dto.MovieDTO;
import com.example.dsmovie.entities.Movie;
import com.example.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		 Page<Movie> result = repository.findAll(pageable);
		 return result.map(x -> new MovieDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		 Optional<Movie> obj = repository.findById(id);
		 Movie entity = obj.orElseThrow();
		 return new MovieDTO(entity);
	}

}
