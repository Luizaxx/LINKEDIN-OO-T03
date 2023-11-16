package Main;

import java.util.Scanner;

import Controler.Controler;

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
                    Controler.editarCadastroCandidato();
                    break;
                case 5:
                    System.out.println("Não temos essa opção ainda");
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
        "9 - Instituição de ensino";
    }

    public static boolean menuEmpresa() {
        boolean loopEmpresa = true;

        while (loopEmpresa) {
            System.out.println(imprimirMenuEmpresa());
            int op3 = in.nextInt();

            switch (op3) {
                case 0:
                    System.out.println("Obrigada por utilizar o sistema. Até logo!");
                    return false;  // Sai do loop da empresa e, consequentemente, do loop principal
                case 1:
                    loopEmpresa = false;  // Sai do loop da empresa, mas continua no loop principal
                    break;
                case 2:
                    Controler.cadastrarEmpresa();
                    break;
                case 3:
                    Controler.imprimirEmpresas();
                    break;
                case 4:
                    loopEmpresa = menuEditarEmpresa();
                    break;
                case 5:
                    Controler.cadastrarOfertaEmprego();
                    break;
                case 6:
                    Controler.imprimirOfertasEmprego();
                    break;
                case 7:
                    Controler.editarOfertaEmprego();
                    break;
                case 8:
                    Controler.apagarOfertaEmprego();
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
            int op4 = in.nextInt();
            switch (op4) {
                case 0:
                    loopEditarEmpresa = false;
                    break;
                case 1:
                    Controler.editarNomeEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 2:
                    Controler.editarEmailEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 3:
                    Controler.editarDataCriacaoEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 4:
                    Controler.editarEnderecoEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 5:
                    Controler.editarTelefoneEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 6:                    
                    Controler.editarAreaAtuacaoEmpresa();
                    loopEditarEmpresa = false;
                    break;
                case 7:
                    Controler.editarCNPJEmpresa();
                    loopEditarEmpresa = false;
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
        "Caso deseje voltar para o menu anterior digite: 0";
    }

    public static String imprimirMenuEditarOfertaEMprego(){
        return 
        "\nQuai dos campos asseguir da oferta de emprego você deseja editar?\n" + 
        "1 - Sálario\n" +
        "2 - Cargo\n" +
        "3 - Quantidade de vagas\n" +
        "4 - Escolaridade";
    }
}
