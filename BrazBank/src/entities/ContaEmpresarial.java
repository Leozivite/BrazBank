package entities;  

public class ContaEmpresarial extends Conta{
 
	private double Lemprestimo;
	
	public ContaEmpresarial() {
		
	}
	public void setLemprestimo(double Lemprestimo) {
		this.Lemprestimo=Lemprestimo;
	}
	public void FazEmprestimo(double emprestimo) {
		if (emprestimo>=Lemprestimo) 
		{
			dep+=emprestimo;
					}
	}
}
