package Model;

import java.time.LocalDateTime;
import java.util.ArrayList; 

public class Empresa extends Usuario{


	private int cnpj;
	private ArrayList<OfertaEmprego> ofertasEmprego = new ArrayList<OfertaEmprego>();

	public Empresa(String nome,int cnpj,int telefone ,String endereco,String email,String areaA) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.areaAtuacao = areaA;
	}

	


//cria uma oferta e o adiciona na lista de ofertas da Empresa
	public void criaOfertaEmprego(double salario, String cargo, int qntVagas, LocalDateTime criadoEm, String escolaridade){
		OfertaEmprego ofertaUnica = new OfertaEmprego(salario,cargo,qntVagas,criadoEm,escolaridade);
		addOferta(ofertaUnica);
	}

	public void addOferta(OfertaEmprego oferta){
		ofertasEmprego.add(oferta);
	}
	
	//
	public ArrayList<OfertaEmprego> listarOfertas(){
		return ofertasEmprego;
	}
	/*
	 editarOferta() :logica mais pra frente, mas vai pegar uma empresa, pegar o index do atributo, 
	e editar somente ele pelo index, fazendo assim uma copia do objeto como um todo
	e substituindo apenas o atributo desejado 
	
	*/

	public void editarOferta(int index , OfertaEmprego novaOferta){
		ofertasEmprego.set(index, novaOferta);
	}
	// remove pelo index do array geral de ofertas.
	public void excluiOferta(int index){
		ofertasEmprego.remove(index);
	}

	public ArrayList<OfertaEmprego> getOferta() {
		return ofertasEmprego;
	}
	public void setOfertasEmprego(ArrayList<OfertaEmprego> ofertaModels) {
		this.ofertasEmprego = ofertaModels;
	}
	public int getCnpj(){
		return cnpj;
	}
	public void setCnpj(int cnpj){
		this.cnpj = cnpj;
	}

}
