package model;

public abstract class Usuario {

    protected String nome;
	protected String email;
	protected String dataNascimento;
	protected String endereco;
	protected String telefone;
	protected String areaAtuacao;

	public Usuario(String nome, String email, String dataNascimento, String endereco, String telefone,
			String areaAtuacao) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.areaAtuacao = areaAtuacao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
