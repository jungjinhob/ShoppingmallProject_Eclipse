package jinho.project.projects.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryListDto {
	private String productName;
	private int price;
	private List<String> imgname;
	private String category;
}
