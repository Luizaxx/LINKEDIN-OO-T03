package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Model.*;

public class Dados {

    private static ArrayList<Candidato> candidatosInscritos;
    private static ArrayList<OfertaEmprego> ofertasInscritas;
    private static ArrayList<Empresa> empresas;
    
    static{
        candidatosInscritos = new ArrayList<>();
        ofertasInscritas = new ArrayList<>();
        empresas = new ArrayList<>();
        addEmpresasPredefinidas();
        addCandidatosPredefinidos();
    }
    
    public static ArrayList<Candidato> getCandidatosInscritos() {
        return candidatosInscritos;
    }

    public static ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public static void setEmpresas(ArrayList<Empresa> empresas) {
        Dados.empresas = empresas;
    }

    public static ArrayList<OfertaEmprego> getOfertasInscritas() {
        return ofertasInscritas;
    }

    public static void addEmpresasPredefinidas(){

        Empresa microsoft = new Empresa(
            "Microdoft",
            "microsoft@outlook.com",
            "04/04/1975",
            "Avenida Presidente Juscelino Kubitscheck, 1909 Torre Sul, 16° andar - Vila Nova Conceição, São Paulo - SP",
            "0800 047 4688",
            "Tecnologia",
            "04.712.500/0001-07",
            new ArrayList<OfertaEmprego>());
        
        microsoft.adicionarOfertaEmprego(new OfertaEmprego(12000, "Programador trainee", 5, LocalDateTime.now(), "Nível médio", true));
        microsoft.adicionarOfertaEmprego(new OfertaEmprego(24000, "Programador senior", 5, LocalDateTime.now(), "Nível médio", true));
        microsoft.adicionarOfertaEmprego(new OfertaEmprego(4000, "Estagiário", 5, LocalDateTime.now(), "Nível técnico", true));

        empresas.add(microsoft);

        Empresa google = new Empresa(
            "Google Inc.", 
            "google@google.com", 
            "04/09/1998", 
            "1600 Amphitheatre Parkway, Mountain View, CA", 
            "0800 724 8149",
            "Tecnologia",
            "06.990.590/0001-23",
            new ArrayList<OfertaEmprego>());

        google.adicionarOfertaEmprego(new OfertaEmprego(3500, "Estagiário", 6, LocalDateTime.now(), "Nível superior", true));
        google.adicionarOfertaEmprego(new OfertaEmprego(11000, "Programador", 7, LocalDateTime.now(), "Nível superior", true));
        google.adicionarOfertaEmprego(new OfertaEmprego(15000, "Chefe de equipe", 3, LocalDateTime.now(), "Nível superior", true));

        empresas.add(google);   

        Empresa lojasAmericanas = new Empresa(
            "Lojas americanas",
            "atendimento@lojasamericanas.com.br",
            "07/07/1929", 
            "Rua Sacadura Cabral, 102, Saúde,Rio De Janeiro - RJ",
            "(61) 99235-4922",
            "Vendas",
            "00.776.574/0001-56", 
            new ArrayList<OfertaEmprego>());
        
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(5000, "Vendedor", 15, LocalDateTime.now(), "Ensino Médio", true));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(1200, "Tecnico de informática", 5, LocalDateTime.now(), "Ensino técnico", true));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(7000, "Gerente", 2, LocalDateTime.now(), "Nível médio", true));

        empresas.add(lojasAmericanas); 

        Empresa CasasBahia = new Empresa(
            "Casas Bahia",
            "casasbahia@suporte.com",
            "12/12/1952",
            "Avenida Conde Francisco Matarazzo, 100, Centro, São Caetano do Sul, SP",
            "0800 000 000",
            "Vendas",
            "59.291.534/0001-67",
            new ArrayList<OfertaEmprego>());
        
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(1320, "Vendedor", 5, LocalDateTime.now(), "Nível médio", true));
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(2000, "Auxiliar de vendas", 3, LocalDateTime.now(), "Nível médio", true));
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(4000, "Gerente de vendas", 2, LocalDateTime.now(), "Nível médio", true));

        empresas.add(CasasBahia);

        Empresa HospitalSantaMarta = new Empresa(
            "Hospital Santa Marta",
            "hcsantamarta@hcsantamarta.com",
            "25/08/2000",
            "Qn A Rua N, cnj B, São ABC",
            "61 90000-1111",
            "Hospitalar",
            "11.110.011/0001-10",
            new ArrayList<OfertaEmprego>());
        
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(5320, "Enfermeiro", 5, LocalDateTime.now(), "Nível Superior", true));
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(2000, "Técnico de emfermagem", 3, LocalDateTime.now(), "Nível técnico", true));
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(5000, "Farmacêutico", 2, LocalDateTime.now(), "Nível superior", true));

        empresas.add(HospitalSantaMarta);

        Empresa ClinicaHospitalarSantaHeloisa = new Empresa(
            "Clínica hospital Santa Heloisa",
            "clinicasantaheloisa@clinicasantaheloisa.com",
            "25/08/2003",
            "Qn C Rua J, cnj D, São ADC",
            "61 92222-1111",
            "Hospitalar",
            "22.220.022/0002-20",
            new ArrayList<OfertaEmprego>());
        
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(2500, "Técnico de emfermagem", 5, LocalDateTime.now(), "Nível técnico", true));
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(4500, "Nutricionista", 3, LocalDateTime.now(), "Nível superior", true));
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(7500, "Fisioterapeuta", 3, LocalDateTime.now(), "Nível superior", true));

        empresas.add(ClinicaHospitalarSantaHeloisa);

        Empresa EscolaRubby = new Empresa(
            "Escola Rubby",
            "escolaRubby@gmail.com",
            "24/09/2020",
            "Conjunto 1, Rua 21, Let 23",
            "61 9 0000-9999",
            "Educação",
            "33.330.033/0003-33",
            new ArrayList<OfertaEmprego>());

        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(5000, "Professor de mátematica", 1, LocalDateTime.now(), "Nível superior", true));
        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 2, LocalDateTime.now(), "Nível médio", true));
        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(5000, "Professor de educação física", 1, LocalDateTime.now(), "Nível superior", true));

        empresas.add(EscolaRubby);

        Empresa EscolaRaviello = new Empresa(
            "Escola Raviello",
            "escolaRaviello@gmail.com",
            "24/09/2021",
            "Conjunto 2, Rua 25, Let 29",
            "61 9 0000-8888",
            "Educação",
            "44.440.044/0004-44",
            new ArrayList<OfertaEmprego>());
        
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(6000, "Professor de Geografia", 2, LocalDateTime.now(), "Nível superior", true));
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(2500, "Estagiário", 2, LocalDateTime.now(), "Nível superior", true));
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(6000, "Professor de Português", 3, LocalDateTime.now(), "Nível superior", true));

        empresas.add(EscolaRaviello);
        
        Empresa McDonalds = new Empresa(
            "McDonalds", 
            "McDonalds@McDonalds.com", 
            "04/09/1990", 
            "1600 Amphitheatre Parkway, Mountain View, CA", 
            "0800 724 8149",
            "Alimentos",
            "06.320.590/0001-23",
            new ArrayList<OfertaEmprego>());
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(6500, "Gerente", 1, LocalDateTime.now(), "Nível médio", true));
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 3, LocalDateTime.now(), "Nível técnico", true));
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(2000, "Caixa", 4, LocalDateTime.now(), "Nível médio", true));

        empresas.add(McDonalds);

        Empresa BurgerKing = new Empresa(
            "Burger King",
            "Burgerking@king.com",
            "27/07/2003",
            "Avenida aléluia, rua 06 praça 1, SP",
            "61 9 8888-8888",
            "Alimentos",
            "13.574.594/0001-96",
            new ArrayList<OfertaEmprego>());
        
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(6500, "Auxiliar de cozinha", 1, LocalDateTime.now(), "Nível médio", true));
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 3, LocalDateTime.now(), "Nível médio", true));
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(2000, "Caixa", 4, LocalDateTime.now(), "Nível médio", true));

        empresas.add(BurgerKing);
    }

    public static void addCandidatosPredefinidos(){
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
            new ArrayList<OfertaEmprego>());

            Gabriel.adicionarOfertaEmprego(null);

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
            new ArrayList<OfertaEmprego>());

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
            new ArrayList<OfertaEmprego>());            
        
        candidatosInscritos.add(Luiza);

        Candidato Rafael = new Candidato(
            "Rafael",
            "rafael@rafael.com", 
            "26/09/2003",
            "UnB Gama - FGA",
            "6 9 9922-9945", 
            "Engenharia de Software",
            "147.258.369.77", 
            "Nivel superior",
            "UnB GGama - FGA",
            new ArrayList<OfertaEmprego>());
            
        candidatosInscritos.add(Rafael);
    }

}