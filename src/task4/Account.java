package task4;

class Account {
	
	private int balance;

	public Account(int i) {
		this.balance = i;
	}

	public synchronized void deposit() {
		int money = 1; //设置存款初始额度为1元
		if (money >= 1) {
			balance += money;
		} else {
			System.out.println("存入金额需为1的整数倍。");
		}
		System.out.printf("\n向账户存了%d元，新余额为%d元。",money,balance);
	}

	public synchronized void witdraw() {
		int money = 1;	//设置取款初始额度为1元
		if (money >= 1 && money < balance) {
			balance -= money;
		} else {
			System.out.println("余额不足或输入不正确！");
		}
		System.out.printf("\n从账户取了%d元，账户还有%d元。", money,balance);
	}

}
