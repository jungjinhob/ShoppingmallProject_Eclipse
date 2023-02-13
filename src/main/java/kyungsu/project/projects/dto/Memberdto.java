package kyungsu.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Memberdto {
	private String id;
	private String password;
	private String number;
	private String name;
	private String nickname;

}
