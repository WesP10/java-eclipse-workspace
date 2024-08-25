import java.util.ArrayList;

public class BankMain {
	
	public static void main(String[] args) {
		ArrayList<Account> users = new ArrayList<Account>();
		users.add(new SavingsAccount(new AccountHolder("Fred", "123 Fairy Drive", 73846), 0, 100, 4));
		users.add(new SavingsAccount(new AccountHolder("Tim", "Ur mom's house", 39864), 0, 10, 10));
		users.add(new CheckingAccount(new AccountHolder("John", "69 FunnyNumber Avenue", 94782), 0, 20030));
		users.add(new CheckingAccount(new AccountHolder("Sam", "480 Schoolhouse Lane", 82095), 0, 902));
		monthlyUpdate(users); //Account after sign-ups
		users.get(0).deposit(100);//Test SavingsAccount deposit
		users.get(1).withdraw(8);//Test SavingsAccount withdraw
		users.get(2).deposit(20);//Test CheckingAccount deposit
		users.get(3).withdraw(903);//Test CheckingAccount withdraw and overdraft
		monthlyUpdate(users);
		users.get(3).withdraw(98);
		monthlyUpdate(users);
		users.get(3).withdraw(20);
		monthlyUpdate(users);
	}

	public static void monthlyUpdate(ArrayList<Account> users) 
	{
		for(int i = 0; i < users.size(); i++) 
			users.get(i).monthlyUpdate();
		System.out.println();
	}
	
}
