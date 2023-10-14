package Model;

public class Oferta extends Geral {
    
    private double salario;
	private String cargo;
	private int qntVagas;

	public Oferta(String nome, int cpf, int cnpj, String Escolaridade, double salario, String cargo, int qntVagas) {
		super(nome, cpf, cnpj, Escolaridade);
		this.salario = salario;
		this.cargo = cargo;
		this.qntVagas = qntVagas;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getQntVagas() {
		return qntVagas;
	}

	public void setQntVagas(int qntVagas) {
		this.qntVagas = qntVagas;
	}
}
