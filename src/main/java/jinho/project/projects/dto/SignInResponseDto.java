package jinho.project.projects.dto;

import jinho.project.projects.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInResponseDto {
	private String token;
	private int exprTime;
	private MemberEntity memberEntity;
}
