package Main;

import java.util.Scanner;

import Controler.CandidatoControler;
import Controler.EmpresaControler;
import Controler.OfertaEmpregoControler;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            System.out.println(imprimirMenuPrincipal());
            int op1 = in.nextInt();
            switch (op1) {
                case 0:
                    System.out.println("Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
                    break;
                case 1:
                    loop = menuCandidato();
                    break;
                case 2:
                    loop = menuEmpresa();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
    }

    public static String imprimirMenuPrincipal() {
        return "\n-------- Menu Principal --------\n" +
               "Escolha uma das opções a seguir:\n" +
               "0 - Sair da aplicação\n" +
               "1 - Candidato\n" +
               "2 - Empresa";
    }

    public static boolean menuCandidato() {
        boolean loopCandidato = true;

        while (loopCandidato) {
            System.out.println(imprimirMenuCandidato());
            int op2 = in.nextInt();
            switch (op2) {
                case 0:
                    System.out.println("Obrigada por utilizar o sistema. Até logo!");
                    return false;  // Sai do loop do candidato e, consequentemente, do loop principal
                case 1:
                    loopCandidato = false;  // Sai do loop do candidato, mas continua no loop principal
                    break;
                case 2:
                    CandidatoControler.cadastrarCandidato();
                    break;
                case 3:
                    CandidatoControler.imprimirCandidatos();
                    break;
                case 4:
                    loopCandidato = menuEditarCandidato();
                    break;
                case 5:
                    CandidatoControler.apagarCadastroDoSistema();
                    break;
                case 6:
                    loopCandidato = menuFiltroOfertasEmprego();
                    break;
                case 7:
                    loopCandidato = menuInscreverOfertaEmprego();
                    break;
                case 8:
                    CandidatoControler.imprimirOfertasEmpregoInscritas();
                    break;
                case 9:
                    CandidatoControler.apagarOfertaEmpregoInscrita();
                    break;
                case 10:
                    System.out.println("Não temos essa opção ainda");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
        return true;  // Continua no loop principal
    }

    public static String imprimirMenuCandidato() {
        return "\n----- Bem vindo candidato -----\n" +
               "Escolha uma das opções a seguir:\n" +
               "0 - Sair da aplicação\n" +
               "1 - Voltar para o menu principal\n" +
               "2 - Se cadastrar (caso seja usuário novato)\n" +
               "3 - Visualizar cadastro de cliente específico\n" +
               "4 - Editar cadastro\n" +
               "5 - Apagar o seu cadastro do sistema\n" +
               "6 - Visualizar ofertas de empregos disponíveis\n" +
               "7 - Se inscrever em uma oferta de emprego\n" +
               "8 - Vizualizar ofertas de emprego que você está inscrito\n" +
               "9 - Tirar a sua inscrição de uma oferta de emprego\n"+
               "10 - Visualizar todos os clientes cadastrados no sistema";
    }

    public static boolean menuEditarCandidato(){
        boolean loopEditarCandidato = true;

        while (loopEditarCandidato) {
            System.out.println(imprimirMenuEditarCandidato());
            int op3 = in.nextInt();
            switch (op3) {
                case 0:
                    loopEditarCandidato = false;
                    break;
                case 1:
                    CandidatoControler.editarNomeCandidato();
                    break;
                case 2:
                    CandidatoControler.editarEmailCandidato();
                    break;
                case 3:
                    CandidatoControler.editarDataNascimentoCandidato();
                    break;
                case 4:
                    CandidatoControler.editarEnderecoCandidato();
                    break;
                case 5:
                    CandidatoControler.editarTelefoneCandidato();
                    break;
                case 6:
                    CandidatoControler.editarAreaAtuacaoCandidato();
                    break;
                case 7:
                    CandidatoControler.editarCpfCandidato();
                    break;
                case 8:
                    CandidatoControler.editarNivelEscolaridadeCandidato();
                    break;
                case 9:
                    CandidatoControler.editarInstituicaoCandidato();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenuEditarCandidato(){
        return
        "\nQuais dos campos asseguir você deseja editar?\n" +
        "1 - Nome\n" + 
        "2 - Email\n" +
        "3 - Data de nascimento\n" +
        "4 - Endereço\n" +
        "5 - Telefone\n" +
        "6 - Área de atuação\n" +
        "7 - CPF\n" +
        "8 - Nível escolaridade\n" +
        "9 - Instituição de ensino\n" +
        "Caso deseje voltar para o menu anterior digite: 0";
    }

    public static boolean menuEmpresa() {
        boolean loopEmpresa = true;

        while (loopEmpresa) {
            System.out.println(imprimirMenuEmpresa());
            int op4 = in.nextInt();
            switch (op4) {
                case 0:
                    System.out.println("Obrigada por utilizar o sistema. Até logo!");
                    return false;  // Sai do loop da empresa e, consequentemente, do loop principal
                case 1:
                    loopEmpresa = false;  // Sai do loop da empresa, mas continua no loop principal
                    break;
                case 2:
                    EmpresaControler.cadastrarEmpresa();
                    break;
                case 3:
                    EmpresaControler.imprimirEmpresas();
                    break;
                case 4:
                    loopEmpresa = menuEditarEmpresa();
                    break;
                case 5:
                    EmpresaControler.apagarCadastroDoSistema();
                    break;
                case 6:
                    OfertaEmpregoControler.cadastrarOfertaEmprego();
                    break;
                case 7:
                    OfertaEmpregoControler.imprimirOfertasEmprego();
                    break;
                case 8:
                    loopEmpresa = menuEditarOfertaEmprego();
                    break;
                case 9:
                    OfertaEmpregoControler.apagarOfertaEmprego();
                    break;
                case 10:
                    EmpresaControler.imprimirTodasEmpresas();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
        return true;  // Continua no loop principal
    }

    public static String imprimirMenuEmpresa() {
        return "\n---- Bem vindo à área destinada às empresas ----\n" +
               "Escolha uma das opções a seguir:\n" +
               "0 - Sair da aplicação\n" +
               "1 - Voltar para o menu principal\n" +
               "2 - Se cadastrar (caso seja usuário novato)\n" +
               "3 - Visualizar cadastro de uma empresa específica\n" +
               "4 - Editar cadastro\n" +
               "5 - Apagar o cadastro da empresa do sistema\n"+
               "6 - Criar oferta de emprego\n" +
               "7 - Visualizar ofertas de emprego da sua empresa que estão abertas\n" +
               "8 - Editar uma oferta de emprego\n" + 
               "9 - Apagar uma oferta de emprego\n" +
               "10 - Visualizar todas as empresas cadastradas no sistema";
    }

    public static boolean menuEditarEmpresa(){
        boolean loopEditarEmpresa = true;

        while (loopEditarEmpresa) {
            System.out.println(imprimirMenurEditarEmpresa());
            int op5 = in.nextInt();
            switch (op5) {
                case 0:
                    loopEditarEmpresa = false;
                    break;
                case 1:
                    EmpresaControler.editarNomeEmpresa();
                    break;
                case 2:
                    EmpresaControler.editarEmailEmpresa();
                    break;
                case 3:
                    EmpresaControler.editarDataCriacaoEmpresa();
                    break;
                case 4:
                    EmpresaControler.editarEnderecoEmpresa();
                    break;
                case 5:
                    EmpresaControler.editarTelefoneEmpresa();
                    break;
                case 6:                    
                    EmpresaControler.editarAreaAtuacaoEmpresa();
                    break;
                case 7:
                    EmpresaControler.editarCNPJEmpresa();
                    break;                    
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenurEditarEmpresa(){
        return 
        "\nQuais dos campos asseguir da empresa você deseja editar?\n" + 
        "1 - Nome\n" + 
        "2 - Email\n" +
        "3 - Data de criação\n" +
        "4 - Endereço\n" +
        "5 - Telefone\n" +
        "6 - Área de atuação\n" +
        "7 - O CNPJ\n" +
        "Digite 0 para voltar ao menu anterior";
    }

    public static boolean menuEditarOfertaEmprego(){
        boolean loopEditarOfertaEmprego = true; 

        while (loopEditarOfertaEmprego) {
            System.out.println(imprimirMenuEditarOfertaEMprego());
            int op7 = in.nextInt();
            switch (op7) {
                case 0:
                    loopEditarOfertaEmprego = false;
                    break;
                case 1:
                    OfertaEmpregoControler.editarOfertaEmpregoSalario();
                    break;
                case 2:
                    OfertaEmpregoControler.editarOfertaEmpregoCargo();
                    break;
                case 3:
                    OfertaEmpregoControler.editarOfertaEmpregoQntdVagas();
                    break;
                case 4:
                    OfertaEmpregoControler.editarOfertaEmpregoEscolaridade();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenuEditarOfertaEMprego(){
        return 
        "\nQuais dos campos a seguir da oferta de emprego você deseja editar?\n" + 
        "1 - Sálario\n" +
        "2 - Cargo\n" +
        "3 - Quantidade de vagas\n" +
        "4 - Escolaridade\n" +
        "Digite 0 para voltar ao menu anterior";
    }

    public static boolean menuFiltroOfertasEmprego(){
        boolean filtrarOfertasEmprego = true;

        while (filtrarOfertasEmprego) {
            System.out.println(imprimirMenuFiltroOfertasEmprego());
            int op6 = in.nextInt();
            switch (op6) {
                case 0:
                    filtrarOfertasEmprego = false;
                    break;
                case 1:
                    CandidatoControler.filtrarOfertasEmpregoTecnologia();
                    break;
                case 2:
                    CandidatoControler.filtrarOfertasEmpregoVendas();
                    break;
                case 3:
                    CandidatoControler.filtrarOfertasEmpregoHospitalar();
                    break;
                case 4:
                    CandidatoControler.filtrarOfertasEmpregoEducacao();
                    break;
                case 5:
                    CandidatoControler.filtrarOfertasEmpregoAlimentos();
                    break;
                case 6:
                    CandidatoControler.filtrarOfertasEmpregoRestantes();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenuFiltroOfertasEmprego(){
        return
        "\nEscolha um dos filtro desejados para visualizar as ofertas de emprego por área de atuação das empresas:\n" + 
        "1 - Tecnologia\n" + 
        "2 - Vendas\n" + 
        "3 - Hospitalar\n" + 
        "4 - Educação\n" + 
        "5 - Alimentos\n" +
        "6 - Área não especificada acima\n" +
        "Digite 0 para voltar ao menu anterior";
    }

    public static boolean menuInscreverOfertaEmprego(){
        boolean filtrarOfertasEmprego = true;

        while (filtrarOfertasEmprego) {
            System.out.println(imprimirMenuInscreverOfertasEmprego());
            int op6 = in.nextInt();
            switch (op6) {
                case 0:
                    filtrarOfertasEmprego = false;
                    break;
                case 1:
                    CandidatoControler.filtrarOfertasEmpregoTecnologia();
                    CandidatoControler.seInscreverOfertaEmpregoAreaTecnologia();
                    break;
                case 2:
                    CandidatoControler.filtrarOfertasEmpregoVendas();
                    CandidatoControler.seInscreverOfertaEmpregoAreaVendas();
                    break;
                case 3:
                    CandidatoControler.filtrarOfertasEmpregoHospitalar();
                    CandidatoControler.seInscreverOfertaEmpregoAreaHospitalar();
                    break;
                case 4:
                    CandidatoControler.filtrarOfertasEmpregoEducacao();
                    CandidatoControler.seInscreverOfertaEmpregoAreaEducacao();
                    break;
                case 5:
                    CandidatoControler.filtrarOfertasEmpregoAlimentos();
                    CandidatoControler.seInscreverOfertaEmpregoAreaAlimentos();
                    break;
                case 6:
                    CandidatoControler.filtrarOfertasEmpregoRestantes();
                    CandidatoControler.seInscreverOfertaEmpregoAreasRestantes();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenuInscreverOfertasEmprego(){
        return
        "\nPara se inscrever:" +
        "\nEscolha um dos filtro desejados para visualizar as ofertas de emprego por área de atuação das empresas:\n" + 
        "1 - Tecnologia\n" + 
        "2 - Vendas\n" + 
        "3 - Hospitalar\n" + 
        "4 - Educação\n" + 
        "5 - Alimentos\n" +
        "6 - Área não especificada acima\n" +
        "Digite 0 para voltar ao menu anterior";
    }
}