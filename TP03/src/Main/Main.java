package Main;

import java.util.Scanner;

import Controler.Controler;
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
                    Controler.cadastrarCandidato();
                    break;
                case 3:
                    Controler.imprimirCandidatos();
                    break;
                case 4:
                    loopCandidato = menuEditarCandidato();
                    break;
                case 5:
                    loopCandidato = menuFiltroOfertasEmprego();
                    break;
                case 6:
                    System.out.println("Não temos essa opção ainda");
                    break;
                case 7:
                    System.out.println("Não temos essa opção ainda");
                    break;
                case 8:
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
               "3 - Visualizar cadastro\n" +
               "4 - Editar cadastro\n" +
               "5 - Visualizar ofertas de empregos disponíveis\n" +
               "6 - Se inscrever em uma oferta de emprego\n" +
               "7 - Vizualizar ofertas de emprego que você está inscrito\n" +
               "8 - Tirar a sua inscrição de uma oferta de emprego";
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
                    Controler.editarNomeCandidato();
                    break;
                case 2:
                    Controler.editarEmailCandidato();
                    break;
                case 3:
                    Controler.editarDataNascimentoCandidato();
                    break;
                case 4:
                    Controler.editarEnderecoCandidato();
                    break;
                case 5:
                    Controler.editarTelefoneCandidato();
                    break;
                case 6:
                    Controler.editarAreaAtuacaoCandidato();
                    break;
                case 7:
                    Controler.editarCpfCandidato();
                    break;
                case 8:
                    Controler.editarNivelEscolaridadeCandidato();
                    break;
                case 9:
                    Controler.editarInstituicaoCandidato();
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
                    OfertaEmpregoControler.cadastrarOfertaEmprego();
                    break;
                case 6:
                    OfertaEmpregoControler.imprimirOfertasEmprego();
                    break;
                case 7:
                    //OfertaEmpregoControler.editarOfertaEmprego();
                    OfertaEmpregoControler.editarOfertaEmprego();
                    break;
                case 8:
                    OfertaEmpregoControler.apagarOfertaEmprego();
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
               "3 - Visualizar cadastro\n" +
               "4 - Editar cadastro\n" +
               "5 - Criar oferta de emprego\n" +
               "6 - Visualizar ofertas de emprego da sua empresa que estão abertas\n" +
               "7 - Editar uma oferta de emprego\n" + 
               "8 - Apagar uma oferta de emprego";
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

    public static String imprimirMenuEditarOfertaEMprego(){
        return 
        "\nQuais dos campos a seguir da oferta de emprego você deseja editar?\n" + 
        "1 - Sálario\n" +
        "2 - Cargo\n" +
        "3 - Quantidade de vagas\n" +
        "4 - Escolaridade";
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
                    Controler.filtrarOfertasEmpregoTecnologia();
                    break;
                case 2:
                    Controler.filtrarOfertasEmpregoVendas();
                    break;
                case 3:
                    Controler.filtrarOfertasEmpregoHospitalar();
                    break;
                case 4:
                    Controler.filtrarOfertasEmpregoEducacao();
                    break;
                case 5:
                    Controler.filtrarOfertasEmpregoAlimentos();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static String imprimirMenuFiltroOfertasEmprego(){
        return
        "\nEscolha um dos filtro desejados para visualizar as ofertas de emprego por área de atuação:\n" + 
        "1 - Tecnologia\n" + 
        "2 - Vendas\n" + 
        "3 - Hospitalar\n" + 
        "4 - Educação\n" + 
        "5 - Alimentos\n" +
        "Digite 0 para voltar ao menu anterior";
    }
}
