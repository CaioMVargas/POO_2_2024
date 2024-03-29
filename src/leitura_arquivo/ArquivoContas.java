package leitura_arquivo;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArquivoContas {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("contas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine()) != null) {
				String v[] = linha.split(",");
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
