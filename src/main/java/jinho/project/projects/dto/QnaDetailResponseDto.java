package jinho.project.projects.dto;

import jinho.project.projects.entity.QnaListEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QnaDetailResponseDto {
	private String title;
	private String contents;
	private String id;
	private String date;
	private String answer;
	
	public QnaDetailResponseDto(QnaListEntity qnaDD) {
		this.title = qnaDD.getTitle();
		this.contents = qnaDD.getContents();
		this.id = qnaDD.getId();
		this.date = qnaDD.getDate();
		this.answer = qnaDD.getAnswer();
	}
}
