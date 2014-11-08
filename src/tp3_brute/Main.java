package tp3_brute;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static void geraSaida(List<Mensagem> mensagens) throws FileNotFoundException{
		int id = 1;
		PrintWriter out_file = new PrintWriter("output_bf.txt");
		
		ArrayList<String> lista = new ArrayList<String>();
		String resposta = new String();
		for(int i=0;i<mensagens.size();i++){

			if(id!=mensagens.get(i).id){
				lista.add(resposta);
				resposta = new String();
				id = mensagens.get(i).id;
			}
			resposta = resposta.concat(mensagens.get(i).response);

		}
		lista.add(resposta);
		

		for(int i=0;i<lista.size();i++){
			if(lista.get(i).contains("false")&&lista.get(i).contains("true")){
				out_file.println("both");
				System.out.println("both");
			}
			else{
				if(lista.get(i).contains("false")){
					out_file.println("false");
					System.out.println("false");
				}
				else{
					if(lista.get(i).contains("true")){
						out_file.println("true");
						System.out.println("true");
					}
				}
			}
		}
		out_file.close();
	}


	public static void ordenaMsgs(List<Mensagem> mensagens){
		String resposta = null;
		int id = 1;
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

	public static void geraCombinacoes(List<Mensagem> mensagens){
		for(int i=0;i<mensagens.size();i++){
			for(int j=0;j<mensagens.get(i).msg.length();j++){
				if(mensagens.get(i).msg.charAt(j)=='-'){
					mensagens.add(new Mensagem(mensagens.get(i).id,mensagens.get(i).msg.replaceFirst("-", "0")));
					mensagens.add(new Mensagem(mensagens.get(i).id,mensagens.get(i).msg.replaceFirst("-", "1")));
					mensagens.remove(i);
					i=0;
					j=0;
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
		analisaResposta(mensagens);
		ordenaMsgs(mensagens);
		geraSaida(mensagens);
		
		

		sc.close();
	}
}