package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		for (Category category : categories) {
			categoryDtos.add(entityToDto(category));
		}
		return categoryDtos;
	}

	private CategoryDto entityToDto(Category entity) {
		return new CategoryDto(entity.getId(), entity.getTitle(), entity.getIcon());
	}
	
	
}
