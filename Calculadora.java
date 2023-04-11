/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author 00342605
 */
public class Calculadora {
    int choose, fact,v1, v2;
    double number, percentage, answer;
    boolean verifyMenu, verifyNums, verifyAll, isOdd;
    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        Calculadora calc = new Calculadora();
        
        while(true){
            calc.Menu();
            calc.choose = calc.SelectMenu();
            calc.verifyMenu = calc.MenuValidation(calc.choose);
            if(!calc.verifyMenu){
                continue;
            }
            switch(calc.choose){
            case 1:
                calc.SelectNums();
                calc.Power(calc.v1, calc.v2);
                break;
            case 2:
                calc.SelectFact();
                calc.Factorial(calc.fact);
                break;
            case 3:
                calc.SelectPercentage();
                calc.TotalPercentage(calc.number, calc.percentage);
                break;
            case 4:
                calc.SelectPercentage();
                calc.AddPercentage(calc.number, calc.percentage);
                break;
            case 5:
                calc.SelectPercentage();
                calc.SubPercentage(calc.number, calc.percentage);
                break;
            case 6:
                calc.SelectFact();
                calc.IsOdd(calc.fact);
                break;
            case 7:
                calc.Exit();
            }
        }
    }
    
    public void Menu(){
        /*
        creates a menu and gets an option
        */
        System.out.println("Menu da Calculadora\n"
                + "opção 1 - Calculo de Potencia\n"
                + "opção 2 - Calculo de Fatorial\n"
                + "opção 3 - Calculo de Porcentagem\n"
                + "opção 4 - Calculo de Acrescimo de %\n"
                + "opção 5 - Calculo de Desconto de %\n"
                + "opção 6 - Identificar Par/Impar\n"
                + "opção 7 - Sair do Sisetma\n");
    }
    
    public int SelectMenu(){
        this.verifyMenu = false;
            try{
                System.out.print("Digite a Opção Desejada: ");
                choose = scanner.nextInt();
                return this.choose;
                
            }
            catch(Exception e){
                return 0;
            }
    }
    
    public int[] SelectNums(){
        System.out.print("Informe a Base: ");
        this.v1 = this.scanner.nextInt();
        System.out.print("Informe o expoente: ");
        this.v2 = this.scanner.nextInt();
        return new int[]{this.v1, this.v2};
    }
    
    public int SelectFact(){
        System.out.print("Informe o número : ");
        this.fact = this.scanner.nextInt();
        return this.fact;
    }
    
    public boolean VerfyPosit(int number){
        return number >= 0;
    }
    
    public double[] SelectPercentage(){
        System.out.print("Digite o Valor total: ");
        this.number = this.scanner.nextDouble();
        System.out.print("Digite a taxa da porcentagem: ");
        this.percentage = this.scanner.nextDouble();
        return new double[]{this.v1, this.v2};
    }
    
    public double AddPercentage(double number, double percentage){
        this.answer = number * (1 + (percentage/100));
        System.out.println(number + " + " + percentage + "% de juros = " + this.answer);
        return this.answer;
    }
    
    public double SubPercentage(double number, double percentage){
        this.answer = number * (1 - (percentage/100));
        System.out.println(number + " - " + percentage + "% de Desconto = " + this.answer);
        return this.answer;
    }
    
    public boolean IsOdd(int number){
        this.isOdd = (number%2) == 1;
        if(this.isOdd){
            System.out.println(number + " é um número ímpar");
        }
        else{
            System.out.println(number + " é um número par");
        }
        return this.isOdd;
    }
    
    public double TotalPercentage(double number, double percentage){
        this.answer = number * (percentage/100);
        System.out.println(percentage + "% de " + number + " = " + this.answer);
        return this.answer;
    }
    
    public double Factorial(int number){
        if(!this.VerfyPosit(number)){
            System.out.println("Números negativos não são aceitos.");
            return 0;
        }
        this.answer = 1;
        for(int i = number; i>0; i--){
            this.answer *= i;
        }
        System.out.println("Fatorial de " + number + "! = " + this.answer);
        return this.answer;
    }
    
    public double Power(int base, int exp){
        if(!this.VerfyPosit(base)){
            System.out.println("Números negativos não são aceitos.");
            return 0;
        }
        if(!this.VerfyPosit(exp)){
            System.out.println("Números negativos não são aceitos.");
            return 0;
        }
        this.answer = 1;
        for(int i = 0; i<exp; i++){
            this.answer *= base;
        }
        System.out.println(base + " ^ " + exp + " = " + this.answer);
        return this.answer;
    }
    
    public boolean MenuValidation(int option){
        if(option > 7 || option == 0){
            System.out.println("Opção invalida!");
            return false;
        }
        return true;
    }
    
    public void Exit(){
        System.out.println("Sistema encerrado");
        System.exit(0);
    }
}
