package controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Candidato;
import model.Empresa;
import model.OfertaEmprego;

public class CandidatoControler {
    
    private static Scanner in = new Scanner(System.in);

    static ArrayList<Empresa> empresas = Dados.getEmpresas();
    static ArrayList<Candidato> candidatos = Dados.getCandidatosInscritos();
    static ArrayList<OfertaEmprego> ofertasInscritas = Dados.getOfertasInscritas();
    static ArrayList<OfertaEmprego> ofertasTecnologia = Dados.getOfertasTecnologia();
    static ArrayList<OfertaEmprego> ofertasVendas = Dados.getOfertasVendas();
    static ArrayList<OfertaEmprego> ofertaHospitalares = Dados.getOfertasHospitalar();
    static ArrayList<OfertaEmprego> ofertasAlimentos = Dados.getOfertasAlimentos();
    static ArrayList<OfertaEmprego> ofertasEducacao = Dados.getOfertasEducacao();
    static ArrayList<OfertaEmprego> ofertasRestantes = Dados.getOfertasRestantes();

    public static String CPF(){        
        System.out.println("\nQual é o seu CPF? ");
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

    public static void apagarCadastroDoSistema(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            Iterator<Candidato> iterator = candidatos.iterator();
            while (iterator.hasNext()) {
                Candidato candidato = iterator.next();
                if (candidato.getCpf().equals(cpfDesejado)) {
                    iterator.remove(); // Remove o candidato usando o iterador
                    System.out.println("Candidato removido com sucesso!");
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        }
    }

    public static void removerOfertaEmpregoCandidatos(String cnpjEmpresa) {
        Iterator<Candidato> iterator = candidatos.iterator();
        while (iterator.hasNext()) {
            Candidato candidato = iterator.next();
            if (candidato.getOfertasInscritas() != null) {
                Iterator<OfertaEmprego> ofertaIterator = candidato.getOfertasInscritas().iterator();
                while (ofertaIterator.hasNext()) {
                    OfertaEmprego oferta = ofertaIterator.next();
                    if (oferta.getEmpresa() != null && oferta.getEmpresa().getCnpj().equals(cnpjEmpresa)) {
                        ofertaIterator.remove();
                    }
                }
            }
        }
    }

    public static void filtrarOfertasEmpregoTecnologia(){  
        for (OfertaEmprego ofertaTecnologia : ofertasTecnologia) {
            int numeroOferta = ofertasTecnologia.indexOf(ofertaTecnologia) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaTecnologia);
        }
    }

    public static void filtrarOfertasEmpregoVendas(){
       for(OfertaEmprego ofertaVendas : ofertasVendas){
            int numeroOferta = ofertasVendas.indexOf(ofertaVendas) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaVendas);
       }
    }

    public static void filtrarOfertasEmpregoAlimentos(){
       for(OfertaEmprego ofertaAlimentos : ofertasAlimentos){
            int numeroOferta = ofertasAlimentos.indexOf(ofertaAlimentos) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaAlimentos);
       }
    }

    public static void filtrarOfertasEmpregoHospitalar(){
       for(OfertaEmprego ofertaHospitalar : ofertaHospitalares){
            int numeroOferta = ofertaHospitalares.indexOf(ofertaHospitalar) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaHospitalar);
       }
    }

    public static void filtrarOfertasEmpregoEducacao(){
       for(OfertaEmprego ofertaEducacao : ofertasEducacao){
            int numeroOferta = ofertasEducacao.indexOf(ofertaEducacao) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaEducacao);
       }
    }

    public static void filtrarOfertasEmpregoRestantes(){
        for(OfertaEmprego ofertaRestante : ofertasRestantes){
            int numeroOferta = ofertasRestantes.indexOf(ofertaRestante) + 1;
            System.out.println("\nOferta número: " + numeroOferta);
            System.out.println(ofertaRestante);
        }
    }

    public static void seInscreverOfertaEmpregoAreaTecnologia() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasTecnologia.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasTecnologia.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
   
    public static void seInscreverOfertaEmpregoAreaVendas() {
        String cpfDesejado = CPF();
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasVendas.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasVendas.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
   
    public static void seInscreverOfertaEmpregoAreaHospitalar() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você que se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertaHospitalares.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertaHospitalares.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
     
    public static void seInscreverOfertaEmpregoAreaAlimentos() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasAlimentos.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasAlimentos.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
      
    public static void seInscreverOfertaEmpregoAreaEducacao() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasEducacao.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasEducacao.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
                }
            }
        }
    }
     
    public static void seInscreverOfertaEmpregoAreasRestantes() {
        String cpfDesejado = CPF();    
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            if (verificaCPF(cpfDesejado)) {
                System.out.println("Digite o número da oferta que você quer se inscrever:");
                int numeroOferta = in.nextInt();    
                // Verificar se o número da oferta é válido
                if (numeroOferta > 0 && numeroOferta <= ofertasRestantes.size()) {
                    for (Candidato candidato : candidatos) {
                        if (candidato.getCpf().equals(cpfDesejado)) {
                            OfertaEmprego ofertaSelecionada = ofertasRestantes.get(numeroOferta - 1);    
                            // Verificar se o candidato já está inscrito
                            if (candidato.getOfertasInscritas().contains(ofertaSelecionada)) {
                                System.out.println("Você já está inscrito nesta oferta!");
                            } else {
                                candidato.adicionarOfertaEmprego(ofertaSelecionada);
                                System.out.println("Inscrição realizada com sucesso!");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Número de oferta inválido!");
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

    public static void imprimirCadastroTodosClientes(){
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        }else{
            for (Candidato candidato : candidatos){
                System.out.println(candidato.toString()); // Imprime o toString da classe candidatos
            }
        }
    }

    public static void imprimirOfertasEmpregoInscritas() {
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    // Verifica se o candidato tem ofertas de emprego inscritas
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        System.out.println("O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    } else {
                        System.out.println("Ofertas de emprego inscritas para " + candidato.getNome() + ":");
                        for (OfertaEmprego oferta : candidato.getOfertasInscritas()) {
                            System.out.println(oferta);
                        }
                    }
                    break; // Se encontrou o candidato, não precisa continuar procurando
                }
            }
        }
    }

    public static void apagarOfertaEmpregoInscrita(){
        String cpfDesejado = CPF();
        if (verificaCPF(cpfDesejado)) {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {  
                    // Verifica se o candidato tem ofertas de emprego inscritas
                    if (candidato.getOfertasInscritas().isEmpty()) {
                        System.out.println("O candidato não tem nenhuma oferta de emprego inscrita ainda.");
                    }else{                        
                        System.out.println("Ofertas de emprego inscritas para "+ candidato.getNome() +":");                            
                        // Imprime as ofertas de emprego com números
                        for (int i = 0; i < candidato.getOfertasInscritas().size(); i++) {
                            int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                            System.out.println("\nOferta número: " + numeroOferta);
                            System.out.println(candidato.getOfertasInscritas().get(i).toString());
                        }
                        System.out.println("\nQual oferta de emprego você deseja retirar sua inscrição? (Digite o número da oferta)");
                        int numeroOfertaEscolhida = in.nextInt();
                        // Verifica se o número da oferta escolhida é válido
                        if (numeroOfertaEscolhida >= 1 && numeroOfertaEscolhida <= candidato.getOfertasInscritas().size()){     
                            //removendo a oferta de emprego da empresa              
                            candidato.getOfertasInscritas().remove(numeroOfertaEscolhida - 1);
                            System.out.println("\nInscrição retirada com sucesso!");
                        }else{
                            System.out.println("\nNúmero de oferta inválido.");
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
        if (verificaCPF(cpf) == true) {
            System.out.println("\nEsse CPF já existe no sistema.\n");
            return null;
        }
        System.out.println("Quel é o seu nível de escolaridade? ");
        nivelEscolaridade = in.nextLine();
        System.out.println("Qual o nome da instituição? ");
        instituicao = in.nextLine();
        Candidato cnd = new Candidato(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cpf, nivelEscolaridade, instituicao, ofertasInscritas);
        return cnd;
    }
}