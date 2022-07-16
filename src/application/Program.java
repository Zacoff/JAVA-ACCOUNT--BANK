package application;

import java.util.Scanner;

import entities.Account;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static String type = "";
	private static Account newAccount;
	private static String changeAccount = "";

	public static void main(String[] args) {
		createNewAccount();
		do {
			System.out.println("Deseja fazer um deposito ou saque?");
			changeAccount = sc.next();
		}while(!(changeAccount.equalsIgnoreCase("sim") || changeAccount.equalsIgnoreCase("não")));

		if (changeAccount.equalsIgnoreCase("não")) System.exit(0);
		
		withdrawalOrDeposit();
		System.out.printf("Informações Atualizadas: %n%s%n", newAccount);
		
		sc.close();
	}

	public static void createNewAccount() {
		String name;
		double initialDeposit;
		int accountNumber;

		System.out.println("Cadastre sua conta:");
		System.out.print("Numero conta: ");
		accountNumber = sc.nextInt();
		System.out.print("Nome proprietário conta: ");
		name = sc.next();

		do {
			System.out.print("Coloque o deposito inicial: ");
			initialDeposit = sc.nextDouble();
		} while (initialDeposit < 0);

		newAccount = new Account(accountNumber, name, initialDeposit);
		System.out.printf("NOVA CONTA CRIADA: %n%s%n", newAccount);
	}

	public static void withdrawalOrDeposit() {
		boolean withdrawal = false;
		double value = 0;
		do {
			System.out.println("Qual tipo? (Saque ou Deposito)");
			type = sc.next();
		} while (!(type.equalsIgnoreCase("saque") || type.equalsIgnoreCase("deposito")));

		type = type.toLowerCase();
		switch (type) {
		case "saque":
			do {
				System.out.println("Valor:");
				value = sc.nextDouble();
				withdrawal = newAccount.withdrawal(value);
			} while (withdrawal);
			break;
		case "deposito":
			System.out.println("Valor:");
			value = sc.nextDouble();
			newAccount.deposit(value);
			break;
		}
	}
}
