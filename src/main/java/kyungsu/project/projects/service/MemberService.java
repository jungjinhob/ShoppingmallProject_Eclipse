package kyungsu.project.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kyungsu.project.projects.dto.IdResponseDto;
import kyungsu.project.projects.dto.MemberFindIdDto;
import kyungsu.project.projects.dto.MemberFindPasswordDto;
import kyungsu.project.projects.dto.MemberLoginDto;
import kyungsu.project.projects.dto.PasswordResponseDto;
import kyungsu.project.projects.dto.Memberdto;
import kyungsu.project.projects.dto.ResponseDto;
import kyungsu.project.projects.dto.ResultResponseDto;
import kyungsu.project.projects.dto.SignInResponseDto;
import kyungsu.project.projects.dto.UpdateDto;
import kyungsu.project.projects.entity.MemberEntity;
import kyungsu.project.projects.repository.MemberRepository;
import kyungsu.project.projects.security.TokenProvider;

@Service
public class MemberService {
	
	@Autowired MemberRepository memberRepository;
	@Autowired TokenProvider tokenProvider;
	
	public ResultResponseDto SignUp (Memberdto memberdto) {
		try {
			if(memberRepository.existsById(memberdto.getId())) {
				return new ResultResponseDto(false);
			}
		} catch (Exception e) {	
			
		}
		
		try {
			if(memberRepository.existsByNumber(memberdto.getNumber())) {
				return new ResultResponseDto(false);
			}
		} catch (Exception e) {	
			
		}
		MemberEntity memberEntity = MemberEntity
				.builder()
				.id(memberdto.getId())
				.password(memberdto.getPassword())
				.name(memberdto.getName())
				.nickname(memberdto.getNickname())
				.number(memberdto.getNumber())
				.admin(0)
				.build();
		System.out.println(memberEntity);
				
		memberRepository.save(memberEntity);
		return new ResultResponseDto(true);
		
	}
	
	
	public ResponseDto<SignInResponseDto> login(MemberLoginDto memberLogin) {
		MemberEntity memberEntity;
		String id = memberLogin.getId();
		String password = memberLogin.getPassword();
		
		try {
			boolean existed = memberRepository.existsByIdAndPassword(id, password);
			if(!existed) return ResponseDto.setFailed();
		} catch (Exception e) {
			return ResponseDto.setFailed();
		}

		try {
			memberEntity = memberRepository.findById(id).get();
		} catch (Exception e) {
			return ResponseDto.setFailed();
		}
		System.out.println(memberEntity);
		
		memberEntity.setPassword("");
		
		String token = tokenProvider.create(id);
		int exprTime = 3600000;
	
		SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, memberEntity);
		
		return ResponseDto.setSuccess(signInResponseDto);
		
	}
	
	
	public ResponseDto<IdResponseDto> findId(MemberFindIdDto memberFindIdDto) {
		MemberEntity memberEntity = null;
		try {
			List<MemberEntity> member = memberRepository.findByNumber(memberFindIdDto.getNumber());
			memberEntity = member.get(0);
		} catch (Exception e) {
			return ResponseDto.setFailed();
		}
		String number = memberEntity.getName();
		String number2 = memberFindIdDto.getName();
		
		if(number.equals(number2)) {
			IdResponseDto idResponseDto = new IdResponseDto(memberEntity.getId());
			return ResponseDto.setSuccess(idResponseDto);
		}
		
		return ResponseDto.setFailed();
		
	}
	
	
	public ResponseDto<PasswordResponseDto> findPassword(MemberFindPasswordDto memberFindPasswordDto) {
		MemberEntity memberEntity = null;
		try {
			memberEntity = memberRepository.findById(memberFindPasswordDto.getId()).get();
		}catch(Exception e) {
			return ResponseDto.setFailed();
		}
		String name = memberEntity.getName();
		String name2 = memberFindPasswordDto.getName();
		String number = memberEntity.getNumber();
		String number2 = memberFindPasswordDto.getNumber();
		if(name.equals(name2) && number.equals(number2)) {
			PasswordResponseDto memberPassword = new PasswordResponseDto(memberEntity.getPassword());
			return ResponseDto.setSuccess(memberPassword);
 		}
		return ResponseDto.setFailed();
	}
	
	public ResultResponseDto update(UpdateDto updateDto) {
		MemberEntity memberEntity = null;
		int result = 0;
		try {
			result = memberRepository.numberResult(updateDto.getId(), updateDto.getNumber());
			System.out.println(result);
			if(result > 0) {
				return new ResultResponseDto(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			memberEntity = memberRepository.findById(updateDto.getId()).get();
		} catch (Exception e) {
			return new ResultResponseDto(false);
		}
		memberEntity.setName(updateDto.getName());
		memberEntity.setNickname(updateDto.getNickname());
		memberEntity.setNumber(updateDto.getNumber());
		memberEntity.setAddress(updateDto.getAddress());
		
		
		memberRepository.save(memberEntity);
		
		return new ResultResponseDto(true);
	}

	public ResultResponseDto deleteUser(String id) {
		try {
			memberRepository.deleteById(id);
			
		} catch (Exception e) {
			return new ResultResponseDto(false);
		}
		return new ResultResponseDto(true);
	}
}
