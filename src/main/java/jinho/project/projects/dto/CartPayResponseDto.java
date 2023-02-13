package jinho.project.projects.dto;

import jinho.project.projects.entity.CartPayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartPayResponseDto {
	private int orderNumber;
	private String orderImg;
	private String productName;
	private int count;
	private int price;
	private String date;
	private String id;
	private String address;
	public CartPayResponseDto(CartPayEntity cartPayEntity) {
		this.orderNumber = cartPayEntity.getOrderNumber();
		this.orderImg = "http://localhost:4040/file/" + cartPayEntity.getOrderImg();
		this.productName = cartPayEntity.getProductName();
		this.count = cartPayEntity.getCount();
		this.price = cartPayEntity.getPrice();
		this.date = cartPayEntity.getDate();
		this.id = cartPayEntity.getId();
		this.address = cartPayEntity.getAddress();
	}
}
