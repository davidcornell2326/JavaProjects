import java.util.Scanner;

public class CubeMath
{
	public static void main(String[] args)
	{
		
		Scanner input =  new Scanner(System.in);
		
		System.out.println("Welcome to CubeMath! You will start with a random number and a goal number.");
		System.out.println("Around your starting number are the four basic mathematical operations with random numbers.");
		System.out.println("Use the directional awsd characters to choose a direction, and that operation will be applied to the center number (truncated).");
		System.out.println("The operations will reset, and you must perform a sequence of operations that leave you with your target number.");
		System.out.println("Try to do so in as few moves as possible. Good luck! Enter 1 to begin.");
		int ready = 0;
		char awsd = 'o';
		do
		{
			ready = input.nextInt();
			if(ready != 1)
				System.out.println("You don't appear to be ready. Enter 1 when you are ready to begin.");
		}
		while(ready != 1);
		
		int center = (int)(89 * Math.random() + 10);
		int goal = (int)(99 * Math.random());
		int moves = 0;
		
		int left = 0;
		int right = 0;
		int top = 0;
		int bottom = 0;
		
		
		do
		{
			left = (int)(9 * Math.random());
			right = (int)(9 * Math.random());
			top = (int)(9 * Math.random());
			bottom = (int)(8 * Math.random() + 1);
			
			if(center >= 10000)
				center = 9999;
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("                             *" + top);
			System.out.println("                         -----------");
			System.out.println("                        |           |");
			System.out.println("                        |           |");
			if(center < 10)
				System.out.println("                     -" + left + " |     " + center + "     | +" + right);
			if(center >= 10 && center < 100)
				System.out.println("                     -" + left + " |    " + center + "     | +" + right);
			if(center >= 100 && center < 1000)
				System.out.println("                     -" + left + " |    " + center + "    | +" + right);
			if(center >= 1000 && center < 10000)
				System.out.println("                     -" + left + " |   " + center + "    | +" + right);
			System.out.println("                        |           |");
			System.out.println("                        |           |");
			System.out.println("                         -----------");
			System.out.println("                             /" + bottom);
			System.out.println("\n                      Your goal is " + goal);
			System.out.println("                         Moves: " + moves);
			System.out.println("\n\n\n\n\n\n\n\n\n");
			
			do
			{
				awsd = input.next().charAt(0);
			
				if(awsd == 'a')
					center = center - left;
				else if(awsd == 'd')
					center = center + right;
				else if(awsd == 'w')
					center = center * top;
				else if(awsd == 's')
					center = center / bottom;
				else
					System.out.println("That's not a valid input! Please try again:");
			}
			while(awsd != 'a' && awsd != 'w' && awsd != 's' && awsd != 'd');
			
			moves = moves + 1;
			
		
		}
		while(center != goal);
		
		System.out.println("You win! It took you " + moves + " moves!");
	}
}