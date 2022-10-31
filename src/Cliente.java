
public class Cliente {
	private String documento;
	private String nome;
	
	private Cliente(String documento, String nome)
	{
		this.setDocumento(documento);
		this.setNome(nome);
		
		System.out.println("Cliente " + this.getNome() + " criado com sucesso");
	}
	
	public static Cliente CriarCliente(String documento, String nome)
	{
		return new Cliente(documento, nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
}
