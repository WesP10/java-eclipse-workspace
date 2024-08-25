
public class CheckingAccount extends Account{

	private double overDraftLimit;
	
	public CheckingAccount(AccountHolder user, int num, double balance) {
		super(user, num, balance);
		overDraftLimit = 100;
	}

	@Override
	public void withdraw(double Val) 
	{
		if(Val < 0) return;
		if(getBalance() - Val < 0 && overDraftLimit > 0) 
		{
			setBalance(getBalance() - Val);
			overDraftLimit+=getBalance();
			System.out.println("overD val: "+overDraftLimit);
			return;
		}
		else if(getBalance() - Val < 0) {return;}
		super.withdraw(Val);
	}
	
	@Override
	public void monthlyUpdate() 
	{
		if(overDraftLimit >= 100) 
		{
			System.out.print(getUser().getName()+ "'s account is not overdrawn ");
			super.monthlyUpdate();
			return;
		}
		setBalance(getBalance()-10);
		System.out.print(getUser().getName()+ "'s Account is overdrawn and a fee has been applied to the account ");
		super.monthlyUpdate();
	}
}
