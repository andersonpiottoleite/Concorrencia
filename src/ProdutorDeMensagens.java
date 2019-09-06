import java.util.List;

public class ProdutorDeMensagens implements Runnable{

	private int inicio;
	private int fim;
	//private Collection<String> mensagens;
	//private Vector<String> mensagens;
	//private Set<String> mensagens;
	private List<String> mensagens;
	
	//public ProdutorDeMensagens(int inicio, int fim, Collection<String> mensagens) {
	//public ProdutorDeMensagens(int inicio, int fim, Vector<String> mensagens) {
	//public ProdutorDeMensagens(int inicio, int fim, Set<String> mensagens) {
	public ProdutorDeMensagens(int inicio, int fim, List<String> mensagens) {
	  this.inicio = inicio;
	  this.fim = fim;
	  this.mensagens = mensagens;
	}
	
	@Override
	public void run() {
		for (int i = inicio; i < fim; i++) {
			//synchronized (mensagens) {				
				mensagens.add("Mensagem " + i);
				
			//}
		}
	}

}
