public class ArrayHelper
{
	public static void display(int[] nums)		// prints int array horizontally
	{
		System.out.print("[");
		for(int i = 0; i < nums.length - 1; i++)
			System.out.print(nums[i] + ", ");
      if(nums.length == 0)
         System.out.println("]");
		else
          System.out.println(nums[nums.length - 1] + "]");
	}
   
   public static void display(double[] nums)		// prints double array horizontally
	{
		System.out.print("[");
		for(int i = 0; i < nums.length - 1; i++)
			System.out.print(nums[i] + ", ");
		System.out.println(nums[nums.length - 1] + "]");
	}
	
	public static void fill(int[] nums, int x)		// replaces every int element in nums with x
	{
		for(int i = 0; i < nums.length; i++)
			nums[i] = x;
	}
   
   public static void fill(double[] nums, double x)		// replaces every double element in nums with x
	{
		for(int i = 0; i < nums.length; i++)
			nums[i] = x;
	}
	
	public static boolean contains(int[] nums, int x)		// returns true if x can be found in int[] nums, false otherwise
	{
		for(int i = 0; i < nums.length; i++)
			if(nums[i] == x)
				return true;
		return false;
	}
   
   public static boolean contains(double[] nums, double x)		// returns true if x can be found in double[] nums, false otherwise
	{
		for(int i = 0; i < nums.length; i++)
			if(nums[i] == x)
				return true;
		return false;
	}
	
	public static int count(int[] nums, int x)		// returns number of times int x occurs in nums
	{
		int count = 0;
		for(int i  = 0; i < nums.length; i++)
			if(nums[i] == x)
				count++;
		return count; 
	}
   
   public static double count(double[] nums, double x)		// returns number of times double x occurs in nums
	{
		int count = 0;
		for(int i  = 0; i < nums.length; i++)
			if(nums[i] == x)
				count++;
		return count;
	}
	
	public static int sum(int[] nums)      // returns the sum of the int array elements
	{
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		return sum;
	}
   
   public static double sum(double[] nums)		// overload sum method for doubles
	{
		double sum = 0;
		for(double e : nums)		// for each loop iterates through each double in nums (elements called e) and does the body's contents with each
			sum += e;
		return sum;
	}
	
	public static int indexOf(int[] nums, int x)		// returns first index of x in int[] nums, -1 if none
	{
		for(int i = 1; i < nums.length; i++)
			if(nums[i] == x)
				return i;
		return -1;
	}
   
   public static int indexOf(double[] nums, double x)		// returns first index of x in double[] nums, -1 if none
	{
		for(int i = 1; i < nums.length; i++)
			if(nums[i] == x)
				return i;
		return -1;
	}
	
	public static int max(int[] nums)		// returns largest interger in int array
	{
		int max = nums[0];
		for(int i = 0; i < nums.length; i++)
			if(nums[i] > max)
				max = nums[i];
		return max;
	}
   
   public static double max(double[] nums)		// overloads max method for doubles
	{
		double max = nums[0];
		for(double e : nums)		// for-each loop
			max = Math.max(max, e);
		return max;
	}
   
   public static int min(int[] nums)		// returns smallest interger in int array
	{
		int min = nums[0];
		for(int i = 0; i < nums.length; i++)
			if(nums[i] < min)
				min = nums[i];
		return min;
	}

   public static double min(double[] nums)		// overloads min method for doubles
	{
		double min = nums[0];
		for(double e : nums)		// for-each loop
			min = Math.min(min, e);
		return min;
	}
		
	public static int[] subarray(int[] nums, int beg, int end)		// returns int array from [start, stop)
	{
		int[] rtn = new int[end - beg];
		for(int i = 0; i < rtn.length; i++)
			rtn[i] = nums[beg + i];
		return rtn;
	}
   
   public static double[] subarray(double[] nums, int beg, int end)		// returns double array from [start, stop)
	{
		double[] rtn = new double[end - beg];
		for(int i = 0; i < rtn.length; i++)
			rtn[i] = nums[beg + i];
		return rtn;
	}
	
	public static int[] merge(int[] nums1, int[] nums2)      // returns combined int array from two arrays
	{
		int[] rtn = new int[nums1.length + nums2.length];
		for(int i = 0; i < nums1.length; i++)
			rtn[i] = nums1[i];
		for(int i = 0; i < nums2.length; i++)
			rtn[i + nums1.length] = nums2[i];
		return rtn;
	}
   
   public static double[] merge(double[] nums1, double[] nums2)      // returns combined double array from two arrays
	{
		double[] rtn = new double[nums1.length + nums2.length];
		for(int i = 0; i < nums1.length; i++)
			rtn[i] = nums1[i];
		for(int i = 0; i < nums2.length; i++)
			rtn[i + nums1.length] = nums2[i];
		return rtn;
	}
   
   public static int[] onlyEvens(int[] nums)    // returns int[] of only even integers
    {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] % 2 == 0)
                count++;
        int[] rtn = new int[count];
        count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] % 2 == 0)
            {
                rtn[count] = nums[i];
                count++;
            }
        return rtn;
    }
    
    public static int[] onlyPositives(int[] nums)     // returns int[] of only positive entries
    {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= 0)
                count++;
        int[] rtn = new int[count];
        count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= 0)
            {
                rtn[count] = nums[i];
                count++;
            }
        return rtn;
    }
    
    public static double[] onlyPositives(double[] nums)     // returns double[] of only positive entries
    {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= 0)
                count++;
        double[] rtn = new double[count];
        count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= 0)
            {
                rtn[count] = nums[i];
                count++;
            }
        return rtn;
    }
    
    public static int[] disjoint(int[] nums1, int[] nums2)     // returns int[] made of elements of each input int[] that are not present in the other
    {
        int count1 = 0;
        int count2 = 0;
        for(int e : nums1)
            if(!contains(nums2, e))
                count1++;
        for(int e : nums2)
            if(!contains(nums1, e))
                count2++;
                
        int[] rtn = new int[count1 + count2];
        int count3 = 0;
        for(int i = 0; i < nums1.length; i++)
            if(!contains(nums2, nums1[i]))
            {
                rtn[count3] = nums1[i];
                count3++;
                
            }
        for(int i = 0; i < nums2.length; i++)
            if(!contains(nums1, nums2[i]))
            {
                rtn[count3] = nums2[i];
                count3++;
            }
                
        return rtn;
    }
}