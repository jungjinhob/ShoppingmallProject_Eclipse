package kyungsu.project.projects.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kyungsu.project.projects.dto.CartPayDto;
import kyungsu.project.projects.dto.CartResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cartpay")
@Entity(name = "cartpay")
public class CartPayEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNumber;
	private String orderImg;
	private String productName;
	private int count;
	private int price;
	private String date;
	private String id;
	private String address;
	
	public CartPayEntity(CartResponseDto cartResponseDto , String address) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.orderImg = cartResponseDto.getImage().substring(cartResponseDto.getImage().lastIndexOf("/")+1);
		this.productName = cartResponseDto.getProductName();
		this.count = cartResponseDto.getCount();
		this.price = cartResponseDto.getPrice();
		this.date = simpleDateFormat.format(new Date());
		this.id = cartResponseDto.getId();
		this.address = address;
		
	}
}
