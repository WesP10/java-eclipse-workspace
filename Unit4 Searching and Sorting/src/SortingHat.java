
public class SortingHat {

	static double bubbleSwap, insertionSwap, selectionSwap, heapSwap, mergeSwap, quickSwap, treeSwap;
	static double bubbleComp, insertionComp, selectionComp, heapComp, mergeComp, quickComp, treeComp;
	
	static double[] totalInsertion, totalSelection;
	
	public static void main(String[] args) 
	{
		sideTest();
	}
		
	public static void sideTest() 
	{
		totalInsertion = new double[50];
		totalSelection = new double[50];
		System.out.println("n" + "\t" + "I Time" + "\t" + "S Time");
		for(int j = 0; j < 10; j++) 
		{
			for(int n = 1, i = 0; n <= 500; n+=10, i++) 
			{
				insertionSwap = insertionComp = selectionSwap = selectionComp = 0;
				int[] nums = genList(n);
				//n^2
				int[] copy = nums.clone(); //clone creates a shallow copy
				insertionSort(nums);
				//n^2
				nums = copy.clone();
				selectionSort(nums);

				double insertionTime = insertionSwap + insertionComp;
				double selectionTime = selectionSwap + selectionComp;
				totalInsertion[i] += insertionTime;
				totalSelection[i] += selectionTime;
			}
		}
		for(int i = 1; i < totalInsertion.length; i++) 
		{
			totalInsertion[i-1] /= 10;
			totalSelection[i-1] /= 10;
			System.out.println("" + i + "\t" + totalInsertion[i-1] + "\t" + totalSelection[i-1]);
		}
	}
	
	public static void mainTest() 
	{
		System.out.println("n" + "\t" + "B Time" + "\t" + "I Time" + "\t" + "S Time" + "\t" + "H Time" + "\t" + "M Time" + "\t" + "Q Time" + "\t" + "Tree Time");
		for(int n = 10000; n <= 100000; n+=10000) 
		{
			bubbleSwap= insertionSwap= selectionSwap= heapSwap= mergeSwap= quickSwap= treeSwap= bubbleComp= insertionComp= selectionComp= heapComp= mergeComp= quickComp= treeComp= 0;
			
			int[] nums = genList(n);
			//n^2
			int[] copy = nums.clone(); //clone creates a shallow copy
			insertionSort(nums);
			//n^2
			nums = copy.clone();
			bubbleSort(nums);
			//n^2
			nums = copy.clone();
			selectionSort(nums);
			//nlgn
			nums = copy.clone();
			heapSort(nums);
			//nlgn
			nums = copy.clone();
			mergeSort(nums);
			//nlgn
			nums = copy.clone();
			quickSort(nums);
			//nlgn
			nums = copy.clone();
			treeSort(nums);
			
			double bubbleTime = bubbleSwap + bubbleComp;
			double insertionTime = insertionSwap + insertionComp;
			double selectionTime = selectionSwap + selectionComp;
			double heapTime = heapSwap + heapComp;
			double mergeTime = mergeSwap + mergeComp;
			double quickTime = quickSwap + quickComp;
			double treeTime = treeSwap + treeComp;
			System.out.println("" + n + "\t" + bubbleTime + "\t" + insertionTime + "\t" + selectionTime + "\t" + heapTime + "\t" + mergeTime + "\t" + quickTime + "\t" + treeTime);
		}

	}

	public static int[] genList(int len) 
	{
		int[] list = new int[len];
		for(int i = 0; i < list.length; i++)
			list[i] = (int)(Math.random()*(2*len+1)-len);
		return list;
	} 
	
	public static boolean isSorted(int[] arr) 
	{
		for(int i = 0; i < arr.length-1; i++) 
		{
			if(i > i+1)
				return false;
		}
		return true;
	}
	
	public static void print(int[] e) 
	{
		for(int i = 0; i < e.length; i++)
			System.out.print(e[i] + " ");
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j) 
	{
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void treeSort(int[] arr) 
	{
		BinarySearchTree bst = new BinarySearchTree(new Node(arr[0], null, null, null));
		for(int i = 1; i < arr.length; i++) 
			bst.insert(arr[i]);
		int[] temp = bst.inOrderTraversal();
		for(int i = 0; i < temp.length; i++)
			arr[i] = temp[i];
		treeComp = bst.getComp();
	}
	
	public static void heapSort(int[] arr) 
	{
		int last = arr.length-1;
		heapify(arr, last);
		for(int i = 0; i < arr.length; i++) 
		{
			swap(arr, 0, last);
			last--;
			heapify(arr, 0, last);
		}
	}
	
	private static void heapify(int[]  arr, int last) 
	{
		for(int i = (last-1)/2; i >= 0; i--) 
			heapify(arr, i, last);
	}
	
	private static void heapify(int[] arr, int i, int last) 
	{
		int right = (i+1)*2;
		int left = 2*i+1;
		
		int maxIndx = i;
		heapComp+=2;
		if(right <= last && arr[right] > arr[maxIndx])
			maxIndx = right;
		if(left <= last && arr[left] > arr[maxIndx])
			maxIndx = left;
		
		if(i != maxIndx) 
		{
			heapSwap++;
			swap(arr, i, maxIndx);
			heapify(arr, maxIndx, last);
		}
	}
	
	public static void mergeSort(int[] arr) 
	{
		sort(arr, 0, arr.length-1);
	}
	
	private static void sort(int arr[], int l, int r)
    {
		mergeComp++;
        if (l < r) {
            int m =l+ (r-l)/2;
  
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            merge(arr, l, m, r);
        }
    }
	
	private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
  
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) 
        {
        	mergeComp++;
            if (L[i] <= R[j]) {
            	mergeSwap++;
                arr[k] = L[i];
                i++;
            }
            else {
            	mergeSwap++;
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        mergeComp++;
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
      }
	
	public static void quickSort(int[] arr) 
	{
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void quickSort(int[] arr, int low, int high) 
	{
		int numE = high-low+1;
		quickComp+=2;
		if(numE <= 1) return;
		if(high-low == 2) 
			if(arr[low] > arr[high]) { swap(arr, low, high); return; }
		int partionIndx = partion(arr, low, high);
			quickSort(arr, low, partionIndx-1);
			quickSort(arr, partionIndx+1, high);
	}
	
	private static int partion(int[] arr, int low, int high) 
	{
		int i = low, j = high, p = high;
		while(i != j) 
		{
			quickComp+=2;
			while(arr[i] < arr[p] && i != j) 
				i++;
			while(arr[j] >= arr[p] && i != j)
				j--;
			quickSwap++;
			swap(arr, i, j);			
		}
		quickSwap++;
		swap(arr, i, p);
		return i;
	}
	
	public static void bubbleSort(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) {
			boolean swap = false;
			for(int j = 0; j < arr.length-1; j++) 
			{
				bubbleComp++;
				if(arr[j+1] < arr[j]) 
				{
					swap(arr, j+1, j);
					bubbleSwap++;
					swap = true;
				}
			}	
			if(!swap) return;
		}
	}
	
	public static void selectionSort(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			int min = arr[i];
			int minIndx = i;
			for(int j = i+1; j < arr.length; j++) 
			{
				selectionComp++;
				if(arr[j] < min) {
					min = arr[j];
					minIndx = j;
				}
			}
			swap(arr, i, minIndx);
			selectionSwap++;
		}
	}

	public static void insertionSort(int[] arr) 
	{
		for(int i = 1; i < arr.length; i++) 
			for(int j = i; j > 0; j--) 
			{
				insertionComp++;
				if(arr[j] < arr[j-1])
				{
					swap(arr, j, j-1);
					insertionSwap++;
				}
				else break;
			}
	}
}

