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
                    Controler.editarCadastroEmpresa();
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
                    System.out.println("Não temos essa opção ainda");
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
}
