package Controler;

 import Model.*;

public class Dados {
    private CandidatoAdmin AdmUser;
    private EmpresaAdmin AdmEmp;
    

    public Dados() {
        fillWithSomeData();
    
}
public void fillWithSomeData() {
    /*
    Candidato candidato = new Candidato(" "," "," "," "," "," "," ",""," "," ");
            AdmUser = new CandidatoAdmin(null);
            AdmUser.setUsuario(candidato);
            Empresa empresa = new Empresa(null, 0, 0, null, null, null  );
            AdmEmp = new EmpresaAdmin(null);
            AdmEmp.setEmpresa(empresa);
    */
}
public CandidatoAdmin getcCandidatoAdmin(){
    return AdmUser;
}
public void setDados(CandidatoAdmin AdmUser) {
    this.AdmUser = AdmUser;
}
}