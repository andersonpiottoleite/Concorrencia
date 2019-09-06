import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GuardadorDeMensagens {

	public static void main(String[] args) throws InterruptedException {

		//Collection<String> mensagens = new ArrayList<String>();
		//Vector<String> mensagens = new Vector<String>();
		//Set<String> mensagens = new HashSet<String>();
		List<String> mensagens = new LinkedList<String>();
		ProdutorDeMensagens produtorDeMensagens = new ProdutorDeMensagens(0, 10000, mensagens);
		ProdutorDeMensagens produtorDeMensagens2 = new ProdutorDeMensagens(10000, 20000, mensagens);
		ProdutorDeMensagens produtorDeMensagens3 = new ProdutorDeMensagens(20000, 30000, mensagens);

		Thread t = new Thread(produtorDeMensagens);
		Thread t2 = new Thread(produtorDeMensagens2);
		Thread t3 = new Thread(produtorDeMensagens3);

		t.start();
		t2.start();
		t3.start();

		// faz a thread do main esperar a execução dessas.
		t.join();
		t2.join();
		t3.join();

		for (int i = 0; i < 15000; i++) {
			if (!mensagens.contains("Mensagem " + i)) {
				throw new IllegalArgumentException("Não encontrei a msg: " + i);
			}
		}

		if (mensagens.contains(null)) {
			throw new IllegalArgumentException("Não deveria haver nulo aqui");
		}
		
		System.out.println("Fim da execução");

	}

}
