package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Candidato;
import Model.Empresa;
import Model.OfertaEmprego;

public class OfertaEmprego_Controler {

    private static Scanner in = new Scanner(System.in);
    private static Dados d = new Dados();

    static ArrayList<Empresa> empresas = d.getEmpresa();
    static ArrayList<Candidato> candidatos = d.getCandidatosInscritos();

    public static boolean verificaCNPJ(){
        System.out.println("Para prosseguir primeiro insira o cnpj da empresa.\nQual é CNPJ da empresa?");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;
        
        for(Empresa empresa : empresas){
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                encontrado = true;
                break;                
            }
        }
        if (!encontrado) {
            System.out.println("Nenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
        return encontrado;
    }

    public static void cadastrarOfertaEmprego(){          
        for(Empresa empresa : empresas){
            if (verificaCNPJ() == true) {
                OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(); 
                empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no arrayList de ofertasOfertadas da empresa
                System.out.println("Oferta criada com sucesso!");
                break; // Se encontrou, não precisa continuar procurando
            }
        } 
    }

    public static void editarOfertaEmprego() {

        for (Empresa empresa : empresas) {
            if (verificaCNPJ() == true) {
                // Verifica se a empresa tem ofertas de emprego
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                } else {
                    System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                    
                    // Imprime as ofertas de emprego com números
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                        System.out.println("\nOferta número: " + numeroOferta);
                        System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                    }

                    System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja editar? (Digite o número da oferta)");
                    int numeroOfertaEscolhida = in.nextInt();

                    // Verifica se o número da oferta escolhida é válido
                    if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                        // Obtém a oferta escolhida
                        OfertaEmprego ofertaParaEditar = empresa.getOfertasOfertadas().get(numeroOfertaEscolhida - 1);
                        
                        System.out.println("Novo salário: ");
                        double novoSalario = in.nextDouble();
                        ofertaParaEditar.setSalario(novoSalario);

                        in.nextLine();
                        System.out.println("Novo cargo: ");
                        String novoCargo = in.nextLine();
                        ofertaParaEditar.setCargo(novoCargo);

                        System.out.println("Nova quantidade de vagas: ");
                        int novaQntdVagas = in.nextInt();
                        ofertaParaEditar.setQntVagas(novaQntdVagas);

                        in.nextLine();
                        System.out.println("Qual novo nível de escolaridade necessário? ");
                        String novoNivelEscolaridade = in.nextLine();
                        ofertaParaEditar.setEscolaridade(novoNivelEscolaridade);

                        System.out.println("\nOferta editada com sucesso!");
                    } else {
                        System.out.println("\nNúmero de oferta inválido.");
                    }
                }
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }
    }

    public static void editarOfertaEmpregoSalario(){

    }

    public static void editarOfertaEmpregoCargo(){
        
    }

    public static void editarOfertaEmpregoQntdVagas(){
        
    }

    public static void editarOfertaEmpregoEscolaridade(){
        
    }

    public static void apagarOfertaEmprego(){

        for (Empresa empresa : empresas) {
            if (verificaCNPJ() == true) {
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                }else{
                    // Verifica se a empresa tem ofertas de emprego
                    System.out.println("Ofertas de emprego ofertada pela empresa "+ empresa.getNome() +":");
                        
                    // Imprime as ofertas de emprego com números
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                        System.out.println("\nOferta número: " + numeroOferta);
                        System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                    }

                    System.out.println("\nQual oferta da empresa " + empresa.getNome() +" você deseja apagar? (Digite o número da oferta)");
                    int numeroOfertaEscolhida = in.nextInt();

                    // Verifica se o número da oferta escolhida é válido
                    if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()){     
                        //removendo a oferta de emprego da empresa              
                        empresa.getOfertasOfertadas().remove(numeroOfertaEscolhida - 1);
                        System.out.println("\nOferta de emprego removida com sucesso!");
                    }else{
                        System.out.println("\nNúmero de oferta inválido.");
                    }
                }
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }
    }

    public static void imprimirOfertasEmprego(){

        for (Empresa empresa : empresas) {
            if (verificaCNPJ() == true){                
                // Verifica se a empresa tem ofertas de emprego
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                } else {
                    System.out.println("Ofertas de emprego para a empresa " + empresa.getNome() + ":");
                    // Imprime as ofertas de emprego
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                        System.out.println("\nOferta número: " + numeroOferta);
                        System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                    }
                }
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }
    }

    public static OfertaEmprego lerDadosOfertaEmprego(){
        double salario;
	    String cargo;
	    int qntVagas;
	    LocalDateTime criadoEm;
	    String escolaridade;
	    boolean ativa; 

        System.out.println("Qual é o salário dessa oferta de emprego? ");
        salario = in.nextDouble();
        System.out.println("Qual é o cargo dessa oferta de emprego? ");
        in.nextLine();
        cargo = in.nextLine();
        System.out.println("Quantas vagas serão disponibilizadas para essa vaga? ");
        qntVagas = in.nextInt();
        System.out.println("Qual é o nível de escolaridade necessário para se inscrever nessa atividade? ");
        in.nextLine();
        escolaridade = in.nextLine();
        criadoEm = LocalDateTime.now();
        ativa = true;

        OfertaEmprego ofrtEmprego = new OfertaEmprego(salario, cargo, qntVagas, criadoEm, escolaridade, ativa);
        return ofrtEmprego;
    }
    
}
