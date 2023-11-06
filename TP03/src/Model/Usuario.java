package Model;

public abstract class Usuario {

    protected String nome;
	protected String email;
	protected String endereco;
	protected int telefone;
	protected String areaAtuacao;

	
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
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaA(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	public int getTelefone(){
		return telefone;
	}
	public void setTelefone(int telefone){
		this.telefone = telefone;
	}

}
