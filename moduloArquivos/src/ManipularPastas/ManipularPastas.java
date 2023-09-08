package ManipularPastas;

import java.io.File;

public class ManipularPastas {

	public void manipulaPastas(String caminho, String nomeArquivo) {
		
		File pasta = new File(caminho);
		
		//Lendo pastas
		File[] pastas = pasta.listFiles(File::isDirectory);
		
		System.out.println("Pastas");
		for(File itemPasta : pastas) {
			System.out.println(itemPasta);
		}
			
		//Lendo arquivos
		File[] pastas2 = pasta.listFiles(File::isFile);
		
		System.out.println("Pastas");
		for(File itemPasta2 : pastas2) {
			System.out.println(itemPasta2);
		}
		
		//Criando nova pasta
		boolean sucesso = new File(caminho + "\\novaPasta").mkdir();
		System.out.println("pasta criada com sucesso!");
		
		//----------------------------------//
		// Pasta com arquico novo
		File pastaInfo = new File(caminho + "\\" + nomeArquivo);
		
		//buscando o nome do arquivo
		System.out.println("getName: " + pastaInfo.getName());
		
		//buscando o nome do caminho
		System.out.println("getParent: " + pastaInfo.getParent());
		
		//buscando todo o caminho
		System.out.println("getPath: " + pastaInfo.getPath());
	}
}
