package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Model.*;

public class Dados {

    private static ArrayList<Candidato> candidatosInscritos;
    private static ArrayList<OfertaEmprego> ofertasInscritas;
    private static ArrayList<Empresa> empresas;
    private static ArrayList<OfertaEmprego> ofertasTecnologia;
    private static ArrayList<OfertaEmprego> ofertasVendas;
    private static ArrayList<OfertaEmprego> ofertasHospitalar;
    private static ArrayList<OfertaEmprego> ofertasAlimentos;
    private static ArrayList<OfertaEmprego> ofertasEducacao;
    private static ArrayList<OfertaEmprego> ofertasRestantes;
    
    static{
        candidatosInscritos = new ArrayList<>();
        ofertasInscritas = new ArrayList<>();
        ofertasTecnologia = new ArrayList<>();
        ofertasVendas = new ArrayList<>();
        ofertasHospitalar = new ArrayList<>();
        ofertasAlimentos = new ArrayList<>();
        ofertasEducacao = new ArrayList<>();
        ofertasRestantes = new ArrayList<>();
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

    public static ArrayList<OfertaEmprego> getOfertasInscritas() {
        return ofertasInscritas;
    }

    public static ArrayList<OfertaEmprego> getOfertasTecnologia() {
        return ofertasTecnologia;
    }

    public static ArrayList<OfertaEmprego> getOfertasVendas() {
        return ofertasVendas;
    }

    public static ArrayList<OfertaEmprego> getOfertasHospitalar() {
        return ofertasHospitalar;
    }

    public static ArrayList<OfertaEmprego> getOfertasAlimentos() {
        return ofertasAlimentos;
    }

    public static ArrayList<OfertaEmprego> getOfertasEducacao() {
        return ofertasEducacao;
    }

    public static ArrayList<OfertaEmprego> getOfertasRestantes() {
        return ofertasRestantes;
    }

    public static void addEmpresasPredefinidas(){

        Empresa microsoft = new Empresa(
            "Microsoft",
            "microsoft@outlook.com",
            "04/04/1975",
            "Avenida Presidente Juscelino Kubitscheck, 1909 Torre Sul, 16° andar - Vila Nova Conceição, São Paulo - SP",
            "0800 047 4688",
            "Tecnologia",
            "04.712.500/0001-07",
            new ArrayList<OfertaEmprego>());
        // Ofertas da área de tecnologia:
        /*0*/ microsoft.adicionarOfertaEmprego(new OfertaEmprego(12000, "Programador trainee", 5, LocalDateTime.now(), "Nível médio", true, microsoft));
        /*1*/ microsoft.adicionarOfertaEmprego(new OfertaEmprego(24000, "Programador senior", 5, LocalDateTime.now(), "Nível médio", true, microsoft));
        /*2*/ microsoft.adicionarOfertaEmprego(new OfertaEmprego(4000, "Estagiário", 5, LocalDateTime.now(), "Nível técnico", true, microsoft));

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
        // Continuação das ofertas de tecnologia:
        /*3*/ google.adicionarOfertaEmprego(new OfertaEmprego(3500, "Estagiário", 6, LocalDateTime.now(), "Nível superior", true, google));
        /*4*/ google.adicionarOfertaEmprego(new OfertaEmprego(11000, "Programador", 7, LocalDateTime.now(), "Nível superior", true, google));
        /*5*/ google.adicionarOfertaEmprego(new OfertaEmprego(15000, "Chefe de equipe", 3, LocalDateTime.now(), "Nível superior", true, google));

        empresas.add(google);   

<<<<<<< HEAD
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
=======
        Empresa lojasAmericanas = new Empresa(
            "Lojas americanas",
            "atendimento@lojasamericanas.com.br",
            "07/07/1929", 
            "Rua Sacadura Cabral, 102, Saúde,Rio De Janeiro - RJ",
            "(61) 99235-4922",
            "Vendas",
            "00.776.574/0001-56", 
            new ArrayList<OfertaEmprego>());
        
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(5000, "Vendedor", 15, LocalDateTime.now(), "Ensino Médio", true, lojasAmericanas));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(1200, "Tecnico de informática", 5, LocalDateTime.now(), "Ensino técnico", true, lojasAmericanas));
        lojasAmericanas.adicionarOfertaEmprego(new OfertaEmprego(7000, "Gerente", 2, LocalDateTime.now(), "Nível médio", true, lojasAmericanas));

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
        
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(1320, "Vendedor", 5, LocalDateTime.now(), "Nível médio", true, CasasBahia));
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(2000, "Auxiliar de vendas", 3, LocalDateTime.now(), "Nível médio", true, CasasBahia));
        CasasBahia.adicionarOfertaEmprego(new OfertaEmprego(4000, "Gerente de vendas", 2, LocalDateTime.now(), "Nível médio", true, CasasBahia));

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
        
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(5320, "Enfermeiro", 5, LocalDateTime.now(), "Nível Superior", true, HospitalSantaMarta));
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(2000, "Técnico de emfermagem", 3, LocalDateTime.now(), "Nível técnico", true, HospitalSantaMarta));
        HospitalSantaMarta.adicionarOfertaEmprego(new OfertaEmprego(5000, "Farmacêutico", 2, LocalDateTime.now(), "Nível superior", true, HospitalSantaMarta));

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
        
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(2500, "Técnico de emfermagem", 5, LocalDateTime.now(), "Nível técnico", true, ClinicaHospitalarSantaHeloisa));
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(4500, "Nutricionista", 3, LocalDateTime.now(), "Nível superior", true, ClinicaHospitalarSantaHeloisa));
        ClinicaHospitalarSantaHeloisa.adicionarOfertaEmprego(new OfertaEmprego(7500, "Fisioterapeuta", 3, LocalDateTime.now(), "Nível superior", true, ClinicaHospitalarSantaHeloisa));

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

        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(5000, "Professor de mátematica", 1, LocalDateTime.now(), "Nível superior", true, EscolaRubby));
        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 2, LocalDateTime.now(), "Nível médio", true, EscolaRubby));
        EscolaRubby.adicionarOfertaEmprego(new OfertaEmprego(5000, "Professor de educação física", 1, LocalDateTime.now(), "Nível superior", true, EscolaRubby));

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
        
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(6000, "Professor de Geografia", 2, LocalDateTime.now(), "Nível superior", true, EscolaRaviello));
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(2500, "Estagiário", 2, LocalDateTime.now(), "Nível superior", true, EscolaRaviello));
        EscolaRaviello.adicionarOfertaEmprego(new OfertaEmprego(6000, "Professor de Português", 3, LocalDateTime.now(), "Nível superior", true, EscolaRaviello));

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
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(6500, "Gerente", 1, LocalDateTime.now(), "Nível médio", true, McDonalds));
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 3, LocalDateTime.now(), "Nível técnico", true, McDonalds));
        McDonalds.adicionarOfertaEmprego(new OfertaEmprego(2000, "Caixa", 4, LocalDateTime.now(), "Nível médio", true, McDonalds));

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
        
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(6500, "Auxiliar de cozinha", 1, LocalDateTime.now(), "Nível médio", true, BurgerKing));
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(1500, "Estagiário", 3, LocalDateTime.now(), "Nível médio", true, BurgerKing));
        BurgerKing.adicionarOfertaEmprego(new OfertaEmprego(2000, "Caixa", 4, LocalDateTime.now(), "Nível médio", true, BurgerKing));

        empresas.add(BurgerKing);

        Empresa AgronoLuiz = new Empresa(
            "Agrono Luiz",
            "agronoluiz@agronoluiz.com",
            "25/08/1998",
            "Granja areste fazenda Arauga",
            "61 9 0000-1111",
            "Agricultura",
            "77.700.007/0001-07",
            new ArrayList<OfertaEmprego>()
        );

        AgronoLuiz.adicionarOfertaEmprego(new OfertaEmprego(3500, "Agricultor", 2, LocalDateTime.now(), "Nível médio", true, AgronoLuiz));
        AgronoLuiz.adicionarOfertaEmprego(new OfertaEmprego(2500, "Operador de máquina agricula", 3, LocalDateTime.now(), "Nível médio", true, AgronoLuiz));
        AgronoLuiz.adicionarOfertaEmprego(new OfertaEmprego(7000, "Gerente", 1, LocalDateTime.now(), "Nível médio", true, AgronoLuiz));

        empresas.add(AgronoLuiz);

        ofertasTecnologia = encontrarOfertasPorArea("Tecnologia");
        ofertasVendas = encontrarOfertasPorArea("Vendas");
        ofertasHospitalar = encontrarOfertasPorArea("Hospitalar");
        ofertasEducacao = encontrarOfertasPorArea("Educação");
        ofertasAlimentos = encontrarOfertasPorArea("Alimentos");
        ofertasRestantes = encontrarOfertasRestantes();
>>>>>>> 738fa412bd6d040f02ace932fe84a6bf89530fe1
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

            Gabriel.adicionarOfertaEmprego(ofertasTecnologia.get(0));
            Gabriel.adicionarOfertaEmprego(ofertasRestantes.get(0));
            Gabriel.adicionarOfertaEmprego(ofertasEducacao.get(1));

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

            Ian.adicionarOfertaEmprego(ofertasVendas.get(0));
            Ian.adicionarOfertaEmprego(ofertasTecnologia.get(1));
            Ian.adicionarOfertaEmprego(ofertasTecnologia.get(2));

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
            
            Luiza.adicionarOfertaEmprego(ofertasHospitalar.get(0));
            Luiza.adicionarOfertaEmprego(ofertasAlimentos.get(1));
            Luiza.adicionarOfertaEmprego(ofertasRestantes.get(1));
        
        candidatosInscritos.add(Luiza);

<<<<<<< HEAD
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
=======
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

            Rafael.adicionarOfertaEmprego(ofertasEducacao.get(0));
            Rafael.adicionarOfertaEmprego(ofertasVendas.get(1));
            Rafael.adicionarOfertaEmprego(ofertasTecnologia.get(3));
            
        candidatosInscritos.add(Rafael);

        Candidato Bruna = new Candidato(
            "Bruna",
            "bruna@bruna.com", 
            "29/10/2003",
            "UnB Gama - FGA",
            "61 9 0000-1111", 
            "Engenharia de Software",
            "222.222.222-22", 
            "Nivel superior",
            "UnB Gama - FGA",
            new ArrayList<OfertaEmprego>());

            Bruna.adicionarOfertaEmprego(ofertasAlimentos.get(0));
            Bruna.adicionarOfertaEmprego(ofertasHospitalar.get(1));
            Bruna.adicionarOfertaEmprego(ofertasAlimentos.get(2));
        
        candidatosInscritos.add(Bruna);
    }

    private static ArrayList<OfertaEmprego> encontrarOfertasPorArea(String areaAtuacao){
        ArrayList<OfertaEmprego> ofertasEncontradas = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if (empresa.getAreaAtuacao().equals(areaAtuacao)) {
                ofertasEncontradas.addAll(empresa.getOfertasOfertadas());
            }
        }
        return ofertasEncontradas;
    }    

    private static ArrayList<OfertaEmprego> encontrarOfertasRestantes(){
        ArrayList<OfertaEmprego> ofertasEncontradas = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if ((empresa.getAreaAtuacao() != "Tecnologia") && (empresa.getAreaAtuacao() != "Vendas") && (empresa.getAreaAtuacao() != "Hospitalar") && (empresa.getAreaAtuacao() != "Educação") && (empresa.getAreaAtuacao() != "Alimentos")) {
                ofertasEncontradas.addAll(empresa.getOfertasOfertadas());
            }
        }
        return ofertasEncontradas;
    }    
}
>>>>>>> 738fa412bd6d040f02ace932fe84a6bf89530fe1
