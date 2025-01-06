package FinancialBox;

public class FinancialBox {
	
	private double balance;
	
	
	public FinancialBox(int balance) {
		setBalance(balance);
	}
	
	public double getBalance() {
		return balance;
	}
	
	private void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(double value) {
		this.balance = this.balance + value;
	}
	
}
