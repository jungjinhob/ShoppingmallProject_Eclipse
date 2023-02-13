package kyungsu.project.projects.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailPageListDto {
	private String productName;
	private String logo1;
	private int price; 
	private String info1;
	private String info2;
	private List<String> imgname;
}
