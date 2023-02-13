package kyungsu.project.projects.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kyungsu.project.projects.dto.CategoryDto;
import kyungsu.project.projects.dto.CategoryListDto;
import kyungsu.project.projects.dto.CategoryResponseDto;
import kyungsu.project.projects.entity.CategoryEntity;
import kyungsu.project.projects.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired CategoryRepository categoryRepository;
	
	
	public CategoryResponseDto<List<CategoryDto>> getAllCategory() {
		
		List<CategoryEntity> categorylist = categoryRepository.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		
		for (CategoryEntity category : categorylist) {
			categoryDtos.add(new CategoryDto(category));
		}
		
		return CategoryResponseDto.setSuccess("Get User List Success", categoryDtos);
	}
	
	public CategoryResponseDto<CategoryEntity> listUp(CategoryListDto categoryListDto) {
		boolean result;
		result = categoryRepository.existsById(categoryListDto.getProductName());
		if(result) {
			return CategoryResponseDto.setFailed("");
		}
		CategoryEntity categoryEntity = new CategoryEntity(categoryListDto);
		System.out.println(categoryEntity);
		categoryRepository.save(categoryEntity);
		return CategoryResponseDto.setSuccess("", categoryEntity);
	}
	public void delete(String productName) {
		categoryRepository.deleteById(productName);
	}
	


}
