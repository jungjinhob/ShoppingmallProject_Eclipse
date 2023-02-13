package jinho.project.projects.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "set")
public class CategoryResponseDto<D> {
	private boolean status;
	private String message;
	private D data;
	
	
	public static <D> CategoryResponseDto<D> setSuccess(String message, D data) {
		return CategoryResponseDto.set(true, message, data);
	}
	
	public static <D> CategoryResponseDto<D> setFailed(String message) {
		return CategoryResponseDto.set(false, message, null);
	}

}
