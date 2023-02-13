package jinho.project.projects.dto;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;

import jinho.project.projects.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryDto {
	
	private String productName;
	private String price;
	private String urlResource;
	private String category;

	public CategoryDto(CategoryEntity categoryEntity) {
		this.productName = categoryEntity.getProductName();
		this.price = categoryEntity.getPrice();
		this.urlResource = "http://localhost:4040/file/"+ categoryEntity.getImage();
		this.category = categoryEntity.getCategory();
	}
}
