import java.util.Random;

public class Sorter
{
	public static void main(String[] args)
	{
		int n = 100000;
		int[] nums1 = randomArray(n);
		int[] nums2 = randomArray(n);
		int[] nums3 = randomArray(n);
      int[] nums4 = randomArray(n);
		long start;
      long stop;
      /*
		start = System.currentTimeMillis();
		selectionSort(nums1);
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + " ms (Selection Sort)");
		
		start = System.currentTimeMillis();
		insertionSort(nums2);
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + " ms (Insertion Sort)");
		*/
      start = System.currentTimeMillis();
		mergeSort(nums3);
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + " ms (Merge Sort)");
      
		start = System.currentTimeMillis();
		mergeSortMine(nums4);
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + " ms (Alternate Merge Sort)");
		
		
		
		
	}
	
	public static int[] randomArray(int len)		// constructs int[] of length len and populates with random numbers in range [0, len)
	{
		int[] rtn = new int[len];
		Random randy = new Random();
		for(int i = 0; i < len; i++)
			rtn[i] = randy.nextInt(len);
		return rtn;
	}
		
	public static void selectionSort(int[] elements)
	{
		for(int i = 0; i < elements.length - 1; i++)
		{
			int mindex = i;		// index of min
			for(int k = i + 1; k < elements.length; k++)
				if(elements[k] < elements[mindex])
					mindex = k;
					
			int temp = elements[i];
			elements[i] = elements[mindex];
			elements[mindex] = temp;
		}
	}
	
	public static void insertionSort(int[] elements)
	{
		for(int i = 1; i < elements.length; i++)
		{
			int temp = elements[i];
			int k = i;
			while(k > 0 && temp < elements[k - 1])
			{
				elements[k] = elements[k - 1];
				k--;
			}
		
			elements[k] = temp;
		}
	}
	
	public static void mergeSort(int[] elements)
	{
		mergeSort(elements, 0, elements.length - 1);
	}
	
	public static void mergeSort(int[] elements, int from, int to)
	{
		if(from == to)
			return;
		int mid = (from + to) / 2;
		mergeSort(elements, from, mid);
		mergeSort(elements, mid + 1, to);
		merge(elements, from, mid, to);
	}
	
	public static void mergeSortMine(int[] elements)
	{
		for(int len = 2; len <= elements.length; len *= 2)
		{
			for(int j = len - 1, i = 0; j < elements.length; j += len, i += len)
				merge(elements, i, (i + j) / 2, j);
         int i = elements.length - (elements.length % len) - len;
         int j = elements.length - 1;
         merge(elements, i, i + len - 1, j);
		}
		
	}
	
	public static void merge(int[] elements, int from, int mid, int to)
	{
		int[] temp = new int[elements.length];
		int i = from, j = mid + 1, k = from;
		while(i <= mid && j <= to)
		{
			if(elements[i] < elements[j])
			{
				temp[k] = elements[i];
				i++;
			}
			else
			{
				temp[k] = elements[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid)
		{
			temp[k] = elements[i];
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp[k] = elements[j];
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
			elements[k] = temp[k];
	}
}