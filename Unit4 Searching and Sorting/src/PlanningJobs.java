
public class PlanningJobs {

	public static final int HIGH = 2, LOW = 1, NONE = 0;
	
	public static void main(String[] args) {
		int numWeeks = 8;
		int[] low = genListLow(numWeeks);
		int[] high = genListHigh(numWeeks);
		
		print(low);
		print(high);
		System.out.print("Picks: ");
		print(jobSort(low, high));
	}

	/*
	 * @precondition lowStress and highStress are the same length
	 * @return int[] full of correct picks - 0=none, 1=low, 2=high
	 */
	public static int[] jobSort(int[] lowStress, int[] highStress) 
	{
		int[] pick = new int[lowStress.length];
		boolean highOp = true;
		for(int i = 0; i < pick.length; i++) 
		{
			if(i == 0);
			else if(pick[i-1] == 0) highOp = true;
			else highOp = false;
			pick[i] = genPick(i, lowStress, highStress, highOp);
		}
		return pick;
	}
	
	private static int genPick(int i, int[] lowStress, int[] highStress, boolean highOp) 
	{
		if(i == lowStress.length-1) 
		{
			if(highOp) return HIGH;
			else return LOW;
		}
		
		int LL = lowStress[i] + lowStress[i+1];
		int HL = highStress[i] + lowStress[i+1];
		int NH = 0 + highStress[i+1];
		if(HL > LL && highOp)
			return HIGH;
		if(NH > LL)
			return NONE;
		else
			return LOW;
	}
	
	public static int[] genListLow(int len) 
	{
		int[] list = new int[len];
		for(int i = 0; i < list.length; i++)
			list[i] = (int)(Math.random()*(len+1)+1);
		return list;
	} 
	
	public static int[] genListHigh(int len) 
	{
		int[] list = new int[len];
		for(int i = 0; i < list.length; i++)
			list[i] = (int)(Math.random()*(len+1)+len);
		return list;
	} 
	
	public static void print(int[] e) 
	{
		for(int i = 0; i < e.length; i++)
			System.out.print(e[i] + " ");
		System.out.println();
	}
}
