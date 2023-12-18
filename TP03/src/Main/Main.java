package main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controler.CandidatoControler;
import controler.Dados;
import controler.EmpresaControler;
import controler.OfertaEmpregoControler;
import model.Candidato;

public class Main {

    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            int op1 = imprimirMenuPrincipal();
            switch (op1) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
                    break;
                case 1:
                    loop = menuCandidato();
                    break;
                case 2:
                    loop = menuEmpresa();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
    }

    public static int imprimirMenuPrincipal(){
       String frameTitle = "Menu Principal";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Escolha uma das opções a seguir:\n" +
            "0 - Sair da aplicação\n" +
            "1 - Candidato\n" +
            "2 - Empresa",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
       // Verificando se o input é nulo
       if (input == null) {
            return 0; // Saindo do sistema
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            return -1; //Indicador de opção invalida
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }

    public static boolean menuCandidato() {
        boolean loopCandidato = true;
        while (loopCandidato) {
            
            int op2 = imprimirMenuCandidato();
            switch (op2) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
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
                    String cpfDesejado = CandidatoControler.CPF();
                    CandidatoControler.editarDados(cpfDesejado);
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
                    //JOptionPane.showMessageDialog(null, "Os dados foram impressos no terminal");
                    CandidatoControler.imprimirCadastroTodosClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;  // Continua no loop principal
    }     

    public static int imprimirMenuCandidato(){
       int op;
       String input = JOptionPane.showInputDialog(
       null,"Escolha uma das opções a seguir:\n" +
            "0 - Sair da aplicação\n" +
            "1 - Voltar para o menu principal\n" +
            "2 - Se cadastrar (caso seja usuário novato)\n" +
            "3 - Visualizar cadastro de cliente específico\n" +
            "4 - Editar cadastro\n" +
            "5 - Apagar o seu cadastro do sistema\n" +
            "6 - Visualizar ofertas de empregos disponíveis\n" +
            "7 - Se inscrever em uma oferta de emprego\n" +
            "8 - Vizualizar ofertas de emprego que você está inscrito\n" +
            "9 - Retirar a sua inscrição de uma oferta de emprego\n"+
            "10 - Visualizar todos os candidatos cadastrados no sistema",
            "Ben vindo candidato", 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            // Volta ao menu principal
            return 1; 
       }
       // Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            //Indicador de opção invalida
            return -1; 
       }       
       op = Integer.parseInt(input);       
       return op;
    }

    public static boolean menuEmpresa() {
        boolean loopEmpresa = true;

        while (loopEmpresa) {
            int op4 = imprimirMenuEmpresa();
            switch (op4) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigada por utilizar o sistema. Até logo!");
                    System.exit(0);
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
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;  // Continua no loop principal
    }
  
    public static int imprimirMenuEmpresa(){
       String frameTitle = "Bem vindo à área destinada às empresas";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Escolha uma das opções a seguir:\n" +
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
             "10 - Visualizar todas as empresas cadastradas no sistema",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            // Volta para o menu principal
            return 1; 
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            //Indicador de opção invalida
            return -1; 
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }

    public static boolean menuEditarEmpresa(){
        boolean loopEditarEmpresa = true;

        while (loopEditarEmpresa) {
            int op5 = imprimirMenurEditarEmpresa();
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
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }
  
    public static int imprimirMenurEditarEmpresa(){
       String frameTitle = "Menu editar cadastro da empresa";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Quais dos campos asseguir da empresa você deseja editar?\n" + 
            "1 - Nome\n" + 
            "2 - Email\n" +
            "3 - Data de criação\n" +
            "4 - Endereço\n" +
            "5 - Telefone\n" +
            "6 - Área de atuação\n" +
            "7 - O CNPJ\n" +
            "Digite 0 para voltar ao menu anterior",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            return 0; // volta para o meni anterior
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            return -1; //Indicador de opção invalida
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }

    public static boolean menuEditarOfertaEmprego(){
        boolean loopEditarOfertaEmprego = true; 

        while (loopEditarOfertaEmprego) {
            int op7 = imprimirMenuEditarOfertaEMprego();
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
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }
 
    public static int imprimirMenuEditarOfertaEMprego(){
       String frameTitle = "Menu editar oferta de emprego";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Quais dos campos a seguir da oferta de emprego você deseja editar?\n" + 
            "1 - Sálario\n" +
            "2 - Cargo\n" +
            "3 - Quantidade de vagas\n" +
            "4 - Escolaridade\n" +
            "Digite 0 para voltar ao menu anterior",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            return 0; // volta para o meni anterior
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            return -1; //Indicador de opção invalida
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }

    public static boolean menuFiltroOfertasEmprego(){
        boolean filtrarOfertasEmprego = true;

        while (filtrarOfertasEmprego) {
            int op6 = imprimirMenuFiltroOfertasEmprego();
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
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }

    public static int imprimirMenuFiltroOfertasEmprego(){
       String frameTitle = "Menu filtrar oferta de emprego";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Escolha um dos filtro desejados para visualizar as \nofertas de emprego por área de atuação das empresas:\n" + 
            "\n1 - Tecnologia\n" + 
            "2 - Vendas\n" + 
            "3 - Hospitalar\n" + 
            "4 - Educação\n" + 
            "5 - Alimentos\n" +
            "6 - Área não especificada acima\n" +
            "Digite 0 para voltar ao menu anterior",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            return 0; // volta para o meni anterior
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            return -1; //Indicador de opção invalida
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }

    public static boolean menuInscreverOfertaEmprego(){
        boolean filtrarOfertasEmprego = true;

        while (filtrarOfertasEmprego) {           
            int op6 = imprimirMenuInscreverOfertasEmprego();
            switch (op6) {
                case 0:
                    filtrarOfertasEmprego = false;
                    break;
                case 1:
                    CandidatoControler.seInscreverOfertaEmpregoAreaTecnologia();
                    break;
                case 2:                    
                    CandidatoControler.seInscreverOfertaEmpregoAreaVendas();
                    break;
                case 3:                    
                    CandidatoControler.seInscreverOfertaEmpregoAreaHospitalar();
                    break;
                case 4:                    
                    CandidatoControler.seInscreverOfertaEmpregoAreaEducacao();
                    break;
                case 5:                    
                    CandidatoControler.seInscreverOfertaEmpregoAreaAlimentos();
                    break;
                case 6:                   
                    CandidatoControler.seInscreverOfertaEmpregoAreasRestantes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        }
        return true;
    }

    public static int imprimirMenuInscreverOfertasEmprego(){
       String frameTitle = "Se inscrever em uma vaga de emprego";
       JFrame frame = new JFrame(frameTitle);
       int op;
       String input = JOptionPane.showInputDialog(
       frame,"Para se inscrever:" +
            "\nEscolha um dos filtro desejados para visualizar as\nofertas de emprego por área de atuação das empresas:\n" + 
            "\n1 - Tecnologia\n" + 
            "2 - Vendas\n" + 
            "3 - Hospitalar\n" + 
            "4 - Educação\n" + 
            "5 - Alimentos\n" +
            "6 - Área não especificada acima\n" +
            "Digite 0 para voltar ao menu anterior",
            frameTitle, 
            JOptionPane.PLAIN_MESSAGE);
        // Verificando se o input é nulo
       if (input == null) {
            return 0; // volta para o meni anterior
       }// Verificando se o input é vazio
       if (input.trim().isEmpty()) {
            return -1; //Indicador de opção invalida
       }       
       op = Integer.parseInt(input);
       frame.dispose(); //Fechando o frame
       return op;
    }
}