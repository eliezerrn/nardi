package LerScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerComScanner {
	
	public void lerArquivo(String caminho) {
		
		File arquivo = new File(caminho);
		Scanner sc = null;
		
		try {
			sc = new Scanner(arquivo);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(sc!= null) {
				sc.close();;
			}
		}
 	}

}
