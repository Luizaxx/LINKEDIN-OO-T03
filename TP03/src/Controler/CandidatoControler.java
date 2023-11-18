package Controler;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Candidato;
import Model.Empresa;

public class CandidatoControler {
    
    private static Scanner in = new Scanner(System.in);

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

}
