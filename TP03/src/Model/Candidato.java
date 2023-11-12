package Model;

import java.util.ArrayList;

public class Candidato extends Usuario{

	private String cpf;
	private String nivelEscolaridade;
	private String instituicao;
	private ArrayList<OfertaEmprego> ofertasInscritas = new ArrayList<OfertaEmprego>();

    public Candidato(String nome, String email, String dataNascimento, String endereco, String telefone,
			String areaAtuacao, String cpf, String nivelEscolaridade, String instituicao,
			ArrayList<OfertaEmprego> ofertasInscritas) {
		super(nome, email, dataNascimento, endereco, telefone, areaAtuacao);
		this.cpf = cpf;
		this.nivelEscolaridade = nivelEscolaridade;
		this.instituicao = instituicao;
		this.ofertasInscritas = ofertasInscritas;
	}

	public String getCpf() {
		return cpf;
	}
	public String getNivelEscolaridade() {
		return nivelEscolaridade;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNivelEscolaridade(String nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public ArrayList<OfertaEmprego> getOfertasInscritas() {
		return ofertasInscritas;
	}
	public void setOfertasInscritas(ArrayList<OfertaEmprego> ofertasInscritas) {
		this.ofertasInscritas = ofertasInscritas;
	}

	@Override
	public String toString() {
		return  "\nDados Candidato: " +  
				"\nNome: " + nome +
				"\nEmail: " + email +
				"\nData de nascimento: " + dataNascimento +
				"\nEndereço: " + endereco +
				"\nTelefone: " + telefone + 
				"\nÁrea de atuação: " + areaAtuacao +
				"\nCPF: " + cpf +
				"\nNível de escolaridade: " + nivelEscolaridade +
				"\nInstituição: " + instituicao + "\n" +
				"\nOfertas inscritas: " + ofertasInscritas;
	}

	
}
