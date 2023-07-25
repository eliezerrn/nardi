package com.nardi.gdrive;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class OperacoesDrive {

	public String Upload(Drive service, String nome, String extencao, String caminho) throws IOException, GeneralSecurityException {
				 		
		 File fileMetadata = new File();
		 //fileMetadata.setName("photo.jpg");
		 fileMetadata.setName(nome);
	    
		 //File's content.
		 //java.io.File filePath = new java.io.File("files/photo.jpg");
		 java.io.File filePath = new java.io.File(caminho);
	    
	    
		 // Specify media type and file-path for file.
		 FileContent mediaContent = new FileContent(TypeFileContent.type(extencao), filePath);
		 try {
			 File file = service.files().create(fileMetadata, mediaContent)
	         .setFields("id")
	         .execute();
	     
			 System.out.println("File ID: " + file.getId());
	      
			 //return file.getId();
			 
		 } catch (GoogleJsonResponseException e) {			 
			 System.err.println("Unable to upload file: " + e.getDetails());
			 throw e;
	    }
		return null;
	}
	
	public List<File> Listar(Drive service) throws IOException, GeneralSecurityException {
			 		    		
		// Print the names and IDs for up to 10 files.
		FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
		
		return result.getFiles();			
	}
}
