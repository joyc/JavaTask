package task4;

class Operation implements Runnable{

	private int balance;
    int money = 1;	// 单次存取额度为1元
	public void deposit(int money){
		if (money >= 1) {
			balance += money;
		} else {
			System.out.println("存入金额需为1的整数倍。");
		}
		System.out.printf("\n向账户存了%d元，新余额为%d元。",money,balance);
	}

	public void withdrawal(int money) {
		if (money >= 1 && money < balance) {
			balance -= money;
		} else {
			System.out.println("余额不足或输入不正确！");
		}
		System.out.printf("\n从账户取了%d元，账户还有%d元。", money,balance);
	}

	public void getBalance() {
		System.out.printf("\n账户最新余额为：%d元。",balance);
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public void run() {
		// 同步代码块同步线程执行存取方法
		synchronized (this) {
			deposit(money);
			withdrawal(money);
		}
	}

}