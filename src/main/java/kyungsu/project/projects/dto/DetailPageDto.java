package kyungsu.project.projects.dto;

import kyungsu.project.projects.entity.DetailPageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailPageDto {
	private String productName;
	private String logo1;
	private String logo2;
	private int price;
	private String info1;
	private String info2;
	private String imag1;
	private String imag2;
	private String imag3;
	private String imag4;
	private String imag5;

	public DetailPageDto(DetailPageEntity pageEntity) {
		this.productName = pageEntity.getProductName();
		this.logo1 = pageEntity.getLogo1();
		this.logo2 = pageEntity.getLogo2();
		this.price = pageEntity.getPrice();
		this.info1 = pageEntity.getInfo1();
		this.info2 = pageEntity.getInfo2();
		this.imag1 = "http://localhost:4040/file/"+ pageEntity.getImag1();
		this.imag2 = "http://localhost:4040/file/"+ pageEntity.getImag2();
		this.imag3 = "http://localhost:4040/file/"+ pageEntity.getImag3();
		this.imag4 = "http://localhost:4040/file/"+ pageEntity.getImag4();
		this.imag5 = "http://localhost:4040/file/"+ pageEntity.getImag5();
	}
}
