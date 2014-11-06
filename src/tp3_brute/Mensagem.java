package tp3_brute;

public class Mensagem {
	
	public int id;
	public String msg;
	
	public  Mensagem(int id,String msg){
		this.id = id;
		this.msg = msg;
	}
	
	public void imprime(){
		System.out.println(this.id+" "+msg);
	}
	

}