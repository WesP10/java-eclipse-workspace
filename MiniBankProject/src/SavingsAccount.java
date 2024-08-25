
public class SavingsAccount extends Account{

	private double interest;
	
	public SavingsAccount(AccountHolder user, int num, double balance, double interest) {
		super(user, num, balance);
		this.interest=interest;
	}

	@Override
	public void monthlyUpdate() 
	{
		setBalance(getBalance() * (1+interest/100));
		super.monthlyUpdate();
	}
	
}
