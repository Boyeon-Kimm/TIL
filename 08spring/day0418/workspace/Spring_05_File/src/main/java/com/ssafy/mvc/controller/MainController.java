package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@Autowired
	private ServletContext sevletContext;
	
	// resource 경로를 가져오기 위해서 사용한다.
	@Autowired
	private ResourceLoader resLoader;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("regist")
	public String registForm(){
		return "regist";
	}
	
	// upload라는 이름으로 POST요청이 날아온다
	@PostMapping("upload")
	public String upload(MultipartFile upload_file, Model model) {
		// 실제 저장될 위치 가져와
		String uploadPath = sevletContext.getRealPath("/upload");
		// 만약에 등록하려고 하는 upload 폴더가 없을 수도 있다.
		File folder = new File(uploadPath);
		if(!folder.exists())
			folder.mkdir(); // 폴더 없으면 만들어
		
		// 실제 파일 이름 가져와
		String fileName = upload_file.getOriginalFilename();
		// target이라는 이름으로 File 객체 생성
		// uploadPath에다가 fileName으로 등록을 하겠다.
		File target = new File(uploadPath, fileName);
		
		// 파일을 해당 폴더에 저장하자
		// 저장 방법은 크게 2가지
		// 1. FileCopyUtils
		// 2. File 인스턴스를 이용
		
		try {
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileName", fileName);
		
		return "result";
	}
	
	// postMapping으로 올라올건데
	@PostMapping("upload2")
	public String upload2(MultipartFile[] upload_files, Model model) throws IOException {
		
		// 파일들의 이름을 저장할 리스트를 생성하자 (임시)
		List<String> list = new ArrayList<>();
		
		// null이 아니면 이렇게 사전에 작업을 해주는게 사실 조금 더 안전함.
		// 업로드파일이 null이 아니라면
		if(upload_files != null) {
			Resource res = resLoader.getResource("resources/upload");
			if(!res.getFile().exists())
				res.getFile().mkdir();
			
			// 지금은 단순하게 upload라고 하는 폴더에 파일을 그대로 저장하고 있다.
			// 폴더 구조 2023-04-18 구조를 잡고 저장하는 것이 조금 더 있어보인다.
			// 파일 이름도 실제로 저장할 때는 OriginName과 저장할 이름 두가지로 나누어서 저장을 하는 것도 하나의 방법이다.
			// 같은 이름을 저장하면 덮어버리기 때문에...
			
			for(MultipartFile mfile : upload_files) {
				// 조금 더 커팅해보자면
				if(mfile.getSize() > 0) { // 파일이 있으면...
					mfile.transferTo(new File(res.getFile(), mfile.getOriginalFilename()));
					list.add(mfile.getOriginalFilename());
				}
					
			}
		}
		
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	@GetMapping("download")
	public String download(Model model, String fileName) { // model 바구니 만들어주기
		Map<String, Object> fileInfo = new HashMap<>();
		
		// map에다가 filename을 집어넣고 
		// downloadFile이라는 이름으로 fileInfo를 넣어서 model 객체에 실어서 보내겠다
		fileInfo.put("fileName", fileName);
		
		// 폴더 구조 이름
		// 원래 파일 이름
		// 지금 파일 이름 ... 등등 잔뜩 넣어서 downLoadView에서 컨트롤을 해라
		
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownLoadView";
	}
	

	
}
