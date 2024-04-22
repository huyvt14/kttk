package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CCCDMayDoc;
import com.example.demo.service.CCCDMayDocService;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import jakarta.servlet.http.HttpSession;
@Controller
public class CCCDController {
	private final CCCDMayDocService cccdMayDocService;
	private static final String DDCCCD ="src/main/resources/static/anhCCCD/";
	private static final String DDCD ="src/main/resources/static/anhCD/";
	private static final String DDD ="src/main/resources/static/dem/";
	
    CCCDController(CCCDMayDocService cccdMayDocService) {
        this.cccdMayDocService = cccdMayDocService;
    }
    @GetMapping("/xemchitiet")
    String xuLyXemChiTiet(HttpSession session, @RequestParam("muc") String m) {
    	int mohinh_id = (int) session.getAttribute("mohinh_id");
    	ArrayList<CCCDMayDoc> lcc = cccdMayDocService.xemChiTiet(m, mohinh_id);
    	session.setAttribute("lcc", lcc);
    	session.setAttribute("m", m);
    	System.out.println(lcc.toString());
    	return "xemchitiet";
    }
    
//chức năng 2    
    @GetMapping("/chonanh")
    String goiTrangChonAnh() {
    	return "chonanh";
    }

    @PostMapping("/cccd")
    String xuLyLuuCCCD(HttpSession session, @ModelAttribute("cc") CCCDMayDoc cccdmd ) {
    	
    	return "chonanh";
    }
    
    @GetMapping("/dem/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) throws IOException {
        File serverFile = new File(DDD+ imageName);
        return Files.readAllBytes(serverFile.toPath());
    }

    @GetMapping("/cccd")
    String xuLyHuy(HttpSession session) {
    	String fileName = (String)session.getAttribute("fileName");
    	Path filePath = Paths.get(DDD).resolve(fileName);
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("xóa thành công");
            } else {
            	System.out.println("đường dẫn sai");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return "chonanh";
    }
    @PostMapping("/chonanh/cccd")
    String xuLyChonAnh(@RequestParam("file") MultipartFile file, HttpSession session, Model model) {
    	if (!file.isEmpty()) {
            try {
            	String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
            	String fileName = System.currentTimeMillis() + "_" + originalFileName;
            	session.setAttribute("fileName", fileName);
			  
            	Path uploadPath = Paths.get(DDD);
            	System.out.println(fileName);
			
            	if (!Files.exists(uploadPath)) {
            		Files.createDirectories(uploadPath);
            	}
            	try (InputStream inputStream = file.getInputStream()) {
            		Files.copy(inputStream, uploadPath.resolve(fileName));
            		System.out.print("ghi thành công");
            		inputStream.close();
            	
			   	} catch (IOException e) {
			   		e.printStackTrace();
			   		return "chonanh";
			   	}
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
                body.add("file", new ByteArrayResource(file.getBytes()) {
                    @Override
                    public String getFilename() {
                        return fileName; 
                    }
                });
                HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
                String url = "http://localhost:5000/laythongtin";
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
                String tt = response.getBody();
                System.out.println("Response body: " + tt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    	CCCDMayDoc cc = cccdMayDocService.tiemKiemCCCDMayDoc(1);
    	model.addAttribute("cc", cc);
    	System.out.print(cc.toString());
    	return "chinhsuathongtin";
    }
    
    
    
    
    
    
//    @PostMapping("/test/testapi1")
//    public String goiapi() throws IOException {
//    	RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//        String imagePath = "src/main/resources/static/dem/1713226391760_2.jpg";
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("file", new FileSystemResource(imagePath)); 
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//
//        String url = "http://localhost:5000/laythongtin";
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        System.out.println("Response body: " + response.getBody());
//         return "trangchu";
//    }
//    
    
//    @GetMapping("/testapi")
//    public String getStringFromApi() {
//        String apiUrl = "http://localhost:8081/congviec/sukien/1"; // Thay thế URL bằng URL thực tế của API
//        
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(apiUrl, String.class);
//        System.out.println(response);
//        // Xử lý response ở đây nếu cần
//        return "trangchu";
//    }
}
