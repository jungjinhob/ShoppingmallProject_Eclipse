package kyungsu.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "set")
@NoArgsConstructor
@Data
public class ResponseDto<D> {
	private boolean result;
	private D data;
	
	public static <D> ResponseDto<D> setSuccess(D data) {
		return ResponseDto.set(true, data);
	}
	
	public static <D> ResponseDto<D> setFailed() {
		return ResponseDto.set(false,  null);
	}
}
