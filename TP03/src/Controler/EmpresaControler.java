package Controler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Model.Candidato;
import Model.Empresa;
import Model.OfertaEmprego;

public class EmpresaControler {

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

    public static void cadastrarEmpresa() {
        Empresa novaEmpresa = lerDadosEmpresa();
        Dados.getEmpresas().add(novaEmpresa);
        System.out.println("Empresa cadastrada com sucesso!");
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

    public static void imprimirTodasEmpresas(){
        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa foi cadastrada no sistema ainda.");
        }else{
            for (Empresa empresa : empresas) {
                System.out.println(empresa.toString());
            }
        }
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
    
    public static void apagarCadastroDoSistema() {
        String cnpjDesejado = CNPJ();
        if (verificaCNPJ(cnpjDesejado)) {
            Iterator<Empresa> iterator = empresas.iterator();
            while (iterator.hasNext()) {
                Empresa empresa = iterator.next();
                if (empresa != null && empresa.getCnpj().equals(cnpjDesejado)) {
                    // Remova a oferta da empresa excluída dos candidatos
                    CandidatoControler.removerOfertaEmpregoCandidatos(cnpjDesejado);

                    iterator.remove(); // Remove a empresa usando o iterador
                    System.out.println("Empresa removida com sucesso!");
                    break; // Se encontrou a empresa, não precisa continuar procurando
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
       cnpj = in.nextLine();
       if (verificaCNPJ(cnpj)) {
        System.out.println("\nEssa empresa já existe no sistema.\n");
            return null;
       }
       Empresa y = new Empresa(nome, email, dataNascimento, endereco, telefone, areaAtuacao, cnpj, ofertasOfertadas);
       return y;
    }    
}