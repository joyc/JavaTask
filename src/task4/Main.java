package task4;

public class Main {
	public static void main(String[] args) {
		
		Account account = new Account(100);
		
		Thread thread = new Thread(new Deposit(account));
		Thread thread2 = new Thread(new Withdraw(account));
		
		thread.start();
		thread2.start();
		
	}
}
