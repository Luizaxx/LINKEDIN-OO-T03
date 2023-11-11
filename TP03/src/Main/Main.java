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
                    System.out.println("Obrigada por utilizar o sistema. Ate logo!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(imprimirMenuCandidato());
                    int op2 = in.nextInt();
                    switch (op2) {
                        case 0:
                            System.out.println("Obrigada por utilizar o sistema. Ate logo!\n");
                            System.exit(0);
                            break;
                        case 1:                
                            imprimirMenuPrincipal();
                            break;
                        case 2:
                            Controler.cadastrarCandidato();  
                            break;
                        case 3:
                            Controler.imprimirCandidatos();                             
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente!\n");
                            break;
                    }
                    break;
                case 2:
                    System.out.println(imprimirMenuEmpresa());
                    int op3 = in.nextInt();
                    switch (op3) {
                        case 0:
                            System.out.println("Obrigada por utilizar o sistema. Ate logo!\n");
                            System.exit(0);
                            break;
                        case 1:
                            imprimirMenuPrincipal();
                            break;
                        case 2:
                            System.out.println("Opção de cadastrar a empresa...");
                            break;
                        case 3:
                            System.out.println("Opção de visualizar cadastro da empresa...");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente!\n");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }
    }

    public static String imprimirMenuPrincipal(){
        String saida = new String
        ("\n-------- Menu Principal --------\n"+
        "Escolha uma das opcoes a seguir:\n");
        saida = saida + "0 - Sair da aplicação\n";
        saida = saida + "1 - Candidato\n";
        saida = saida + "2 - Empresa";
        return saida;
    }

    public static String imprimirMenuCandidato(){
        String saida = new String
        ("\n----- Bem vindo candidato -----\n"+
        "Escolha uma das opcoes a seguir:\n");
        saida = saida + "0 - Sair da aplicação\n";
        saida = saida + "1 - Voltar para o menu principal\n";
        saida = saida + "2 - Se cadastrar\n";
        saida = saida + "3 - Visualizar cadastro";
        return saida;
    }

    public static String imprimirMenuEmpresa(){
        String saida = new String
        ("\n---- Bem vindo a área destinada as empresas ----\n"+
        "Escolha uma das opcoes a seguir:\n");
        saida = saida + "0 - Sair da aplicação\n";
        saida = saida + "1 - Voltar para o menu principal\n";
        saida = saida + "2 - Se cadastrar\n";
        saida = saida + "3 - Visualizar cadastro";
        return saida;
    }
}
