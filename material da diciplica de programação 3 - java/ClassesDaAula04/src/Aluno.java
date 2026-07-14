
public class Aluno extends Pessoa{
	private int matricula;
	private int anoIngresso;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, String cpf, int matricula,
					int anoIngresso) {
		super(nome, cpf);
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	
	public String dadosAluno() {
		return super.dadosPessoa()+
				no 
				"Matricula: " + matricula + "\n" +
				"Ano ingresso: " + anoIngresso + "\n";
	}
}
