package Model;

public class Empresa extends Geral {

    private String email;
	private String end;

	public Empresa(String nome, int cpf, int cnpj, String Escolaridade, String email, String end) {
		super(nome, cpf, cnpj, Escolaridade);
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.Escolaridade = Escolaridade;
		this.email = email;
		this.end = end;
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
