import java.util.ArrayList;

public class Monopoly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Banco banco;
		ArrayList<Conta> contas = new ArrayList<Conta>();

		System.out.println("S.O.M.B.R.A.\n"
						 + "Simplified Online Monopoly Banking Resource Administration");
		
		System.out.println("Starting");
		
		banco = new Banco("Monopolys");
		
		System.out.println("Montando sistema bancário");
		
		banco.CriarAgencia(123);
		banco.CriarAgencia(456);
		banco.CriarAgencia(789);
		banco.CriarAgencia(789);
		
		Agencia agencia1 = null;
		try
		{
			agencia1 = banco.BuscarAgencia(123);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Agencia agencia2 = null;
		try
		{
			agencia2 = banco.BuscarAgencia(456);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Agencia agencia3 = null;
		try
		{
			agencia3 = banco.BuscarAgencia(789);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Gerando clientela");
		
		Cliente cliente1 = agencia1.CriarCliente("Rodrigo1", "000001");
		Cliente cliente2 = agencia1.CriarCliente("Rodrigo2", "000002");
		
		Cliente cliente3 = agencia2.CriarCliente("Rodrigo3", "000003");
		
		Cliente cliente4 = agencia3.CriarCliente("Rodrigo4", "000004");
		
		System.out.println("Abrindo contas");
		
		Conta conta1 = null;
		try
		{
			conta1 = agencia1.AbrirConta(11, cliente1);
			contas.add(conta1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Conta conta2;
		try
		{
			conta2 = agencia1.AbrirConta(22, cliente2);
			contas.add(conta2);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		Conta conta3;
		try
		{
			conta3 = agencia2.AbrirConta(33, cliente3);
			contas.add(conta3);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Conta conta4;
		try
		{
			conta4 = agencia2.AbrirConta(33, cliente4);
			contas.add(conta4);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			contas.add(agencia3.AbrirConta(44, cliente4));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
		System.out.println("Gerando riquezas");
		
		banco.DepositarDinheiro(123, 11, 150);
		banco.DepositarDinheiro(123, 22, 250);
		banco.DepositarDinheiro(123, 11, 150);
		banco.DepositarDinheiro(123, 33, 100000); //ACCOUNTNOTFOUND
		
		banco.DepositarDinheiro(456, 33, 150);
		banco.DepositarDinheiro(456, 33, 250);
		
		banco.DepositarDinheiro(789, 44, 150);
		banco.DepositarDinheiro(789, 45, 250);	  //ACCOUNT NOT FOUND	

		System.out.println("CHECKPOINT #1");
		for (Conta conta : contas) {
			conta.ImprimirExtrato();
		}
		
		System.out.println("Sacando Fortunas");
		
		banco.SacarDinheiro(123, 11, 50);
		banco.SacarDinheiro(123, 22, 200);
		banco.SacarDinheiro(123, 11, 1150);
				
		banco.SacarDinheiro(456, 33, 50);
		
		banco.SacarDinheiro(789, 44, 1150);
			
		System.out.println("CHECKPOINT #2");
		for (Conta conta : contas) {
			conta.ImprimirExtrato();
		}
		
		System.out.println("Transferindo");
		
		try
		{
			conta1.Transferir(123, 22, 200);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("CHECKPOINT #3");
		for (Conta conta : contas) {
			conta.ImprimirExtrato();
		}
		
		System.out.println("Eliminando vestigios");
		
		System.out.println("CHECKPOINT #4");
		for (Conta conta : contas) {
			conta.ImprimirExtrato();
		}
		
		System.out.println("Shutting Down");
		
	}

}
