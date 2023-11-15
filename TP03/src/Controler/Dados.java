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
        
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(5000, "Vendedor", 15, LocalDateTime.now(), "Ensino Médio", true));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(1200, "Tecnico de informática", 5, LocalDateTime.now(), "Ensino técnico", true ));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(7000, "Gerente", 2, LocalDateTime.now(), "Nível médio", true));

        empresas.add(lojasAmericanas); 

        Empresa google = new Empresa(
            "Google Inc.", 
            "google@google.com", 
            "04/09/1998", 
            "1600 Amphitheatre Parkway, Mountain View, CA", 
            "0800 724 8149",
            "Tecnologia, multinacional, software",
            "06.990.590/0001-23",
            new ArrayList<OfertaEmprego>());

        google.adicionarOfertaEmprego(new OfertaEmprego(3500, "Estagiário", 6, LocalDateTime.now(), "Nível superior", true));
        google.adicionarOfertaEmprego(new OfertaEmprego(11000, "Programador", 7, LocalDateTime.now(), "Nível superior", true));
        google.adicionarOfertaEmprego(new OfertaEmprego(15000, "Chefe de equipe", 3, LocalDateTime.now(), "Nível superior", true));

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

        candidatosInscritos.add(Gabriel);
        
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

        candidatosInscritos.add(Ian);

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
        
        candidatosInscritos.add(Luiza);
    }
}