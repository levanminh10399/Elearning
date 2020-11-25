package com.myclass.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class ApiCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public Object get() {
		List<CategoryDto> categoryDtos = categoryService.getAll();
		return new ResponseEntity<Object>(categoryDtos,HttpStatus.OK);
	}
}
