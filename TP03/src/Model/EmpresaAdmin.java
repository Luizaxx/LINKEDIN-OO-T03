package Model;

import java.util.ArrayList;

public class EmpresaAdmin {
    
    private ArrayList<Empresa> empresas = new ArrayList<Empresa>();



    public EmpresaAdmin(ArrayList<Empresa> empresa){
        this.empresas = empresa;
    }

    public void criaEmpresa(String nome,int cnpj,int telefone ,String endereco,String email,String areaA){
		Empresa empresaNova = new Empresa(nome, cnpj, telefone, endereco, email, areaA);
		addEmpresa(empresaNova);
		
	}
    //exclui empresa da lista
	public void excluiEmpresa(int index){
		empresas.remove(index);
	}
	public void addEmpresa(Empresa empresa){
		empresas.add(empresa);
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
    public int getQntEmpresa(int pos) {
		return empresas.size();
	}


}
