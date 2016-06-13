package task4;

class Operation {
	int balance = 100;	// 帐户初始金额为100元
	int money = 1;
	public int deposit(int money){
		while (money >= 1) {
			this.balance += money;
		}
		return balance;
	}

	public int withdrawal(int money) {
		while (money >= 1) {
			this.balance -= money;
		}
		return balance;
	}

}