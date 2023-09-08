package Programa;

import java.time.LocalDateTime;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import EscreverFileBufferedWriter.EscreverArquivo;
import LerFileBufferedReader.LendoComFileBufferedReader;
import LerScanner.LerComScanner;
import ManipularPastas.ManipularPastas;

public class programa {

	public static void main(String[] args) {

		String caminho ="C:\\Projetos";
		String nomeArquivo = "HELP_GIT.txt";
		String caminhoComNome = caminho + "\\" + nomeArquivo;
		
		
		System.out.println("Lendo com Scanner");
		LerComScanner lerComScanner = new LerComScanner();
		lerComScanner.lerArquivo(caminhoComNome);
		
		System.out.println("----------------------------------------------------");
		System.out.println("Lendo com File buffer");
		System.out.println("----------------------------------------------------");
		LendoComFileBufferedReader lendoComFileBuffer = new LendoComFileBufferedReader();
		lendoComFileBuffer.LerComFileBufferedReader(caminhoComNome);

		System.out.println("----------------------------------------------------");
		System.out.println("Escrevendo");
		System.out.println("----------------------------------------------------");
		EscreverArquivo escrever = new EscreverArquivo();
		
		LocalDateTime dataHora =  LocalDateTime.now();
		String horaEscrita = dataHora.getHour() + "_" +dataHora.getMinute() + "_" +dataHora.getSecond();
		
		escrever.EscreveArquivo(caminho, "ArquivoEscrito" + horaEscrita + ".txt");
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("Manipulando");
		System.out.println("----------------------------------------------------");
		ManipularPastas manipulandoPastas = new ManipularPastas();
		manipulandoPastas.manipulaPastas(caminho, nomeArquivo);
		
	}

}
