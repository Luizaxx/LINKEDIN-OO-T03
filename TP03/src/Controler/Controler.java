package Controler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Model.*;

public class Controler {

    private static Scanner in = new Scanner(System.in);
    private static Dados d = new Dados();

    public static void cadastrarCandidato() {
        Candidato novoCandidato = lerDadosCandidato();
        d.getCandidatosInscritos().add(novoCandidato);
        System.out.println("Candidato cadastrado com sucesso!");
    }

    public static void editarCadastroCandidato(){
        
        ArrayList<Candidato> candidatos = d.getCandidatosInscritos();
        
        System.out.println("Qual é o seu CPF? ");
        String cpfDesejado = in.nextLine();
        boolean encontrado = false;

        for (Candidato candidato : candidatos){
            if (candidato.getCpf().equals(cpfDesejado)) {
                System.out.println("\nDigite os novos dados para o candidato, "+ candidato.getNome() +":");
                Candidato novosDados = lerDadosCandidato();
                candidato.setNome(novosDados.getNome());
                candidato.setEmail(novosDados.getEmail());
                candidato.setDataNascimento(novosDados.getDataNascimento());
                candidato.setEndereco(novosDados.getEndereco());
                candidato.setTelefone(novosDados.getTelefone());
                candidato.setAreaAtuacao(novosDados.getAreaAtuacao());
                candidato.setCpf(novosDados.getCpf());
                candidato.setNivelEscolaridade(novosDados.getNivelEscolaridade());
                candidato.setInstituicao(novosDados.getInstituicao());
                System.out.println("Casdrato do candidato editado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
        }
    }

    public static void imprimirCandidatos() {
        
        ArrayList<Candidato> candidatos = d.getCandidatosInscritos();
        
        System.out.println("Qual é o seu CPF? ");
        String cpfDesejado = in.nextLine();
        boolean encontrado = false;

        if (candidatos.isEmpty()) { //Verifica se existe candidatos cadastrados no sistema
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {// Verifica se o cpf informado é igual ao cpf que já está salvo no sistema
                    System.out.println(candidato.toString()); // Imprime o toString da classe candidatos
                    encontrado = true;
                    break; // Se encontrou, não precisa continuar procurando
                }
            }
            if (!encontrado) { //Exibe uma mensagem caso o usuário não tenha sido encontrado no sistema
                System.out.println("Nenhum candidato foi encontrado com esse CPF: " + cpfDesejado);
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


    public static void cadastrarEmpresa() {
        Empresa novaEmpresa = lerDadosEmpresa();
        d.getEmpresa().add(novaEmpresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }


    public static void editarCadastroEmpresa(){

        ArrayList<Empresa> empresas = d.getEmpresa();
        
        System.out.println("Para editar o cadastro da empresa primeiro insira o cnpj dela.\nQual é CNPJ da empresa?");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

        for(Empresa empresa : empresas){
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                System.out.println("\nDigite os novos dados da empresa, " + empresa.getNome() + ":");
                Empresa novosDados = lerDadosEmpresa();
                empresa.setNome(novosDados.getNome());
                empresa.setEmail(novosDados.getEmail());
                empresa.setDataNascimento(novosDados.getDataNascimento());
                empresa.setEndereco(novosDados.getEndereco());
                empresa.setTelefone(novosDados.getTelefone());
                empresa.setAreaAtuacao(novosDados.getAreaAtuacao());
                empresa.setCnpj(novosDados.getCnpj());
                System.out.println("\nCandastro da empresa editado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void imprimirEmpresas(){
        
        ArrayList<Empresa> empresas = d.getEmpresa();
        
        System.out.println("Qual é o CNPJ da empresa? ");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa foi cadastrada no sistema ainda.");
        } else {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println(empresa.toString());
                    encontrado = true;
                    break; // Se encontrou, não precisa continuar procurando
                }
            }
            if (!encontrado) {
                System.out.println("Nenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
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
        ArrayList<Empresa> empresas = d.getEmpresa();        

        System.out.println("Qual é o CNPJ da empresa? ");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;        
        
        for(Empresa empresa : empresas){
            if (empresa.getCnpj().equals(cnpjDesejado)) {
                OfertaEmprego novaOfertaEmprego = lerDadosOfertaEmprego(); 
                empresa.getOfertasOfertadas().add(novaOfertaEmprego);// Adicionando uma nova oferta de emprego no arrayList de ofertasOfertadas da empresa
                System.out.println("Oferta criada com sucesso!");
                encontrado = true;
                break; // Se encontrou, não precisa continuar procurando
            }
        }
        if (!encontrado) {
            System.out.println("Nenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
        }   
    }

    public static void editarOfertaEmprego() {
        ArrayList<Empresa> empresas = d.getEmpresa();

        System.out.println("Qual é o CNPJ da empresa? ");
        
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

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
                encontrado = true;
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }

        if (!encontrado) {
            System.out.println("Não foi encontrada nenhuma empresa com esse CNPJ: " + cnpjDesejado);
        }
    }

    public static void apagarOfertaEmprego(){
        ArrayList<Empresa> empresas = d.getEmpresa();

        System.out.println("Qual é o CNPJ da empresa? ");
        
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

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
                encontrado = true;
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        }

        if (!encontrado) {
            System.out.println("Não foi encontrada nenhuma empresa com esse CNPJ: " + cnpjDesejado);
        }

    }

    public static void imprimirOfertasEmprego(){
        ArrayList<Empresa> empresas = d.getEmpresa();
        
        System.out.println("Qual é o CNPJ da empresa? ");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpjDesejado)){
                
                // Verifica se a empresa tem ofertas de emprego
                if (empresa.getOfertasOfertadas().isEmpty()) {
                    System.out.println("A empresa não tem nenhuma oferta de emprego ainda.");
                } else {
                    System.out.println("Ofertas de emprego para a empresa com CNPJ " + cnpjDesejado + ":");
                    // Imprime as ofertas de emprego
                    for (int i = 0; i < empresa.getOfertasOfertadas().size(); i++) {
                        int numeroOferta = i + 1; // O índice do loop mais 1 representa o número da oferta
                        System.out.println("\nOferta número: " + numeroOferta);
                        System.out.println(empresa.getOfertasOfertadas().get(i).toString());
                    }
                }
                encontrado = true;
                break; // Se encontrou a empresa, não precisa continuar procurando
            }
        } 
        if (!encontrado) {
            System.out.println("Não foi encontrada nenhuma empresa com esse CNPJ: " + cnpjDesejado);
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
