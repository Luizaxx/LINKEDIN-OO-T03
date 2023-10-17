package Model;

import java.util.ArrayList;


public class Application {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	//private ArrayList<OfertaModel> ofertas = new ArrayList<OfertaModel>(); isso vai pra dentro de empresa



	public Application(ArrayList<Usuario> usuarios,ArrayList<Empresa> empresa) {
		this.usuarios = usuarios;
		this.empresas = empresa;
	}
	public Application() {
	
	}
	//cria um usuário e o adiciona na lista de usuarios da aplicação
	public void criaUsuario(String nome, int cpf, int cnpj, String escolaridade,String dataNascimento,String areaA,String instituicao){
		Usuario usuarioNovo = new Usuario(nome, cpf, cnpj, escolaridade, dataNascimento, areaA, instituicao);
		addUsuario(usuarioNovo);
		
	}
	//adiciona usuario na lista de usuarios da aplicação
	public void addUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	
	//cria uma empresa e a adiciona na lista de empresas da aplicação
	public void criaEmpresa(String nome,int cnpj,int telefone ,String endereco,String email,String areaA){
		Empresa empresaNova = new Empresa(nome, cnpj, telefone, endereco, email, areaA);
		addEmpresa(empresaNova);
		
	}
	//exclui usuario da lista
	public void excluiUsuario(int index){
		usuarios.remove(index);
	}

	//exclui empresa da lista
	public void excluiEmpresa(int index){
		empresas.remove(index);
	}
	public void addEmpresa(Empresa empresa){
		empresas.add(empresa);
	}

	public ArrayList<Usuario> getUsuario() {
		return usuarios;
	}
	public Usuario getUsuario(int pos) {
		return usuarios.get(pos);
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public void setUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	public void setUsuario(int pos, Usuario usuario) {
		usuarios.set(pos, usuario);
	}

	public ArrayList<Empresa> getEmpresa() {
		return empresas;
	}
	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}
	public void setEmpresa(Empresa empresa) {
		empresas.add(empresa);
	}
	public void setEmpresa(int pos, Empresa empresa) {
		empresas.set(pos, empresa);
	}

	// public ArrayList<OfertaModel> getOferta() {
	// 	return ofertas;
	// }
	// public void setOfertas(ArrayList<OfertaModel> ofertas) {
	// 	this.ofertas = ofertas;
	// }
	// public void setOferta(OfertaModel oferta) {
	// 	ofertas.add(oferta);
	// }
	// public void setOferta(int pos, OfertaModel oferta) {
	// 	ofertas.set(pos, oferta);
	// }

	public int getQntUsuario(int pos) {
		return usuarios.size();
	}
	public int getQntEmpresa(int pos) {
		return empresas.size();
	}
	// public int getQntOferta(int pos) {
	// 	return ofertas.size();
	// }

}
