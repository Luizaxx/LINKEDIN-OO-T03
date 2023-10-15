package Model;

import java.util.ArrayList;

public class ApplicationModel {

    private ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
	private ArrayList<EmpresaModel> empresas = new ArrayList<EmpresaModel>();
	private ArrayList<OfertaModel> ofertas = new ArrayList<OfertaModel>();

	public ApplicationModel(ArrayList<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	public ApplicationModel() {

	}

	public ArrayList<UsuarioModel> getUsuario() {
		return usuarios;
	}
	public UsuarioModel getUsuario(int pos) {
		return usuarios.get(pos);
	}
	public void setUsuarios(ArrayList<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}
	public void setUsuario(UsuarioModel usuario) {
		usuarios.add(usuario);
	}
	public void setUsuario(int pos, UsuarioModel usuario) {
		usuarios.set(pos, usuario);
	}

	public ArrayList<EmpresaModel> getEmpresa() {
		return empresas;
	}
	public void setEmpresas(ArrayList<EmpresaModel> empresas) {
		this.empresas = empresas;
	}
	public void setEmpresa(EmpresaModel empresa) {
		empresas.add(empresa);
	}
	public void setEmpresa(int pos, EmpresaModel empresa) {
		empresas.set(pos, empresa);
	}

	public ArrayList<OfertaModel> getOferta() {
		return ofertas;
	}
	public void setOfertas(ArrayList<OfertaModel> ofertas) {
		this.ofertas = ofertas;
	}
	public void setOferta(OfertaModel oferta) {
		ofertas.add(oferta);
	}
	public void setOferta(int pos, OfertaModel oferta) {
		ofertas.set(pos, oferta);
	}

	public int getQntUsuario(int pos) {
		return usuarios.size();
	}
	public int getQntEmpresa(int pos) {
		return empresas.size();
	}
	public int getQntOferta(int pos) {
		return ofertas.size();
	}

}
