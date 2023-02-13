package jinho.project.projects.dto;

import jinho.project.projects.entity.CartEntity;
import jinho.project.projects.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	private int num;
	private String productName;
	private int price;
	private int count;
	private String image;
	private String id;
	
	public CartResponseDto(CartEntity cartDto) {
		this.productName = cartDto.getProductName();
		this.price = cartDto.getPrice();
		this.count = cartDto.getCount();
		this.image = "http://localhost:4040/file/" + cartDto.getImage();
		this.id = cartDto.getId();
		

}
}