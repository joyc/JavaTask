package task4;

public class Deposit implements Runnable {

	private Account account;

	public Deposit(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			account.deposit();
		}

	}

}
