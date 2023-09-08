package Exercicio;

import java.util.Scanner;

public class programaExercicio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean caminhoValido = false;
		
		
		while(caminhoValido != true) {
			System.out.println("*************************************************************************************");
			System.out.println("L A Y O U T:  NOME,VALOR,QUANTIDADE");
			System.out.println("I N F O....: As informações devem ser separadas por virgula!");
			System.out.println("************************************************************************************");
			System.out.println("Informe o caminho com o nome do arquivo .CSV para importação: (OBS.: exit para sair)");
			String caminho = sc.next();
				
			if(caminho != null && caminho.contains(".csv") || caminho.contains(".CSV")) {
				
				ImportarAquivo importador = new ImportarAquivo();				
				caminhoValido = importador.importarArquivo(caminho);	
				
			} else {
				if(caminho.equalsIgnoreCase("exit")) {
					caminhoValido = true;
					System.out.println("Programa encerrado!");
				} else {
					System.out.println("Arquivo invalido, o arquivo precisa ser do formato .csv!");
					System.out.println("");
				}
			}
		}	
	}
}
