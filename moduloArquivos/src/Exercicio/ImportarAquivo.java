package Exercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImportarAquivo {

	public boolean importarArquivo(String caminho) {
		boolean isImportou = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			
			List<ProdutoModel> listaProdutos = new ArrayList<>();
			
			while(linha != null) {				
				
				String[] linhaSplit = linha.split(",");
				
				String nome = linhaSplit[0] != null ? linhaSplit[0] : "Nome não encontrado";
				BigDecimal valor = linhaSplit[1] != null ? new BigDecimal(linhaSplit[1]):BigDecimal.ZERO;
				BigDecimal quantidade = linhaSplit[2] != null ? new BigDecimal(linhaSplit[2]) : BigDecimal.ZERO;							
				
				listaProdutos.add(new ProdutoModel(nome, valor, quantidade));
				
				linha = br.readLine();
			}
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("-------------------- Produtos importados --------------------");
			for(ProdutoModel produto : listaProdutos) {				
				System.out.println("Produto: " + produto.getNome() + " no valor de R$ )" + produto.getValor().setScale(2) + " com quantidade " + produto.getQuantidade().setScale(0) + ".");				
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------");
					
			isImportou = CriaNovoArquivo( caminho, "out", "summary.csv", listaProdutos);
			
		} catch (Exception  exception) {
			System.out.println("Erro ao importar o arquivo, verifique o arquivo e tente novamente!");
		}
		
		return isImportou;
	}
	
	private boolean CriaNovoArquivo(String caminho, String novaPasta, String nomeArquivo, List<ProdutoModel> listaInfoProdutos) {
		
		boolean isEscreveou = false;
		String somenteCaminho = buscaCaminhoPasta(caminho);
		
		if(!somenteCaminho.isEmpty()) {
			String caminhoArquivoNovo = somenteCaminho + "\\" + novaPasta + "\\" + nomeArquivo;
									
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivoNovo))){
				
				for(ProdutoModel produto : listaInfoProdutos) {
					bw.write(produto.getNome() + "," + produto.getValor().multiply(produto.getQuantidade()).setScale(2));
					bw.newLine();
				}
				
				isEscreveou = true;			
				
			} catch (Exception ex) {
				System.out.println("Erro ao escrever novo arquivo, verifique com o programador!");
			}
						
		} else {
			System.out.println("Erro ao buscar a pasta para salvar!");
		}
		
		return isEscreveou;
	}
	
	private String buscaCaminhoPasta(String caminho) {
		return  new File(caminho).getParent();
	}
}
