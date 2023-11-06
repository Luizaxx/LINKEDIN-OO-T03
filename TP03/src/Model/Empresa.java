package Model;

import java.time.LocalDateTime;
import java.util.ArrayList; 

public class Empresa extends Usuario{

	private String cnpj;
	private ArrayList<OfertaEmprego> ofertasOfertadas = new ArrayList<OfertaEmprego>();

    public Empresa(String nome, String email, String dataNascimento, String endereco, String telefone,
			String areaAtuacao, String cnpj, ArrayList<OfertaEmprego> ofertasOfertadas) {
		super(nome, email, dataNascimento, endereco, telefone, areaAtuacao);
		this.cnpj = cnpj;
		this.ofertasOfertadas = ofertasOfertadas;
	}

	//cria uma oferta e o adiciona na lista de ofertas da Empresa
	public void criaOfertaEmprego(double salario, String cargo, int qntVagas, LocalDateTime criadoEm, String escolaridade){
		OfertaEmprego ofertaUnica = new OfertaEmprego(salario,cargo,qntVagas,criadoEm,escolaridade);
		addOferta(ofertaUnica);
	}

	public void addOferta(OfertaEmprego oferta){
		ofertasOfertadas.add(oferta);
	}
	
	//
	public ArrayList<OfertaEmprego> listarOfertas(){
		return ofertasOfertadas;
	}
	/*
	 editarOferta() :logica mais pra frente, mas vai pegar uma empresa, pegar o index do atributo, 
	e editar somente ele pelo index, fazendo assim uma copia do objeto como um todo
	e substituindo apenas o atributo desejado 
	
	*/

	public void editarOferta(int index , OfertaEmprego novaOferta){
		ofertasOfertadas.set(index, novaOferta);
	}
	// remove pelo index do array geral de ofertas.
	public void excluiOferta(int index){
		ofertasOfertadas.remove(index);
	}

	public ArrayList<OfertaEmprego> getOfertasOfertadas() {
		return ofertasOfertadas;
	}	
	public void setOfertasOfertadas(ArrayList<OfertaEmprego> ofertaModels) {
		this.ofertasOfertadas = ofertaModels;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
