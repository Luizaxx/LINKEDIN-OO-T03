package Model;

public class Candidato extends Usuario{



	private int cpf;
	private String escolaridade;
    private String dataNascimento;
	private String instituicao;

	public Candidato(String nome,String email,String endereco,int telefone,String areaAtuacao,int cpf, String escolaridade,String dataNascimento,String instituicao) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.areaAtuacao = areaAtuacao;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.dataNascimento = dataNascimento;
		this.instituicao = instituicao;
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
