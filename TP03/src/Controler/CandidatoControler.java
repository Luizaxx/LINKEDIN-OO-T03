package Controler;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Candidato;
import Model.Empresa;
import Model.OfertaEmprego;

public class CandidatoControler {
    
    private static Scanner in = new Scanner(System.in);

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();
    static ArrayList<OfertaEmprego> ofertasInscritas = Dados.getOfertasInscritas();

    public static String CPF(){        
        System.out.println("Qual é o seu CPF? ");
        String cpfDesejado = in.nextLine();
        return cpfDesejado;
    }

    public static boolean verificaCPF(String cpfDesejado){
        
        boolean encontrado = false;
        
        for (Candidato candidato : candidatos){
            if (candidato.getCpf().equals(cpfDesejado)) {
                encontrado = true;
                break;                
            }
        }
        if (!encontrado) {
            System.out.println("\nNenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
        }
        return encontrado;
    }

    public static void cadastrarCandidato(){
        Candidato novoCandidato = lerDadosCandidato();
        Dados.getCandidatosInscritos().add(novoCandidato);
        System.out.println("Candidato cadastrado com sucesso!");
    }

    public static void editarNomeCandidato(){

        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo nome cadastrado no seu cadastro: "+ candidato.getNome());
                    System.out.println("Digite o novo nome:");
                    String novoNome = in.nextLine();
                    candidato.setNome(novoNome);
                    System.out.println("Nome editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarEmailCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo email cadastrado no seu cadastro: "+ candidato.getEmail());
                    System.out.println("Digite o novo email:");
                    String novoEmail = in.nextLine();
                    candidato.setEmail(novoEmail);
                    System.out.println("Email editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarDataNascimentoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntiga data de nascimento cadastrado no seu cadastro: "+ candidato.getDataNascimento());
                    System.out.println("Digite a nova data de nascimento:");
                    String novaDataNascimento = in.nextLine();
                    candidato.setDataNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarEnderecoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo endereço cadastrado no seu cadastro: "+ candidato.getEndereco());
                    System.out.println("Digite o novo endereço:");
                    String novoEndereco = in.nextLine();
                    candidato.setEndereco(novoEndereco);
                    System.out.println("Endereço editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarTelefoneCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo telefone cadastrado no seu cadastro: "+ candidato.getTelefone());
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = in.nextLine();
                    candidato.setTelefone(novoTelefone);
                    System.out.println("Telefone editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarAreaAtuacaoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntiga área de atuação cadastrado no seu cadastro: "+ candidato.getAreaAtuacao());
                    System.out.println("Digite a nova área de atuação:");
                    String novaAreaAtuacao = in.nextLine();
                    candidato.setAreaAtuacao(novaAreaAtuacao);
                    System.out.println("Área de atuação editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarCpfCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo CPF cadastrado no seu cadastro: "+ candidato.getCpf());
                    System.out.println("Digite o novo CPF:");
                    String novoCPF = in.nextLine();
                    candidato.setCpf(novoCPF);
                    System.out.println("CPF editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarNivelEscolaridadeCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntigo nível de escolaridade cadastrado no seu cadastro: "+ candidato.getNivelEscolaridade());
                    System.out.println("Digite o novo nível de escolaridade:");
                    String novoNivelEscolaridade = in.nextLine();
                    candidato.setNivelEscolaridade(novoNivelEscolaridade);
                    System.out.println("Nível de escolaridade editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarInstituicaoCandidato(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                    System.out.println("\nAntiga instituiçã cadastradá no seu cadastro: "+ candidato.getInstituicao());
                    System.out.println("Digite o novo nome da instituição:");
                    String novaInstituicao = in.nextLine();
                    candidato.setInstituicao(novaInstituicao);
                    System.out.println("Nome da instituição editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void filtrarOfertasEmpregoTecnologia(){
       for(Empresa empresa : empresas){
            if ("Tecnologia".equals(empresa.getAreaAtuacao())) {
                System.out.println("\nOfertas de emprego da área de Tecnologia da empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }
            }
        }
    }

    public static void filtrarOfertasEmpregoVendas(){
       for(Empresa empresa : empresas){
            if ("Vendas".equals(empresa.getAreaAtuacao())){
                System.out.println("\nOfertas de emprego da área de Vendas da empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }   
            }
        }
    }

    public static void filtrarOfertasEmpregoAlimentos(){
       for(Empresa empresa : empresas){
            if ("Alimentos".equals(empresa.getAreaAtuacao())){
                System.out.println("\nOfertas de emprego da área de Alimentícia a empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }      
            }
        }
    }

    public static void filtrarOfertasEmpregoHospitalar(){
       for(Empresa empresa : empresas){
            if ("Hospitalar".equals(empresa.getAreaAtuacao())) {
                System.out.println("\nOfertas de emprego da área Hospitalar da empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }      
            }
        }
    }

    public static void filtrarOfertasEmpregoEducacao(){
       for(Empresa empresa : empresas){
            if ("Educação".equals(empresa.getAreaAtuacao())){
                System.out.println("\nOfertas de emprego da área de educação da empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }         
            }
        }
    }

    public static void imprimirOfertasEmpregoSemFiltro(){
        for(Empresa empresa : empresas){
            if ((empresa.getAreaAtuacao() != "Educação") && (empresa.getAreaAtuacao() != "Hospitalar") && (empresa.getAreaAtuacao() != "Alimentos") && (empresa.getAreaAtuacao() != "Vendas") && (empresa.getAreaAtuacao() != "Tecnologia")){
                System.out.println("\nOfertas de emprego da área de educação da empresa " + empresa.getNome() + ":");
                // Imprime as ofertas de emprego
                for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                    int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                    System.out.println("\nOferta número: " + numeroOferta);
                    System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                }         
            }else{
                System.out.println("Não temos nenhuma oferta de emprego que abrange outras áreas de atuação.");
                break;
            }
        }
    }

    public static void imprimirCandidatos() {

        String cpfDesejado = CPF();

        if (candidatos.isEmpty()) { //Verifica se existe candidatos cadastrados no sistema
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            
        if (verificaCPF(cpfDesejado) == true){
            for (Candidato candidato : candidatos){
                if (candidato.getCpf().equals(cpfDesejado)){
                        System.out.println(candidato.toString()); // Imprime o toString da classe candidatos
                        break; // Se encontrou, não precisa continuar procurando
                    }
                }
            }
        }
    }

    
    public static void imprimirOfertasEmpregoInscritas(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado) == true){     
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {           
                    // Verifica se a empresa tem ofertas de emprego
                    if (ofertasInscritas.isEmpty()) {
                        System.out.println("O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        System.out.println("Ofertas de emprego inscritas\nEmpresa: " + candidato.getNome() + ":");
                        // Imprime as ofertas de emprego
                        // for (int i = 0; i < candidato.getOfertasInscritas().size(); i++) {
                        //     int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                        //     System.out.println("\nOferta número: " + numeroOferta);
                        //     System.out.println(candidato.getOfertasInscritas().get(i).toString());
                        // }
                        System.out.println("Ofertas Inscritas:");
                        for (OfertaEmprego oferta : ofertasInscritas) {
                            System.out.println(oferta);
                        }
                    }
                    break; // Se encontrou a empresa, não precisa continuar procurando
                }
            }
        }
    }
     

    public static Candidato lerDadosCandidato(){
        String nome;
	    String email;
	    String dataNascimento;
	    String endereco;
	    String telefone;
	    String areaAtuacao;
        String cpf;
	    String nivelEscolaridade;
	    String instituicao;
	    ArrayList<OfertaEmprego> ofertasInscritas = new ArrayList<OfertaEmprego>();
        System.out.println("\nDigite os seus dados:");
        System.out.println("Qual é o seu nome? ");
        nome = in.nextLine();
        System.out.println("Quel é o seu email? ");
        email = in.nextLine();
        System.out.println("Qual é a sua data de nascimento? ");
        dataNascimento = in.nextLine();
        System.out.println("Qual é o seu endereço? ");
        endereco = in.nextLine();
        System.out.println("Qual o seu telefone? ");
        telefone = in.nextLine();
        System.out.println("Qual a sua área de atuação? ");
        areaAtuacao = in.nextLine();
        System.out.println("Qual é o seu CPF? ");
        cpf = in.nextLine();
        System.out.println("Quel é o seu nível de escolaridade? ");
        nivelEscolaridade = in.nextLine();
        System.out.println("Qual o nome da instituição? ");
        instituicao = in.nextLine();

        Candidato cnd = new Candidato(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cpf, nivelEscolaridade, instituicao, ofertasInscritas);
        return cnd;
    }

    // public static void verOfertasDisponiveisTecnologia() {

    //     System.out.println("Ofertas Disponíveis:");
    //     int i = 1;
        
    //     for (Empresa empresa : empresas) {
    //         if ("Tecnologia".equals(empresa.getAreaAtuacao())) {
    //             for (OfertaEmprego oferta : empresa.getOfertasOfertadas()) {
    //                 System.out.println(i + ". " + oferta);
    //                 i++;
    //             }
    //         }
    //     }

    //     System.out.println("Escolha o número da oferta que deseja se inscrever (ou 0 para sair): ");
    //     int escolha = in.nextInt();
    //     in.nextLine(); // Limpar o buffer do scanner

    //     String cpfDesejado = CPF();
    //     if (verificaCPF(cpfDesejado) == true){ 
    //         if (escolha > 0 && escolha <= i) {
                
    //             for (Candidato candidato : candidatos){
    //                 if (candidato.getCpf().equals(cpfDesejado)) {
    //                     OfertaEmprego ofertaEscolhida = obterOfertaPeloIndice(escolha);
    //                     candidato.adicionarOfertaEmprego(ofertaEscolhida);
    //                     System.out.println("Inscrição realizada com sucesso!");
    //                 break;
    //                 }
    //             }
    //         } else {
    //             System.out.println("Escolha inválida. Nenhuma inscrição realizada.");
    //         }
    //     }
    // }

    // private static OfertaEmprego obterOfertaPeloIndice(int indice) {
    //     int i = 1;
    //     for (Empresa empresa : empresas) {
    //         for (OfertaEmprego oferta : empresa.getOfertasOfertadas()) {
    //             if (i == indice) {
    //                 return oferta;
    //             }
    //             i++;
    //         }
    //     }
    //     return null;
    // }

}
