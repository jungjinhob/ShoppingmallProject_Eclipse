package jinho.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {
	private String productName;
	private int price;
	private int count2;
	private String image;
	private String id;
}
