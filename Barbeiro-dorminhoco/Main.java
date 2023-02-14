public class Main
{
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		String[] entrada = {"5", "2", "1"};
		System.out.printf("Iniciando salao com %d barbeiros, %d clientes e tamanho da fila = %d %n", Integer.parseInt(entrada[1]), Integer.parseInt(entrada[0]), Integer.parseInt(entrada[2]));
		pool.main(entrada);
	}
}
