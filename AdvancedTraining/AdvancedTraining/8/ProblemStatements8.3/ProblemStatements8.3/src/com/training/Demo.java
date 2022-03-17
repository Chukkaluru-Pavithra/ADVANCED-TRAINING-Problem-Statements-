package com.training;

class ThreadA extends Thread{
    public void run( ) {
       for(int i = 1; i <= 5; i++) {
          System.out.println("From Thread A with i = "+ -1*i);
       }
       System.out.println("Exiting from Thread A ...");
    }
}

class ThreadB extends Thread {
   public void run( ) {
      for(int j = 1; j <= 5; j++) {
        System.out.println("From Thread B with j= "+2* j);
      }
      System.out.println("Exiting from Thread B ...");  
	}
}

public class Demo {
   public static void main(String args[]) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
      
        a.start();
        b.start();
        System.out.println("... Multithreading is over ");
   }
}

class Account {
	public int balance;
	public int accountNo;
	void displayBalance() {
		System.out.println("Account No:" + accountNo + "Balance: " + balance);
	}

	   synchronized void deposit(int amount){
			balance = balance + amount;
			System.out.println( amount + " is deposited");
			displayBalance();
	   }

	   synchronized void withdraw(int amount){
			  balance = balance - amount;
			  System.out.println( amount + " is withdrawn");
			  displayBalance();
	   }
}

class TransactionDeposit implements Runnable{
	int amount;
	Account accountX;
	TransactionDeposit(Account x, int amount){
		accountX = x;
		this.amount = amount;
		new Thread(this).start();
	}
	
	public void run(){
		accountX.deposit(amount);
	}
}

class TransactionWithdraw implements Runnable{
	int amount;
	Account accountY;
	
	TransactionWithdraw(Account y, int amount) {
		accountY = y;
		this.amount = amount;
		new Thread(this).start();
	}
	
	public void run(){
		accountY.withdraw(amount);
	}
}

class Demo1{
	public static void main(String args[]) {
		Account ABC = new Account();
		ABC.balance = 1000;
		ABC.accountNo = 111;
		TransactionDeposit t1;
		TransactionWithdraw t2;
		t1 = new TransactionDeposit(ABC, 500);
		t2 = new TransactionWithdraw(ABC,900);
	}
}

