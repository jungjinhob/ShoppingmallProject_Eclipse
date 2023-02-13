package jinho.project.projects.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDto {
	private String id;
	private String number;
	private String name;
	private String nickname;
	private String address;
}
