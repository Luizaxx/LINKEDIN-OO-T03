package Model;

import java.util.ArrayList;

public class CandidatoAdmin {
    
    private ArrayList<Candidato> usuarios = new ArrayList<Candidato>();


    public CandidatoAdmin(ArrayList<Candidato> usuarios){
        this.usuarios = usuarios;
    }
    
    
    //cria um usuário e o adiciona na lista de usuarios da aplicação
    public void criaUsuario(String nome,String email,String endereco,int telefone,String areaAtuacao,int cpf, String escolaridade,String dataNascimento,String instituicao){
		Candidato usuarioNovo = new Candidato(nome, email, endereco, telefone, areaAtuacao, cpf,escolaridade,dataNascimento,instituicao);
		addUsuario(usuarioNovo);
		
	}
    //adiciona usuario na lista de usuarios da aplicação
	public void addUsuario(Candidato usuario){
		usuarios.add(usuario);
	}



    //exclui usuario da lista
	public void excluiUsuario(int index){
		usuarios.remove(index);
	}

    public ArrayList<Candidato> getUsuario() {
		return usuarios;
	}
	public Candidato getUsuario(int pos) {
		return usuarios.get(pos);
	}
	public void setUsuarios(ArrayList<Candidato> usuarios) {
		this.usuarios = usuarios;
	}
	public void setUsuario(Candidato usuario) {
		usuarios.add(usuario);
	}
	public void setUsuario(int pos, Candidato usuario) {
		usuarios.set(pos, usuario);
	}
}
