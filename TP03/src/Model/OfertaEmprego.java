package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OfertaEmprego {

    private double salario;
	private String cargo;
	private int qntVagas;
	private LocalDateTime criadoEm = LocalDateTime.now();
	private String escolaridade;
	private boolean ativa; // Novo atributo para representar o status da oferta
	private Empresa empresa;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String dataFormatada = criadoEm.format(formatter);

	public OfertaEmprego(double salario, String cargo, int qntVagas, LocalDateTime criadoEm, String escolaridade, boolean ativa, Empresa empresa) {
		this.salario = salario;
		this.cargo = cargo;
		this.qntVagas = qntVagas;
		this.criadoEm = criadoEm;
		this.escolaridade = escolaridade;
		this.ativa = true;
		this.empresa = empresa;
	}

	// Novo método para verificar se a oferta está ativa
    public boolean isAtiva() {
        return ativa;
    }

	// Novo método para desativar a oferta
    public void desativarOferta() {
        this.ativa = false;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	@Override
	public String toString(){
		return "\nInformações da oferta de emprego:" +
			   "\nNome da empresa: " + empresa.getNome() +
			   "\nÁrea de atuação da empresa: " + empresa.getAreaAtuacao() +
			   "\nEmail da empresa: " + empresa.getEmail() +
			   "\nCargo: " + cargo +
			   "\nSalário: " + salario +
			   "\nQuantidade de vagas: " + qntVagas +
			   "\nNível de escolaridade exigido: " + escolaridade +
			   "\nOferta Criada em: "+ dataFormatada;
	}
}