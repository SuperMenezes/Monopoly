import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Banco {
	
	private String nome;
	
	private HashMap<Integer, Agencia> agencias;
	private List<Cliente> clientes;

	public Banco(String nome)
	{
		this.nome = nome;
		agencias = new HashMap<Integer, Agencia>();
		clientes = new ArrayList<Cliente>();
		
		
		System.out.println("Banco " + this.nome + " criado com sucesso");
	}
	
	public boolean CriarAgencia(int numero)
	{
		Agencia agencia;
		try
		{
			agencia = agencias.get(numero);
			
			if(agencia == null)
			{
				agencia = new Agencia(this, numero);
				agencias.put(numero, agencia);
			}
			else
			{
				System.out.println("Agencia " + numero +" ja existe");
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public Agencia BuscarAgencia(int numero) throws Exception
	{
		Agencia agencia;
		try
		{
			agencia = agencias.get(numero);
			if(agencia == null)
			{
				throw new Exception("AgenciaNotFoundException");
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return agencia;
	}
	
	public void AdicionarClienteGlobal(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public boolean DepositarDinheiro(int numeroAgencia, int numeroConta, double valor)
	{
		Agencia agencia = null;
		
		try
		{
			agencia = BuscarAgencia(numeroAgencia);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
		try
		{
			agencia.DepositarDinheiro(numeroConta, valor);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean SacarDinheiro(int numeroAgencia, int numeroConta, double valor)
	{
		Agencia agencia = null;
		
		try
		{
			agencia = BuscarAgencia(numeroAgencia);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
		try
		{
			agencia.SacarDinheiro(numeroConta, valor);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
