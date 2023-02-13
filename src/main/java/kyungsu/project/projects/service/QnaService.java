package kyungsu.project.projects.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kyungsu.project.projects.dto.QnaAnswerDto;
import kyungsu.project.projects.dto.QnaDetailDto;
import kyungsu.project.projects.dto.QnaDetailResponseDto;
import kyungsu.project.projects.dto.QnaInDto;
import kyungsu.project.projects.dto.QnaOutDto;
import kyungsu.project.projects.dto.ResponseDto;
import kyungsu.project.projects.entity.QnaListEntity;
import kyungsu.project.projects.repository.QnaListRepository;

@Service
public class QnaService {
	
	@Autowired QnaListRepository qnaListRepository;
	
	public void qnain(QnaInDto qnaInDto) {
		QnaListEntity qnaListEntity;
		qnaListEntity = new QnaListEntity(qnaInDto);
		
		try {
			qnaListRepository.save(qnaListEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ResponseDto<List<QnaOutDto>> qnaout() {

		//저장소의 카테고리엔티티의 모든값
		List<QnaListEntity> qnaListEntityList = qnaListRepository.findByOrderByNumDesc();
		//dto 뿌려줄 값들.
		List<QnaOutDto> QnaoutDtos = new ArrayList<QnaOutDto>();

		for (QnaListEntity qnalistEntity : qnaListEntityList) {
			QnaoutDtos.add(new QnaOutDto(qnalistEntity));
		}
		System.out.println(QnaoutDtos);
	//responsedto 만들어줘야할듯.
		return ResponseDto.setSuccess(QnaoutDtos);
	}
	
	public ResponseDto<QnaDetailResponseDto> qnadetail(int num) {
		QnaListEntity qnaDD  = qnaListRepository.findById(num).get();
		QnaDetailResponseDto dto = new QnaDetailResponseDto(qnaDD);
		return ResponseDto.setSuccess(dto);
	}
	
	public void qnaAnswer(QnaAnswerDto qnaAnswer) {
		QnaListEntity qnaListAnswer= qnaListRepository.findById(qnaAnswer.getNum()).get();
		qnaListAnswer.setAnswer(qnaAnswer.getAnswer());
		qnaListRepository.save(qnaListAnswer);
		
	}
}
