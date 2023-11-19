package Model;

//import java.time.LocalDateTime;
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

	public void adicionarOfertaEmprego(OfertaEmprego oferta){
		if(ofertasOfertadas == null){
			ofertasOfertadas = new ArrayList<>();
		}
		ofertasOfertadas.add(oferta);
	}

	public ArrayList<OfertaEmprego> getOfertasEmpregos(){
		return ofertasOfertadas;
	}

	public String ofertasAbertas(){
		int contador = 0;		
		for (OfertaEmprego oferta : ofertasOfertadas) {			
			if (oferta.isAtiva()) {
				contador++;
			}
        }
		if (contador == 0) {
			return "Essa empresa não cadastrou nenhuma oferta de emprego ainda.";
		}else{
			return "Número de ofertas abertas no momento: " + contador;
		}
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

	@Override
	public String toString() {
	return	"\nDados da Empresa: " +  
			"\nNome: " + nome +
			"\nEmail: " + email +
			"\nData de fundação: " + dataNascimento +
			"\nEndereço: " + endereco +
			"\nTelefone: " + telefone + 
			"\nÁrea de atuação: " + areaAtuacao +
			"\nCNPJ: " + cnpj + 
			"\n" + ofertasAbertas();
	}
}