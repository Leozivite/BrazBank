package entities;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Conta {
private String nome;
private String Nconta;
private int CVV;
private YearMonth v;
private double dep;
DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/yy");


public Conta() {
	super();
}
public Conta(String nome, String Nconta, int CVV, YearMonth V,double dep) {
	this.nome = nome;
	this.Nconta = Nconta;
	this.CVV = CVV;
	v = V;
	this.dep=dep;
}
public double setDep() {
	return dep;
}
public void deposito (double dep) {
	this.dep+=dep;
}
public void Saque(double saque) {
	dep-=saque;
}
@Override
public String toString() {
	return String.format("Informacoes da Conta %nNome = ") + nome + String.format("%nNumero da conta = ") + Nconta + String.format("%nCVV = ") + CVV + String.format("%nData de validade do cartao = ") + v.format(dtf) + String.format("%nValor disponivel na conta = "+dep);
}

}
