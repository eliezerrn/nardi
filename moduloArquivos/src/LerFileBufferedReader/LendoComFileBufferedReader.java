package LerFileBufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LendoComFileBufferedReader {

	public void LerComFileBufferedReader(String caminho) {
		//FileReader fileReader = null;
		//BufferedReader bufferReader = null;
		
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(caminho))) {
			//fileReader = new FileReader(caminho);
			//bufferReader = new BufferedReader(fileReader);
			
			String line = bufferReader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = bufferReader.readLine();
			}
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		/*
			finally {
			try {
				if(bufferReader != null) {
					bufferReader.close();					
				}
				if(fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
	}
}
