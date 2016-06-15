package task4;

class Account {
	
	public static void main(String[] args) {
		Operation op = new Operation();
		op.setBalance(100);	// 帐户初始金额为100元
		
		for (int i = 1; i < 1000; i++) {	// 执行1000次存取操作
			new Thread(op).start();
		}
        op.getBalance();
	}

}
