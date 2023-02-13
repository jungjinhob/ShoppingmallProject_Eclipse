package jinho.project.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jinho.project.projects.dto.QnaAnswerDto;
import jinho.project.projects.dto.QnaDetailDto;
import jinho.project.projects.dto.QnaDetailResponseDto;
import jinho.project.projects.dto.QnaInDto;
import jinho.project.projects.dto.QnaOutDto;
import jinho.project.projects.dto.ResponseDto;
import jinho.project.projects.service.QnaService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/qna")
public class QnaController {
	@Autowired QnaService qnaService;

	@PostMapping("/in")
	public void qnain(@RequestBody QnaInDto inDto) {
		qnaService.qnain(inDto);
	}
	
	@GetMapping("/out")
	public ResponseDto<List<QnaOutDto>> qnaout(){
		System.out.println("sss");
		return qnaService.qnaout();
	}
	
	@GetMapping("/qnadetail/{num}")
	public ResponseDto<QnaDetailResponseDto> qnadetail(@PathVariable("num") int num) {
		return qnaService.qnadetail(num);
	}
	
	@PostMapping("/qnaAnswer")
	public void qnaAnswer(@RequestBody QnaAnswerDto answerDto) {
		qnaService.qnaAnswer(answerDto);
	}
	
	
}
