
public class ContaCorrente extends Conta {

	private ContaCorrente(Agencia agencia, int numeroConta, Cliente cliente) {
		super(agencia, numeroConta, cliente);
	}
	
	public static ContaCorrente CriarContaCorrente(Agencia agencia, int numeroConta, Cliente cliente)
	{
		return new ContaCorrente(agencia, numeroConta, cliente);
	}

}
