import java.util.*;
import java.io.*;

public class PompousPeacocks {
    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for (int i = 0; i < tests; i++) {
            List<List<Integer>> peacockStats = new ArrayList<>();
            int pos = 0;
            while (true) {
                String peacockStatsLine = br.readLine();
                if (peacockStatsLine == null || peacockStatsLine.equals(""))
                    break;
                peacockStats.add(new ArrayList<Integer>());

                String[] peacockStat = peacockStatsLine.split(" ");
                peacockStats.get(pos).add(Integer.parseInt(peacockStat[0]));
                peacockStats.get(pos).add(Integer.parseInt(peacockStat[1]));
                pos++;
            }

            int[][] peacocks = new int[peacockStats.size()][peacockStats.get(0).size()];

            for (int k = 0; k < peacockStats.size(); k++) {
                for (int j = 0; j < peacockStats.get(0).size(); j++) {
                    peacocks[k][j] = peacockStats.get(k).get(j);
                }
            }

            System.out.println(unbeatable(peacocks));
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new PompousPeacocks().run();
    }
    // Do not modify above this line

    public int unbeatable(int[][] peacocks) {
        int unbeatable = 0;
        
        int[] vList = getVlist(peacocks);
        boolean beast = true;
        for(int i = 0; i < peacocks.length; i++) 
        	if(peacocks[vList[i]][1] < peacocks[i][1]) beast = false;
    }

    public int[] getVlist(int[][] peacocks) 
    {
    	ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < peacocks.length; i++) 
    	{
    		p.add(new ArrayList<Integer>());
    		for(int j = 0; j < peacocks[i].length; j++) 
    			p.get(i).add(peacocks[i][j]);
    	}
    			
    }
    
    public int maxVindx(int[][] peacocks) 
    {
    	int maxV = 0;
        for(int i = 0; i < peacocks.length-1; i++) 
        		if(peacocks[i+1][0] > peacocks[i][0])
        			maxV = i+1;  
        return maxV;
    }
}