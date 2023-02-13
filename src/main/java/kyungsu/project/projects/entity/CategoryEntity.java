package kyungsu.project.projects.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kyungsu.project.projects.dto.CategoryListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "category")
@Table(name = "category")
public class CategoryEntity {
	@Id
	private String productName;
	private String price;
	private String image;
	private String category;
	public CategoryEntity(CategoryListDto categoryListDto) {
		this.productName = categoryListDto.getProductName();
		this.price = categoryListDto.getPrice() + "원";
		this.image = categoryListDto.getImgname().get(0);
		this.category = categoryListDto.getCategory();
	}
}
