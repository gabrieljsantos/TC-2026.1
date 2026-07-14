import java.util.Scanner;
class Carro {
    // Esses aqui são os atributos do carro moDelo marca ano e até a cor
    String modelo;
    String marca;
    String cor;
    int ano;

    // construtor
    public Carro(
        String modelo,
        String marca,
        String cor,
        int ano)
        {
            this.modelo = modelo.toLowerCase();
            this.marca = marca.toUpperCase();
            this.cor = cor.toLowerCase();
            this.ano = ano;
        }
    
    //alguns metodos

    public void exibirDetalhes(){
        System.out.println("O Carro modelo " + modelo + ", marca " + marca + ", na cor " + cor + " e do ano " + ano);
    }

    public void setModelo(String modelo){
        this.modelo =  modelo.toLowerCase();
    }

    public void setMarca(String marca){
        this.marca =  marca.toUpperCase();
    }

    public void setCor(String modelo){
        this.cor =  cor.toLowerCase();
    }

    public void setAno(int ano){
        this.ano =  ano;
    }

    public String getModelo(){
        return this.modelo;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getCor(){
        return this.cor;
    }
    public int getAno(){
        return this.ano;
    }

}
public class ATV03_ManipulacaoStringsEmClasses{
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String modelo;
        String marca;
        String cor;
        int ano;
        
        System.out.println("1 modelo : ");
        modelo = scanner.nextLine();
        System.out.println("1 Marca : ");
        marca = scanner.nextLine();
        System.out.println("1 Cor : ");
        cor =  scanner.nextLine();
        System.out.println("1 Ano : ");
        ano =  scanner.nextInt();
        scanner.nextLine(); // para resolver ln do digitar enter do ano
        Carro carro1 = new Carro(modelo,marca,cor,ano);
        System.out.println("2 modelo : ");
        modelo = scanner.nextLine();
        System.out.println("2 Marca : ");
        marca = scanner.nextLine();
        System.out.println("2 Cor : ");
        cor =  scanner.nextLine();
        System.out.println("2 Ano : ");
        ano =  scanner.nextInt();

        Carro carro2 = new Carro(modelo,marca,cor,ano);

        Carro carro3 = new Carro(carro1.getModelo(),carro1.getMarca(),carro2.getCor(),carro2.getAno());

        carro1.exibirDetalhes();
        carro2.exibirDetalhes();
        carro3.exibirDetalhes();




    }
        


}
