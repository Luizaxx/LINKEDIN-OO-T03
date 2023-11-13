package Controler;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Model.*;

public class Dados {

    private ArrayList<Candidato> candidatosInscritos;
    private ArrayList<Empresa> empresas;

    public Dados() {
        candidatosInscritos = new ArrayList<>();
        empresas = new ArrayList<>();
        addEmpresasPredefinidas();
        addCandidatosPredefinidos();
    }

    public ArrayList<Candidato> getCandidatosInscritos() {
        return candidatosInscritos;
    }

    public void setCandidatosInscritos(ArrayList<Candidato> candidatosInscritos) {
        this.candidatosInscritos = candidatosInscritos;
    }    

    public ArrayList<Empresa> getEmpresa() {
        return empresas;
    }

    public void setEmpresa(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void addEmpresasPredefinidas(){
        Empresa lojasAmericanas = new Empresa(
            "Lojas americanas",
            "atendimento@lojasamericanas.com.br",
            "07/07/1929", 
            "Rua Sacadura Cabral, 102, Saúde,Rio De Janeiro - RJ",
            "(61) 99235-4922",
            "Loja de departamento, comércio eletrônico",
            "00.776.574/0001-56", 
            new ArrayList<OfertaEmprego>());

        Empresa google = new Empresa(
            "Google Inc.", 
            "google@google.com", 
            "04/09/1998", 
            "1600 Amphitheatre Parkway, Mountain View, CA", 
            "0800 724 8149",
            "Tecnologia, multinacional, software",
            "06.990.590/0001-23",
            null);

        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(5000, "Vendedor", 5, LocalDateTime.now(), "Ensino Médio"));
        empresas.add(lojasAmericanas); 
        empresas.add(google);       
    }

    public void addCandidatosPredefinidos(){
        Candidato Gabriel = new Candidato(
            "Gabriel", 
            "gabriel@gabriel.com",
            "27/07/2003",
            "UnB Gama - FGA", 
            "(61) 9 0000-0000",
            "Engenharia de software", 
            "123.456.789-89", 
            "Nível superior", 
            "UnB Gama - FGA",
            null);
        
        Candidato Ian = new Candidato(
            "Ian costa",
            "iancosta@costa.com",
            "25/08/2003",
            "UnB Gama - FGA",
            "61 9 1111-2222",
            "Engenharia de Software",
            "789.456.123-23",
            "Nível superior",
            "UnB Gama - FGA",
            null);

        Candidato Luiza = new Candidato(
            "Luiza", 
            "luiza@luiza.com", 
            "26/09/2003", 
            "UnB Gama - FGA", 
            "61 9 2222-3333", 
            "Engenharia de Software", 
            "147.258.369-69", 
            "Nível superior", 
            "UnB Gama - FGA", 
            null);    

        candidatosInscritos.add(Gabriel);
        candidatosInscritos.add(Ian);
        candidatosInscritos.add(Luiza);
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
