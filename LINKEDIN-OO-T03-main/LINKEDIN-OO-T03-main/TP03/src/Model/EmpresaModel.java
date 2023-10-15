package Model;

public class EmpresaModel{


	private String nome;
	private int cnpj;
    private String email;
	private String end;

	public EmpresaModel(String nome,int cnpj, String email, String end) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.end = end;
	}

	public int getCnpj(){
		return cnpj;
	}
	public void setCnpj(int cnpj){
		this.cnpj = cnpj;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
