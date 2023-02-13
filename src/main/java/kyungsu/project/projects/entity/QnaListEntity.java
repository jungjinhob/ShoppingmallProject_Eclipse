package kyungsu.project.projects.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kyungsu.project.projects.dto.QnaInDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="qnalist")
@Entity(name="qnalist")
public class QnaListEntity {
	@Id
	private int num;
	private String title;
	private String contents;
	private String id;
	private String date;
	private String answer;
	
	
	public QnaListEntity(QnaInDto qnaInDto) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.title = qnaInDto.getTitle();
		this.contents = qnaInDto.getContents();
		this.id = qnaInDto.getId();
		this.date = simpleDateFormat.format(new Date());
		this.answer = "";
	}
}


