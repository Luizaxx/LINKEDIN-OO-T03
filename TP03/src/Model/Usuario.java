package Model;

public class Usuario{

	private String nome;
	private int cpf;
	private String escolaridade;
    private String dataNascimento;
	private String areaA;
	private String instituicao;

	public Usuario(String nome, int cpf, int cnpj, String escolaridade,String dataNascimento,String areaA,String instituicao) {
		this.nome = nome;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.dataNascimento = dataNascimento;
		this.areaA = areaA;
		this.instituicao = instituicao;
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

	public String getnEscolaridade() {
		return escolaridade;
	}
    
	public void setnEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}


	public String getAreaA() {
		return areaA;
	}

	public void setAreaA(String areaA) {
		this.areaA = areaA;
	}

	public String getDataNascimento(){
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}

	public String getInstituição() {
		return instituicao;
	}

	public void setInstituição(String instituicao) {
		this.instituicao = instituicao;
	}

}
