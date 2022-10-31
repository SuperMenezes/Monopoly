
public abstract class Conta implements IConta {

	private Agencia agencia;
	private int numeroConta;
	private Cliente cliente;
	private double saldo;
	
	protected static String tipoConta;
	
	public Conta(Agencia agencia, int numeroConta, Cliente cliente)
	{
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.cliente = cliente;
		this.saldo = 0;
		
		System.out.println("Conta " + numeroConta + " criada na agencia " + agencia.getNumero());
	}
	
	@Override
	public boolean Sacar(double valor) {
		if(valor <= saldo)
		{
			saldo -= valor;
			return true; 
		}
		return false;
	}

	@Override
	public boolean Depositar(double valor) {
		this.saldo += valor;
		return true;
	}
	
	@Override
	public boolean Transferir(int agenciaDestino, int contaDestino, double valor) {
		try
		{
			this.agencia.TransferirDinheiro(this, agenciaDestino, contaDestino, valor);
		}
		catch(Exception e)
		{
			
		}
		return true;
	}
	
	@Override
	public void ImprimirExtrato() {
		System.out.println("-----------------------");
		System.out.println("Agencia: " + agencia.getNumero());
		System.out.println("Conta:   " + numeroConta);
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Saldo:   R$ " + saldo);
		System.out.println("-----------------------");
	}

}
