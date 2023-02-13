package jinho.project.projects.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileService {
	
	@Value("${file.dir}")
	private String dir;
	
	public Resource getImage(String imageName) {
		try {
			return new UrlResource("file:" + dir + imageName);
		} catch (Exception e) {
			return null;
		}
	}
	public String fileUpload(MultipartFile file) {
		// file이 있는지 검사
		if(file.isEmpty()) return null;
		// Original file name 가져옴
		String originalFileName = file.getOriginalFilename();
		// 확장자를 가져옴 (img.png)
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		// 저장할때 이름으로 사용되는 UUID 생성
		String uuid = UUID.randomUUID().toString();
		// 실제로 저장되는 이름 생성
		String saveName = uuid + extension;
		// 파일이 저장된 실제 경로
		String savePath = dir + saveName;
		try {
			file.transferTo(new File(savePath));
		} catch (Exception e) {
			return null;
		}
		
		return saveName;
	}
}
