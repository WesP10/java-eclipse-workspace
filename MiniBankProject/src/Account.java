
public class Account {

	private AccountHolder user;
	private int accountNum;
	private double balance;
	
	public Account(AccountHolder user, int num, double balance) 
	{
		this.user=user;
		accountNum=num;
		this.setBalance(balance);
	}
	
	public void deposit(double val) 
	{
		if(val < 0) return;
		setBalance(getBalance() + val);
	}
	
	public void withdraw(double val) 
	{
		if(val < 0) return;
		setBalance(getBalance() - val);
	}
	
	public void monthlyUpdate() 
	{
		System.out.println("Name: "+user.getName()+" Account Number: "+accountNum+" Balance: "+getBalance());
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public AccountHolder getUser() 
	{
		return user;
	}
}
