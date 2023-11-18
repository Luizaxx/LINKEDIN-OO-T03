package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Model.*;

public class Controler {

    private static Scanner in = new Scanner(System.in);
    private static Dados d = new Dados();

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();

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
        d.getCandidatosInscritos().add(novoCandidato);
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
        ofertasInscritas = null;

        Candidato cnd = new Candidato(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cpf, nivelEscolaridade, instituicao, ofertasInscritas);
        return cnd;
    }

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
    

    public static void cadastrarEmpresa() {
        Empresa novaEmpresa = lerDadosEmpresa();
        Dados.getEmpresas().add(novaEmpresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }
    
    public static void editarNomeEmpresa(){       

        String cnpjDesejado = CNPJ(); 
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nNome antes colocado para essa empresa: " + empresa.getNome() + ".");
                    System.out.println("Digite o novo nome para essa empresa:");
                    String novoNome = in.nextLine();
                    empresa.setNome(novoNome);
                    System.out.println("Nome editado com sucesso!");
                    break;
                }
            }
        }
    }
 
    public static void editarEmailEmpresa(){       

        String cnpjDesejado = CNPJ(); 
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nEmail antes colocado para essa empresa: " + empresa.getEmail());
                    System.out.println("Digite o novo email para essa empresa:");
                    String novoEmail = in.nextLine();
                    empresa.setEmail(novoEmail);
                    System.out.println("Email editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarDataCriacaoEmpresa(){       

        String cnpjDesejado = CNPJ(); 
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nData de criação antes colocado para essa empresa: " + empresa.getDataNascimento());
                    System.out.println("Digite a nova data de nascimento para essa empresa:");
                    String novaDataCriacao = in.nextLine();
                    empresa.setDataNascimento(novaDataCriacao);
                    System.out.println("Data de criação editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarEnderecoEmpresa(){       
        String cnpjDesejado = CNPJ(); 
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nEndereço antes colocado para essa empresa: " + empresa.getEndereco());
                    System.out.println("Digite o novo endereço para essa empresa:");
                    String novoEndereco = in.nextLine();
                    empresa.setEndereco(novoEndereco);
                    System.out.println("Endereço editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarTelefoneEmpresa(){       
        String cnpjDesejado = CNPJ(); 
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nTelefone antes colocado para essa empresa: " + empresa.getTelefone());
                    System.out.println("Digite o novo telefone para essa empresa:");
                    String novoTelefone = in.nextLine();
                    empresa.setTelefone(novoTelefone);
                    System.out.println("Telefone editado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarAreaAtuacaoEmpresa(){       
        String cnpjDesejado = CNPJ();  
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nÁrea de atuação antes colocado para essa empresa: " + empresa.getAreaAtuacao());
                    System.out.println("Digite a nova área de atuação para essa empresa:");
                    String novaAreaAtuacao = in.nextLine();
                    empresa.setAreaAtuacao(novaAreaAtuacao);
                    System.out.println("Área de atuação editada com sucesso!");
                    break;
                }
            }
        }
    }

    public static void editarCNPJEmpresa(){   
        String cnpjDesejado = CNPJ();    
        if (verificaCNPJ(cnpjDesejado) == true){
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println("\nCNPJ antes colocado para essa empresa: " + empresa.getCnpj());
                    System.out.println("Digite o novo CNPJ para essa empresa:");
                    String novoCNPJ = in.nextLine();
                    empresa.setCnpj(novoCNPJ);
                    System.out.println("CNPJ editado com sucesso!");
                    break;
                }
            }
        }
    }    

    public static void imprimirEmpresas(){

        String cnpjDesejado = CNPJ();

        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa foi cadastrada no sistema ainda.");
        } else {
            if (verificaCNPJ(cnpjDesejado)) {
                for (Empresa empresa : empresas) {
                    if (empresa.getCnpj().equals(cnpjDesejado)) {
                        System.out.println(empresa.toString());
                        break;
                    }
                }
            }
        }
    }     

    public static Empresa lerDadosEmpresa(){
       String nome;
	   String email;
	   String dataNascimento;
	   String endereco;
	   String telefone;
	   String areaAtuacao;
       String cnpj;
	   ArrayList<OfertaEmprego> ofertasOfertadas = new ArrayList<OfertaEmprego>();
       System.out.println("\nDigite os dados da empresa:");
       System.out.println("Qual é o nome da empresa?");
       nome = in.nextLine();
       System.out.println("Qual é o email da Empresa?");
       email = in.nextLine();
       System.out.println("Quando a empresa foi fundada?");
       dataNascimento = in.nextLine();
       System.out.println("Qual é o endereço da empresa?");
       endereco = in.nextLine();
       System.out.println("Qual é o telefone da empresa?");
       telefone = in.nextLine();
       System.out.println("Qual é a área de atuação da empresa?");
       areaAtuacao = in.nextLine();
       System.out.println("Qual é o CNPJ da empresa?");
       cnpj = in.nextLine();;
       ofertasOfertadas = null;

       Empresa y = new Empresa(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cnpj, ofertasOfertadas);
       return y;
    }

    public static void cadastrarOfertaEmprego(){    
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for(Empresa empresa : empresas){
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
                    OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(); 
                    empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no arrayList de ofertasOfertadas da empresa
                    System.out.println("Oferta criada com sucesso!");
                    break; // Se encontrou, não precisa continuar procurando
                }
            } 
        }
    }

    public static void editarOfertaEmprego() {

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

        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado) == true) {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {  
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
