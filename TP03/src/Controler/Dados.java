package Controler;
import java.util.ArrayList;
import Model.*;

public class Dados {

    private ArrayList<Candidato> candidatosInscritos;

    public Dados() {
        candidatosInscritos = new ArrayList<>();
    }

    public ArrayList<Candidato> getCandidatosInscritos() {
        return candidatosInscritos;
    }

    public void setCandidatosInscritos(ArrayList<Candidato> candidatosInscritos) {
        this.candidatosInscritos = candidatosInscritos;
    }

}
// public void fillWithSomeData() {
    
//     Candidato candidato = new Candidato("","","",""," "," "," ",""," ", null);
//             AdmUser = new CandidatoAdmin(null);
//             AdmUser.setUsuario(candidato);
//             Empresa empresa = new Empresa("","","","","","","", null);
//             AdmEmp = new EmpresaAdmin(null);
//             AdmEmp.setEmpresa(empresa);
    
// }
// public CandidatoAdmin getcCandidatoAdmin(){
//     return AdmUser;
// }
// public void setDados(CandidatoAdmin AdmUser) {
//     this.AdmUser = AdmUser;
// }
// }