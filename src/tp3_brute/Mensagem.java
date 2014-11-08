package tp3_brute;

public class Mensagem {
	
	public int id;
	public String msg;
	public String response;
	
	public  Mensagem(int id,String msg){
		this.id = id;
		this.msg = msg;
		this.response=null;
	}
	
	public void imprime(){
		System.out.println(this.id+" "+this.msg+" "+this.response);
	}
	

}