package tp3_brute;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static void geraSaida(List<Mensagem> mensagens){
		Collections.sort(mensagens, new Comparator<Mensagem>() {
			@Override
			public int compare(Mensagem  msg1,Mensagem msg2)
			{
				return  Double.compare(msg1.id, msg2.id);
				
			}
		});

	}
	
	
	public static void analisaResposta(List<Mensagem> mensagens){
		for(int i=0;i<mensagens.size();i++){
			if(mensagens.get(i).msg.contains("11111")||mensagens.get(i).msg.contains("000")){
				mensagens.get(i).response="true";
			}
			else{
				mensagens.get(i).response="false";
			}
			
		}
	}
	public static void eliminaDuplicatas(List<Mensagem> mensagens){
		for(int i=0;i<mensagens.size();i++){
			for(int j=0;j<mensagens.size();j++){
				if(mensagens.get(i).msg.equals(mensagens.get(j).msg)&&i!=j&&mensagens.get(i).id==mensagens.get(j).id){
					mensagens.remove(j);
					i=0;
				}		
			}
		}
	}
	public static void eliminaTracos(List<Mensagem> mensagens){
		for(int i = 0;i<mensagens.size();i++){
			for(int j=0;j<mensagens.get(i).msg.length();j++){
				if(mensagens.get(i).msg.charAt(j)=='-'){
					mensagens.remove(i);
					i=0;
				}
			}
		}
	}


	public static void geraCombinacoes(List<Mensagem> mensagens){
		for(int i=0;i<mensagens.size();i++){
			for(int j=0;j<mensagens.get(i).msg.length();j++){
				if(mensagens.get(i).msg.charAt(j)=='-'){
					mensagens.add(new Mensagem(mensagens.get(i).id,mensagens.get(i).msg.replaceFirst("-", "0")));
					mensagens.add(new Mensagem(mensagens.get(i).id,mensagens.get(i).msg.replaceFirst("-", "1")));
					mensagens.remove(i);
					i=0;
				}
			}
		}
	}

	public static void main(String args[]) throws FileNotFoundException{
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		Scanner sc = new Scanner(new FileReader(args[0]));
		sc.nextInt();
		int count = 1;

		while (sc.hasNext()) { 
			mensagens.add(new Mensagem(count++,sc.next()));
		}

		geraCombinacoes(mensagens);
		//eliminaTracos(mensagens);
		//eliminaDuplicatas(mensagens);
		analisaResposta(mensagens);
		geraSaida(mensagens);
		
		
		for(int i=0;i<mensagens.size();i++){
			mensagens.get(i).imprime();
		}

		sc.close();
	}
}