package EscreverFileBufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {

	public void EscreveArquivo(String caminho, String nomeArquivo) {
		
		//new FileWriter(caminho) // Aqui Sempre cria arquico novo
		//new FileWriter(caminho, true) // Aqui adiciona no arquivo.
		
		String[] linhas = new String[] {"Bom dia", "Boa tarde", "Boa noite"};
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho + "\\" + nomeArquivo))){
			for(String lin : linhas) {
				bw.write(lin);
				bw.newLine();
			}
		} catch (IOException e){
			System.out.println(e.getStackTrace());
		}
		
	}
}
