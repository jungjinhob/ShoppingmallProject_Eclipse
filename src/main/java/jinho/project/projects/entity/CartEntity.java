package jinho.project.projects.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import jinho.project.projects.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cart")
@Entity(name = "cart")
public class CartEntity {
	
	@Id
	private int num;
	private String productName;
	private int price;
	private int count;
	private String image;
	private String id;
	
	public CartEntity(CartDto cartDto) {
		this.productName = cartDto.getProductName();
		this.price = cartDto.getPrice();
		this.count = cartDto.getCount2();
		this.image = cartDto.getImage();
		this.id = cartDto.getId();
		
	}
}
