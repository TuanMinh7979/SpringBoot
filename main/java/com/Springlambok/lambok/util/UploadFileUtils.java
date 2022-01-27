package com.Springlambok.lambok.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileUtils {
	
	public File handelUploadFile(MultipartFile uploadFile) {
		String folderPath="E:\\SpringProject\\lambok\\lambok\\src\\main\\webapp\\storge";
		File myUploadFolder = new File(folderPath);
		
		//kiem tra thu muc co ton tai neu khong thi tao moi
		if(myUploadFolder.exists()) {
			System.out.println("tao thu muc moi ");
			//tao thu muc moi
			myUploadFolder.mkdir();
		}
		
	     File savedFile= null; 
	     try {
	    	 savedFile= new File(myUploadFolder, uploadFile.getOriginalFilename());
			uploadFile.transferTo(savedFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println("luu file thanh cong");
	     return savedFile;
	}
	
}
