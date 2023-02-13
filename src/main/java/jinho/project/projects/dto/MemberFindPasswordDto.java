package jinho.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberFindPasswordDto {
	private String id;
	private String name;
	private String number;
}
