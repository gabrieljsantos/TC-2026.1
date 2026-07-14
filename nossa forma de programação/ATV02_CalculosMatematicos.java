import java.util.Scanner;

public class ATV02_CalculosMatematicos {
    public static void main(String[] args) {
        // veja só eu estou fazendo uma avaliação do exercício para conseguir é adiantar alguns alguns processos e alguns conceitos então eu alterei não é o objetivo do do exercício para fazer um sistema em que eu entro com as distância com os tempos e atribui é uma certa premiação para para quem atingir uma velocidade específica e coloca o preço por metro por segundo é como se fosse um campeonato mas isso aí vai servir para para agilizar aqui o processo aprendizado que eu quero pular algumas etapas .
        // Então quer dizer que você pode É refaturar os exercícios Considerando que eu já sei fazer esse tipo de coisa sabe adiantar alguns conceitos perdi acelerado
        // Não tem mistério aqui é só um Monte de a primeiro criei Oo objeto scanner está certo ? Já botei o nome padrão aqui porque no outro Eu coloquei objetos que não é para exemplificar mas agora eu deixei scanner para ficar mais simples É a que consiste Basicamente em declaração de funções faz a leitura Aí depois eu vou começar a fazer as operações
        Scanner scanner = new Scanner(System.in);
        double distancia1, distancia2, distancia3;
        double tempo1, tempo2, tempo3;
        double min_premiacao;
        double valor_por_m_s;
        double media_vm;
        System.out.print("Digite as distancias em metros:\n");
        System.out.print("1:");
        distancia1 = scanner.nextDouble();
        System.out.print("2:");
        distancia2 = scanner.nextDouble();
        System.out.print("3:");
        distancia3 = scanner.nextDouble();
        System.out.print("Digite os tempos em segundos:\n");
        System.out.print("1:");
        tempo1 = scanner.nextDouble();
        System.out.print("2:");
        tempo2 = scanner.nextDouble();
        System.out.print("3:");
        tempo3 = scanner.nextDouble();
        System.out.print("Digite o valor minimo de m/s que tenha premiação :\n");
        min_premiacao = scanner.nextDouble();
        System.out.print("Digite o valor de cada metro por segundo para premiação em R$ :\n");
        valor_por_m_s = scanner.nextDouble();

        media_vm = (distancia1+distancia2+distancia3)/(tempo1+tempo2+tempo3);

        System.out.println("A velocidade media foi : " + media_vm + "m/s");
        if (media_vm > min_premiacao){
            System.out.println("que é maior que o requisitio minimo, em " + (media_vm - min_premiacao));
            System.out.printf("Dessa forma, recebe : R$ %.2f%n" , (valor_por_m_s * media_vm));
        } else { 
            System.out.println("que é menor que o requisitio minimo, em " + (min_premiacao - media_vm));
            System.out.println("Dessa forma, recebe nada");
        }
    }
}