
public class PessoaJuridica extends Pessoa{
	private String cnpj;
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String nome, String endereco, 
			double rendaBruta, String cnpj) {
		super(nome, endereco, rendaBruta);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return super.toString() +"Cnpj:" + cnpj + "\n";
	}

	@Override
	public double calculaImposto() {
		return getRendaBruta()*0.1;
	}
	
	
}
