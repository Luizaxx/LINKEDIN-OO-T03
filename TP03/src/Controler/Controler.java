package Controler;

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
   

    public static void imprimirCandidatos() {
        
        ArrayList<Candidato> candidatos = d.getCandidatosInscritos();
        
        System.out.println("Qual é o seu cpf? ");
        String cpfDesejado = in.nextLine();
        boolean encontrado = false;

        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.");
        } else {
            for (Candidato candidato : candidatos) {
                if (candidato.getCpf().equals(cpfDesejado)) {
                    System.out.println(candidato.toString());
                    encontrado = true;
                    break; // Se encontrou, não precisa continuar procurando
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum candidato encontrado com o CPF " + cpfDesejado + ".");
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
        System.out.println("Qual é o seu cpf? ");
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

   public static void imprimirEmpresas() {
        
        ArrayList<Empresa> empresas = d.getEmpresa();
        
        System.out.println("Qual é o seu cnpj? ");
        String cnpjDesejado = in.nextLine();
        boolean encontrado = false;

        if (empresas.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.");
        } else {
            for (Empresa empresa : empresas) {
                if (empresa.getCnpj().equals(cnpjDesejado)) {
                    System.out.println(empresas.toString());
                    encontrado = true;
                    break; // Se encontrou, não precisa continuar procurando
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum candidato encontrado com o CNPJ " + cnpjDesejado + ".");
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
        System.out.println("\nDigite os seus dados:");
        System.out.println("Qual o nome da empresa? ");
        nome = in.nextLine();
        System.out.println("Qual o email da Empresa? ");
        email = in.nextLine();
        System.out.println("Quando a empresa foi fundada? ");
        dataNascimento = in.nextLine();
        System.out.println("Aonde fica a empresa? ");
        endereco = in.nextLine();
        System.out.println("Telefone da empresa: ");
        telefone = in.nextLine();
        System.out.println("Qual a área de atuação da empresa? ");
        areaAtuacao = in.nextLine();
        System.out.println("CNPJ: ");
        cnpj = in.nextLine();;
        ofertasOfertadas = null;

        Empresa y = new Empresa(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cnpj, ofertasOfertadas);
        return y;
    }
    
    
}
