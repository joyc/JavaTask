package task4;

public class Main {
	public static void main(String[] args) {
		
		Account account = new Account(100);	// 设置帐户初始额为100元
		
		Thread thread = new Thread(new Deposit(account));
		Thread thread2 = new Thread(new Withdraw(account));
		
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
		
	}
}
