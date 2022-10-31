
public interface IConta {
	
	boolean Sacar(double valor);
	
	boolean Depositar(double valor);
	
	boolean Transferir(int agenciaDestino, int contaDestino, double valor);
	
	void ImprimirExtrato();

}
