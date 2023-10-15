package Model;

public abstract class GeralModel {

    protected String nome;
	protected int cpf;
	protected int cnpj;
	protected String Escolaridade;

	public GeralModel(String nome, int cpf, int cnpj, String Escolaridade) {
		setNome(nome);
		setCpf(cpf);
		setCnpj(cnpj);
		setnEscolaridade(Escolaridade);
	}

	 public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getnEscolaridade() {
		return Escolaridade;
	}
    
	public void setnEscolaridade(String Escolaridade) {
		this.Escolaridade = Escolaridade;
	}
}
