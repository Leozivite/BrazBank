package brazBank;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import entities.ContaEmpresarial;

import java.time.YearMonth;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
		String inf;
		ContaEmpresarial CE = new ContaEmpresarial();
		double emprestimo = 0;
		double Lemprestimo = 100000;
		int emp = 0;
		String cont = "";
		double dep = 0;
		double saq = 0;
		Conta conta = new Conta();
		do {
			System.out.println("sua conta e empresarial ou comum");
			cont = sc.nextLine().toUpperCase();
			if (cont.equals("EMPRESARIAL")) {
				emp = 1;
			}
			System.out.println("insira os dados da sua conta bancaria ");
			System.out.printf("   FORMATO= EX: JOAO DA SILVA ALMEIDA%nnome completo = ");
			String nome = sc.nextLine();
			System.out.printf("          FORMATO= XXXX XXXX XXXX XXXX%nnumero do cartao = ");
			String Nconta = sc.nextLine();
			System.out.printf("              FORMATO= XXX%nDigite o CVV do cartao ");
			int CVV = sc.nextInt();
			System.out
					.printf("                               FORMATO= MM/AA%ndigite a data de vensimento do cartao = ");
			sc.nextLine();
			String S = sc.nextLine();
			System.out.println();
			YearMonth V = YearMonth.parse(S, dtf);
			conta = new Conta(nome, Nconta, CVV, V, dep);
			System.out.println(conta);
			System.out.println();
			System.out.print("deseja modificar as informacao? ");
			System.out.println();
			inf = sc.nextLine().toUpperCase();
		} while (inf.equals("S") || inf.equals("SIM"));
		System.out.print("deseja enviar um saldo para sua conta ? ");
		String deposito = sc.nextLine().toUpperCase();
		if (deposito.equals("S") || deposito.equals("SIM")) {
			while (deposito.equals("S") || deposito.equals("SIM")) {
				System.out.print("Quanto voce deseja transferir para conta ? ");
				dep = sc.nextDouble();
				conta.deposito(dep);
				System.out.printf("Deposito realizado com sucesso%n%nDeseja fazer outro deposito ?");
				sc.nextLine();
				deposito = sc.nextLine().toUpperCase();
			}
		}
		System.out.printf("%nDeseja fazer uma transferencia ? ");
		deposito = sc.nextLine().toUpperCase();
		if (deposito.equals("S") || deposito.equals("SIM")) {
			System.out.println("Quanto voce deseja transferir ? ");
			saq = sc.nextDouble();
			conta.Saque(saq);
		}
		if (emp == 1) {
			System.out.println("Deseja fazer um emprestimo?");
			deposito = sc.nextLine().toUpperCase();
			if (deposito.equals("S") || deposito.equals("SIM")) {
				CE.setLemprestimo(Lemprestimo);
				System.out.print("Quanto voce deseja receber ? ");
				emprestimo = sc.nextDouble();
				CE.FazEmprestimo(emprestimo);
			}
		}
		System.out.println(conta);
		System.out.println("Operacao finalizada");

		sc.close();
	}

}
