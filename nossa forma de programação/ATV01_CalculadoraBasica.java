import java.util.Scanner;

public class ATV01_CalculadoraBasica {
    public static void main(String[] args) {
        //Criar o objeto scanner para ler os dados do usuário
        Scanner objetoScanner = new Scanner(System.in);
        //crier variaveis para armazenar os valores lidos do ususario
        double valor1, valor2;
        //ler os valores do usuario, mas escrever na tela o que esta sendo lido
        System.out.print("Digite o primeiro valor: ");
        //out.print não precisou criar objeto para ele;
        valor1 = objetoScanner.nextDouble();
        //nextDOuble lê o valor em formato inteiro ou decimal
        System.out.print("Digite o segundo valor: ");
        valor2 = objetoScanner.nextDouble();

        //operacoes basicas com valores lidos do usuario
        System.out.println("Soma: " + (valor1 + valor2));
        System.out.println("Subtração: " + (valor1 - valor2));  
        System.out.println("Multiplicação: " + (valor1 * valor2));
        System.out.println("Divisão: " + (valor1 / valor2));
        System.out.println("Resto da Divisão: " + (valor1 % valor2));
    }
}