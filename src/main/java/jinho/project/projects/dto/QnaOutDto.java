package jinho.project.projects.dto;

import jinho.project.projects.entity.QnaListEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QnaOutDto {
    private int num;
    private String title;
    private String date;
    private String id;
    private String answer;


    public QnaOutDto(QnaListEntity qnaListEntity) {
        this.num = qnaListEntity.getNum();
        this.title = qnaListEntity.getTitle();
        this.date = qnaListEntity.getDate();
        this.id = qnaListEntity.getId();
        this.answer = qnaListEntity.getAnswer();
    }


}
