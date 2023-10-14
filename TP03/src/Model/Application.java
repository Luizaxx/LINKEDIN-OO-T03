package Model;

import java.util.ArrayList;

public class Application {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public Application(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Application() {

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

	public ArrayList<Oferta> getOferta() {
		return ofertas;
	}
	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public void setOferta(Oferta oferta) {
		ofertas.add(oferta);
	}
	public void setOferta(int pos, Oferta oferta) {
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
