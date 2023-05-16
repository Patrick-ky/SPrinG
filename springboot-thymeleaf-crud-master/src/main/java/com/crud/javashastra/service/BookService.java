package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Cpart;
import com.crud.javashastra.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository repository;

	public List<Cpart> findallcpt() {
		return (List<Cpart>) repository.findAll();
	}

	public Cpart findBookById(int id) {
		Optional<Cpart> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Cpart();
	}

	public Cpart addBook(Cpart book) {
		return repository.save(book);
	}

	public Cpart updateBook(Cpart book) {
		Optional<Cpart> result = repository.findById(book.getId());
		Cpart existing = result.get();
		existing.setBrand(book.getBrand());
		existing.setType(book.getType());
		existing.setQuantity(book.getQuantity());
		existing.setFeatures(book.getFeatures());
		return repository.save(existing);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
