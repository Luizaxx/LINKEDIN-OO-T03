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

        Empresa sicoob = new Empresa(
            "Sicoob Consórcios", 
            "sicoob@sicoob.com", 
            "04/09/1998", 
            "Quadra Sig Quadra 1, 985 Zona Industrial Brasilia, DF", 
            "0800 15978455",
            "bancario",
            "16.551.061/0001-87",
            new ArrayList<OfertaEmprego>());

        sicoob.adicionarOfertaEmprego(new OfertaEmprego(950 , "Estagiário", 10, LocalDateTime.now(), "Nível superior", true));
        sicoob.adicionarOfertaEmprego(new OfertaEmprego(15000, "Banqueiro", 2, LocalDateTime.now(), "Doutorado", true));
        sicoob.adicionarOfertaEmprego(new OfertaEmprego(20000, "Programador", 5, LocalDateTime.now(), "Doutorado", true));

        empresas.add(sicoob);     

        Empresa norteEnergia = new Empresa(
            "Norte Energia", 
            "norte@energia.com", 
            "15/10/1982", 
            "Quadra Seps 702/902, 702 - Brasília DF", 
            "80224922",
            "energia, distribução",
            "12.300.288/0001-07",
            new ArrayList<OfertaEmprego>());

        norteEnergia.adicionarOfertaEmprego(new OfertaEmprego(14500 , "Engenheiro de Energia", 1, LocalDateTime.now(), "Mestrado", true));
      
        empresas.add(norteEnergia);   
        
         Empresa Motorola = new Empresa(
            "Motorola solutions", 
            "motorola@motorola.com", 
            "01/02/1974", 
            "Avenida Mercedes Benz, 170 - Campinas São Paulo", 
            "19 3867-1011",
            "software, tecnologia, hardware",
            "10.652.730/0004-73",
            new ArrayList<OfertaEmprego>());

        Motorola.adicionarOfertaEmprego(new OfertaEmprego(1030 , "Estagiário", 10, LocalDateTime.now(), "Nível superior", true));
      
        empresas.add(Motorola);   
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

         Candidato Bruna = new Candidato(
            "bruna", 
            "bruna.bruna@.com", 
            "27/07/2004", 
            "UnB Gama - FGA", 
            "61 9 99386-5788", 
            "Engenharia de Software", 
            "080,678.564.54", 
            "Nível superior", 
            "UnB Gama - FGA", 
            null);            
        
        candidatosInscritos.add(Bruna);

        
         Candidato Kaio = new Candidato(
            "kaio", 
            "kaio.kaio@.com", 
            "18/11/2003", 
            "UnB Gama - FGA", 
            "61 87567-5864", 
            "Engenharia de Software", 
            "080,525.101.45", 
            "Nível superior", 
            "UnB Gama - FGA", 
            null);            
        
        candidatosInscritos.add(Kaio);

        Candidato Kaua = new Candidato(
            "kaua", 
            "kaua.kaua@.com", 
            "12/07/2003", 
            "UnB Gama - FGA", 
            "61 45612-3014", 
            "Engenharia de Software", 
            "475,856.635.55", 
            "Nível superior", 
            "UnB Gama - FGA", 
            null);            
        
        candidatosInscritos.add(Kaua);

         Candidato Jorge = new Candidato(
            "jorge", 
            "jorge.jorge@.com", 
            "15/11/2000", 
            "UnB Gama - FGA", 
            "61 45612-3014", 
            "Engenharia de Automotiva", 
            "485,648.153.02", 
            "Doutorado", 
            "UnB Gama - FGA", 
            null);            
        
        candidatosInscritos.add(Jorge);

        Candidato Joao = new Candidato(
            "joao", 
            "joao.joao@.com", 
            "15/11/2000", 
            "UnB Gama - FGA", 
            "61 45612-3014", 
            "Engenharia de Energia", 
            "485,648.153.02", 
            "Mestrado", 
            "UnB Gama - FGA", 
            null);            
        
        candidatosInscritos.add(Joao);
    
    Candidato Lucas = new Candidato(
            "lucas", 
            "lucas.lucas@.com", 
            "05/04/2001", 
            "UnB Darcy Ribeiro", 
            "61 548,369,756.12", 
            "Ciencia da Computação", 
            "123.456,789,01", 
            "Nivel Superior", 
            "UnB Darcy Ribeiro", 
        null);            
        
        candidatosInscritos.add(Lucas);

        Candidato Luana = new Candidato(
            "luana", 
            "luana.luana@.com", 
            "05/04/2001", 
            "UnB Darcy Ribeiro", 
            "61 1234-5678", 
            "Ciencia da Computação", 
            "789.456.159.87", 
            "Nivel Superior", 
            "UnB Darcy Ribeiro", 
        null);            
        
        candidatosInscritos.add(Luana);


}}