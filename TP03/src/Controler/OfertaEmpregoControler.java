package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Candidato;
import Model.Empresa;
import Model.OfertaEmprego;

public class OfertaEmpregoControler {

    private static Scanner in = new Scanner(System.in);

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

    public static String CNPJ(){
        System.out.println("Para prosseguir primeiro insira o cnpj da empresa.\nQual é CNPJ da empresa?");
        String cnpjDesejado = in.nextLine();
        return cnpjDesejado;
    }
    
    public static boolean verificaCNPJ(String cnpjDesejado){        
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
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(empresa); 
                    empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no arrayList de ofertasOfertadas da empresa
                    System.out.println("Oferta criada com sucesso!");
                    break; // Se encontrou, não precisa continuar procurando
                }
            } 
        }
    }

    public static void editarOfertaEmpregoSalario(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
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
                            System.out.println("Digite o novo salário: ");
                            double novoSalario = in.nextDouble();
                            ofertaParaEditar.setSalario(novoSalario);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }

    }

    public static void editarOfertaEmpregoCargo(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
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
                            in.nextLine();
                            System.out.println("Digite novo cargo: ");
                            String novoCargo = in.nextLine();
                            ofertaParaEditar.setCargo(novoCargo);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
        
    }

    public static void editarOfertaEmpregoQntdVagas(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
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
                            System.out.println("Digite nova quantidade de vagas: ");
                            int novaQntdVagas = in.nextInt();
                            ofertaParaEditar.setQntVagas(novaQntdVagas);

                            System.out.println("\nOferta editada com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
    }

    public static void editarOfertaEmpregoEscolaridade(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
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
    }

    public static void apagarOfertaEmprego() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    if (empresa.getOfertasOfertadas().isEmpty()) {
                        System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                    } else {
                        // Mostra as ofertas de emprego com números
                        System.out.println("Ofertas de emprego ofertadas pela empresa " + empresa.getNome() + ":");
    
                        for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                            int numeroOferta = i + 1;
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                        }
                        System.out.println("\nQual oferta da empresa " + empresa.getNome() + " você deseja apagar? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= empresa.getOfertasOfertadas().size()) {
                            // Removendo a oferta de emprego da empresa
                            OfertaEmprego ofertaRemovida = empresa.getOfertasOfertadas().remove(numeroOfertaEscolhida - 1);
                            
                            // Removendo a oferta de emprego da lista de ofertas inscritas dos candidatos
                            for (Candidato candidato : candidatos) {
                                if (candidato.getOfertasInscritas().contains(ofertaRemovida)) {
                                    candidato.getOfertasInscritas().remove(ofertaRemovida);
                                    break;
                                }
                            }
                            System.out.println("\nOferta de emprego removida com sucesso!");
                        } else {
                            System.out.println("\nNúmero de oferta inválido.");
                        }
                    }
                    break;
                }
            }
        }
    }
    

    public static void imprimirOfertasEmprego(){
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true){     
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {           
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
    }

    public static OfertaEmprego lerDadosOfertaEmprego(Empresa empresa){
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
        OfertaEmprego ofrtEmprego = new OfertaEmprego(salario, cargo, qntVagas, criadoEm, escolaridade, ativa, empresa);
        return ofrtEmprego;
    }
}