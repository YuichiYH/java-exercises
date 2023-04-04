/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nota;

import java.util.Scanner;

/**
 *
 * @author 00342605
 */
public class Nota {
    Scanner entrada = new Scanner(System.in);
    double a1, a2, a3 = 0, media;
    String status, nome, disciplina;
    int resp;
    
    //0.5
    public static void main(String[] args) {
        Nota nota = new Nota();
        nota.nome = nota.EntrarNomeAluno();
        nota.disciplina = nota.EntrarDisciplina();
        nota.EntrarNotas();
        // 0.1
        if(nota.ValidarNota(nota.a1, nota.a2, nota.a3) == 1){
            nota.Sair();
        }
        nota.media = nota.CalcMedia(nota.a1, nota.a2);
        nota.status = nota.CalcStatus1(nota.media);
        if(nota.status.equals("reprovado")){
            System.out.println("Aluno não alcançou a média, precisa fazer A3");
            nota.EntrarNotaA3();
            nota.media = nota.SubstituirNota(nota.a1, nota.a2, nota.a3);
            nota.status = nota.CalcStatus2(nota.media);
        }   
        nota.ExibeBoletim(nota.a1, nota.a2, nota.a3, nota.media, nota.nome, nota.status, nota.disciplina);
    }
    
    // 0.1
    public void EntrarNotas(){
        System.out.print("Digite a nota A1: ");
        this.a1 = this.entrada.nextDouble();
        System.out.print("Digite a nota A2: ");
        this.a2 = this.entrada.nextDouble();
    }
    
    // 0.1
    public void EntrarNotaA3(){
        System.out.print("Digite a nota A3: ");
        this.a3 = this.entrada.nextDouble();
    }
    
    //0.2
    public int ValidarNota(double a1, double a2, double a3){
        if (a1 >= 0 && a1 <= 5 && a2 >= 0 && a2 <= 5 && a3 >= 0 && a3 <= 5){
            return 0;
        }
        else{
            System.out.println("Nota Inválida!");
            return 1;
        }
    }
    
    // 0.1
    public String EntrarNomeAluno(){
        System.out.print("Informe o nome do Aluno: ");
        return this.entrada.nextLine();
    }
    
    // 0.1
    public String EntrarDisciplina(){
        System.out.print("Informe a disciplina: ");
        return this.entrada.nextLine();
    }
    public double CalcMedia(double a1, double a2){return a1 + a2;}
    
    public void Sair(){
        System.out.print("***SISTEMA ENCERRADO****");
        System.exit(0);
    }
    // 0.2
    public String CalcStatus1(double media){return media >= 6 ? "aprovado" : "reprovado";}
    
    // 0.2
    public String CalcStatus2(double media){return media >= 6 ? "aprovado" : "reprovado";}
    
    // 0.3
    public double SubstituirNota(double a1, double a2, double a3){
        if(this.ValidarNota(a1, a2, a3) == 1){
            this.Sair();
        }
        if(a3 < a2 && a3 < a1){return this.CalcMedia(a1, a2);}
        return a1 >=a2 ? this.CalcMedia(a1, a3): this.CalcMedia(a2, a3) ;
    }
    
    public void ExibeBoletim(double a1, double a2, double a3, double media, String nome, String status, String disciplina){
        System.out.println(
                          "*****BOLETIM DO ALUNO*****\n"
                        + "Aluno:" + nome +"\n"
                        + "Disciplina:" + disciplina +"\n"
                        + "Nota A1:" + a1 + "\n" 
                        + "Nota A2:" + a2 + "\n"
                        + "Nota A3:" + a3 + "\n"
                        + "Nota final:" + media + "\n" 
                        + "Situação: Aluno " + status + "\n"
                        + "**************************"
        );
    }
}
