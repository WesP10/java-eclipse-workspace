package Functions;

import java.util.ArrayList;

public class Equation {

	Function f, g;
	
	public Equation(Function f, Function g) 
	{
		this.f=f;
		this.g=g;
	}
	
	public ArrayList<Integer> solve()
	{
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for(int i = -100; i <= 100; i++) 
			if(f.getValue(i) == g.getValue(i))
				sol.add(i);
		return sol;
	}
}
