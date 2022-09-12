package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Category;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.CategoryRepository;

@Service	
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Category insert(Category obj) {
		return categoryRepository.save(obj);
	}

	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

	public Category update(Long id, Category obj) {
		Category entity = categoryRepository.getReferenceById(id);
		updateData(entity, obj);
		return categoryRepository.save(entity);
	}

	private void updateData(Category entity, Category obj) {
		entity.setWeekPrice(obj.getWeekPrice());
		entity.setDayPrice(obj.getDayPrice());
	}
}
