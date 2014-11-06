package tp3_brute;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {

	
	public static void getUnidentifiedBit(String linha){
		for(int i=0;i<linha.length();i++){
			if(linha.charAt(i)=='-'){
				System.out.print("- encontrado ");
			
			}
		}
		System.out.println();
	}

	
	public static void main(String args[]) throws FileNotFoundException{
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Scanner sc = new Scanner(new FileReader(args[0]));
		String linha ;
		int entradas = 0;
		entradas = sc.nextInt();
		
		while (sc.hasNext()) {
			mensagens.add(new Mensagem(1,sc.nextLine()));
		}
		for(int i=0;i<mensagens.size();i++){
			mensagens.get(i).imprime();
		}
		
		sc.close();
	}
}