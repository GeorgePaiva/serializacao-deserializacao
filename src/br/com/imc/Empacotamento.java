package br.com.imc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Empacotamento {

	// serialização: gravando o objetos no arquivo binário "nomeArq"
	// realiza o processo de serialização, transformando o estado de um objeto em memória para uma sequência de bytes
	// gravando no arquivo binário indicado pelo parâmetro nomeArq todos os objetos do ArrayList lista
	public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
		File arq = new File(nomeArq);
		try {
			arq.delete();
			arq.createNewFile();

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(lista);
			objOutput.close();

		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
		}
	}
	
	

	// desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
	// metodo lerArquivoBinario realizar o processo de desserialização
	public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
		ArrayList<Object> lista = new ArrayList();
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				lista = (ArrayList<Object>) objInput.readObject();
				objInput.close();
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}

		return (lista);
	}

}