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
                System.out.println("\nDigite os novos dados para o candidato:");
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

        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi cadastrado no sistema ainda.");
        } else {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    System.out.println(candidato.toString());
                    encontrado = true;
                    break; // Se encontrou, não precisa continuar procurando
                }
            }
            if (!encontrado) {
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
                System.out.println("\nDigite os novos dados da empresa: ");
                Empresa novosDados = lerDadosEmpresa();
                empresa.setNome(novosDados.getNome());
                empresa.setEmail(novosDados.getEmail());
                empresa.setDataNascimento(novosDados.getDataNascimento());
                empresa.setEndereco(novosDados.getEndereco());
                empresa.setTelefone(novosDados.getTelefone());
                empresa.setAreaAtuacao(novosDados.getAreaAtuacao());
                empresa.setCnpj(novosDados.getCnpj());
                System.out.println("Candastro da empresa editado com sucesso!");
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
                empresa.getOfertasOfertadas().add(novaOfertaEmprego);
                System.out.println("Oferta criada com sucesso!");
                encontrado = true;
                break; // Se encontrou, não precisa continuar procurando
            }
        }
        if (!encontrado) {
            System.out.println("Nenhuma empresa foi encontrada com esse CNPJ: " + cnpjDesejado);
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
        cargo = in.nextLine();
        in.nextLine();
        System.out.println("Quantas vagas serão disponibilizadas para essa vaga? ");
        qntVagas = in.nextInt();
        System.out.println("Qual é o nível de escolaridade necessário para se inscrever nessa atividade? ");
        escolaridade = in.nextLine();
        in.nextLine();
        criadoEm = LocalDateTime.now();
        ativa = true;

        OfertaEmprego ofrtEmprego = new OfertaEmprego(salario, cargo, qntVagas, criadoEm, escolaridade, ativa);
        return ofrtEmprego;
    }
    
    
}
