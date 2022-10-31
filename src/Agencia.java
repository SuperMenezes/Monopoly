import java.util.HashMap;

public class Agencia {

	private int numero;
	private Banco banco;
	
	private HashMap<Integer, Conta> contas;
	
	public int getNumero() {
		return numero;
	}

	public Agencia(Banco banco, int numero)
	{
		this.banco = banco;
		this.numero = numero;
		this.contas = new HashMap<Integer, Conta>();
		
		System.out.println("Agencia " + this.numero + " criada com sucesso!" );
	}
	
	public Cliente CriarCliente(String documento, String nome)
	{
		Cliente cliente = Cliente.CriarCliente(documento, nome);
		banco.AdicionarClienteGlobal(cliente);
		return cliente;
	}
	
	public Conta AbrirConta(int numeroConta, Cliente cliente) throws Exception
	{
		Conta conta;
		try
		{
			conta = contas.get(numeroConta);
			if(conta == null)
			{
				conta = ContaCorrente.CriarContaCorrente(this, numeroConta, cliente);		
				contas.put(numeroConta, conta);
			}
			else
			{
				throw new Exception("DuplicateAccountException");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return conta;
	}
	
	public boolean TransferirDinheiro(Conta contaOrigem, int numAgenciaDestino, int numContaDestino, double valor) throws Exception
	{
		Agencia agenciaDestino = null;

		//BUSCAR/VALIDAR AGENCIA DESTINO
		try
		{
			agenciaDestino = banco.BuscarAgencia(numAgenciaDestino);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		//BUSCAR/VALIDAR CONTA DESTINO
		Conta contaDestino;
		try
		{
			contaDestino = agenciaDestino.BuscarConta(numContaDestino);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
		//RETIRAR O $$ DA CONTA ORIGEM E DEPOSITAR NA CONTA DESTINO
		if(contaOrigem.Sacar(valor))
		{
			contaDestino.Depositar(valor);
			return true;
		}
		else
		{
			throw new Exception("OutOfMoneyException");
		}
	}
	
	public boolean DepositarDinheiro(int numeroConta, double valor) throws Exception
	{
		Conta conta;
		try
		{
			conta = contas.get(numeroConta);
			if(conta != null)
			{
				conta.Depositar(valor);
			}
			else
			{
				throw new Exception("AccountNotFoundException");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return true;
	}
	
	public boolean SacarDinheiro(int numeroConta, double valor) throws Exception
	{
		Conta conta;
		try
		{
			conta = contas.get(numeroConta);
			if(conta != null)
			{
				if(conta.Sacar(valor))
				{
					return true;
				}
				throw new Exception("OutOfMoneyException");
			}
			else
			{
				throw new Exception("AccountNotFoundException");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	private Conta BuscarConta(int numeroConta) throws Exception
	{
		Conta conta;
		try
		{
			conta = contas.get(numeroConta);
			if(conta == null)
			{
				throw new Exception("AccountNotFoundException");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return conta;
	}
}
