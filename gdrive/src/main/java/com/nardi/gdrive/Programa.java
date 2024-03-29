package com.nardi.gdrive;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
public class Programa {
	
	 private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";	  
	  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	  private static final String TOKENS_DIRECTORY_PATH = "tokens";
	  private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
	  private static final String CREDENTIALS_FILE_PATH = "/credencials.json";

	  public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
	      throws IOException {
		  
	    // Load client secrets.
	    InputStream in = Programa.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
	    
	    if (in == null) throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);	   
	    
	    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	    // Build flow and trigger user authorization request.
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
	        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	        .setAccessType("offline")
	        .build();
	    
	    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
	    Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");

	    return credential;
	  }

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
		        				 .setApplicationName(APPLICATION_NAME)
		        				 .build();
		
		OperacoesDrive ODrive = new OperacoesDrive();
		
		//Faz upload
		ODrive.Upload(service, "download.jpg", "jpg", "D:\\arquvosDrive\\download.jpg");
		
		//L� arquivos
		List<File> arquivos = ODrive.Listar(service);
		
		if (arquivos == null || arquivos.isEmpty()) {
			System.out.println("Sem arquivos");
		} else {
			System.out.println("Files:");
		    for (File file : arquivos) {
		        System.out.printf("%s (%s)\n", file.getName(), file.getId());
		    }
		}			
	}
}
