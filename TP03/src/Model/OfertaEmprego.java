package Model;

import java.time.LocalDateTime;

public class OfertaEmprego {

    private double salario;
	private String cargo;
	private int qntVagas;
	private LocalDateTime criadoEm;
	private String escolaridade;

	public OfertaEmprego(double salario, String cargo, int qntVagas, LocalDateTime criadoEm, String escolaridade) {
		this.salario = salario;
		this.cargo = cargo;
		this.qntVagas = qntVagas;
		this.criadoEm = criadoEm;
		this.escolaridade = escolaridade;
	}

	public String getEscolaridade(){
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade){
		this.escolaridade = escolaridade;

	}
	public LocalDateTime getCriadoEm(){
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm){
		this.criadoEm = criadoEm;
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

	@Override
	public String toString(){
		return "\nInformações da oferta de emprego:" +
			   "\nCargo: " + cargo +
			   "\nSalário: " + salario +
			   "\nQuantidade de vagas: " + qntVagas +
			   "\nNível de escolaridade exigido: " + escolaridade +
			   "\nOferta Criada em: "+ criadoEm;
	}

}
