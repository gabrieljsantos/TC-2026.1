import java.util.ArrayList;

public class Universidade {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public Universidade() {
		
	}
	
	public Universidade(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void adicionarAluno(Aluno a) {
		alunos.add(a);
	}
	
	public double valorMensalidade(Aluno a, int dia) {
		return a.pagar(dia);
	}
	
	public double receitaUniversidade(int dia) {
		double total = 0;
		for(int i = 0; i < alunos.size(); i++) {
			total += alunos.get(i).pagar(dia);
		}
		return total;
	}
	
	public int qntBolsistas() {
		int qnt = 0;
		for(int i = 0; i < alunos.size();i++) {
			if(alunos.get(i) instanceof AlunoBolsista) {
				qnt++;
			}
		}
		return qnt;
	}
	
	
	
	
	
	
	
	
	
	
	
}
