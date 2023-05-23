package brazBank;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

import java.time.YearMonth;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yy");
		String inf;
		double dep = 0;
		double saq = 0;
		Conta conta = new Conta();
		do {
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
			YearMonth V = YearMonth.parse(S, dtf);
			 conta = new Conta(nome, Nconta, CVV, V, dep);
			System.out.println(conta);
			System.out.print("deseja modificar as informacao? ");
			inf = sc.nextLine().toUpperCase();
		} while (inf.equals("S") || inf.equals("SIM"));
		System.out.print("Deseja fazer um deposito? ");
		String deposito = sc.nextLine().toUpperCase();
		if (deposito.equals("S") || deposito.equals("SIM")) {
			while (deposito.equals("S") || deposito.equals("SIM")) {
				System.out.print("Quanto voce deseja depositar ? ");
				dep = sc.nextDouble();
				System.out.printf("Deposito realizado com sucesso%nDeseja fazer outro deposito?");
				deposito = sc.nextLine().toUpperCase();
			}
		}
		System.out.println("Deseja fazer um saque? ");
		deposito = sc.nextLine().toUpperCase();
		if (deposito.equals("S") || deposito.equals("SIM")) {
			System.out.println("Quanto voce deseja sacar ? ");
			saq=sc.nextDouble();
			conta.Saque(saq);
		}
		
		else  {
			System.out.println(conta);
			System.out.println("Operacao finalizada");
			
		}

		sc.close();
	}

}