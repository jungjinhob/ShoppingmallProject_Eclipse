package kyungsu.project.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kyungsu.project.projects.service.FileService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/file/")
public class FileContoroller {
	
	@Autowired FileService fileService;
	
	@GetMapping(value = "{imageName}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
	public Resource getImag(@PathVariable("imageName") String imagName) {
		return fileService.getImage(imagName);
	}
	
	@PostMapping("upload")
	// @ReqestParam(filed명) : RequestBody에서 특정 필드를 받아옴
	// Request body에 파일을 받아 올땐 MultipartFile 인스턴스로 받음
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		return fileService.fileUpload(file);
	}

}
