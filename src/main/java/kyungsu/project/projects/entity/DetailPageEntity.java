package kyungsu.project.projects.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kyungsu.project.projects.dto.DetailPageListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "detailpage")
@Entity(name = "detailpage")
public class DetailPageEntity {
	
	@Id
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
	
	public DetailPageEntity(DetailPageListDto detailPageListDto) {
		this.productName = detailPageListDto.getProductName();
		this.logo1 = detailPageListDto.getLogo1();
		this.logo2 = detailPageListDto.getProductName();
		this.price = detailPageListDto.getPrice();
		this.info1 = detailPageListDto.getInfo1();
		this.info2 = detailPageListDto.getInfo2();
		this.imag1 = detailPageListDto.getImgname().get(0);
		this.imag2 = detailPageListDto.getImgname().get(1);
		this.imag3 = detailPageListDto.getImgname().get(2);
		this.imag4 = detailPageListDto.getImgname().get(3);
		this.imag5 = detailPageListDto.getImgname().get(0);
		
	}
}
