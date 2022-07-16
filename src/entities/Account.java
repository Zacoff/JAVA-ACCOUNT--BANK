package entities;

public class Account {
	private int accountNumber;
	private String name;
	private double accountBalance = 0;
	private double rateDeposit = 5;

	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public Account(int accountNumber, String name, double accountBalance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void deposit(double deposit) {
		this.accountBalance += deposit;
	}

	public boolean withdrawal(double withdrawal) {
		if ((this.accountBalance - (withdrawal + rateDeposit)) < 0) {
			System.out.printf("Saque máximo disponível: %.2f %n", (this.accountBalance) - rateDeposit);
			return true;
		} else {
			this.accountBalance -= (withdrawal + rateDeposit);
			return false;
		}
	}

	public String toString() {
		return String.format("Numero da conta: %d %n", this.accountNumber) + String.format("Nome: %s %n", this.name)
				+ String.format("Total conta: %.2f", this.accountBalance);
	}
}
