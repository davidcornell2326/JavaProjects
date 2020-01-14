// project directions: https://apcentral.collegeboard.org/pdf/ap-csp-student-task-directions.pdf
// type advantages: https://img.pokemondb.net/images/typechart.png

import java.util.Scanner;
import java.util.Random;

public class PokemonProject
{
      static String[] pokemon = new String[8];
      static int[] yourHealth = {100,100,100,100,100,100,100,100};
		static int[] opponentHealth = {100,100,100,100,100,100,100,100};
      static String[][] attacks = new String[8][4];
      static int[][] attackPower = new int[8][4];
      static int[][] yourAttackPP = new int[8][4];
		static int[][] opponentAttackPP = new int[8][4];
      static double[][] multiplier = new double[8][8];
      static int[] yourChoices = new int[4];
		static int[] opponentChoices = new int[4];
      static Scanner input = new Scanner(System.in);
      static Random rand = new Random();
		static int opponentCurrentPokemon = -1;
		static boolean opponentWait = true;
      
      public PokemonProject()
      {
         // array for pokemon names
         pokemon[0] = "Eevee";
         pokemon[1] = "Charmander";
         pokemon[2] = "Squirtle";
         pokemon[3] = "Pikachu";
         pokemon[4] = "Bulbsaur";
         pokemon[5] = "Vanillite";
         pokemon[6] = "Machop";
         pokemon[7] = "Ekans";
         
         // 2-D array for attack names (first dimension is pokemon, second is attack)
         attacks[0] = new String[] {"Tackle","Quick Attack","Take Down","Double-Edge"};
         attacks[1] = new String[] {"Scratch","Ember","Fire Spin","Flamethrower"};
         attacks[2] = new String[] {"Tackle","Bubble","Bubble Beam","Hydro Pump"};
         attacks[3] = new String[] {"Thunder Shock","Quick Attack","Thunderbolt","Slam"};
         attacks[4] = new String[] {"Tackle","Vine Whip","Razor Leaf","Double-Edge"};
         attacks[5] = new String[] {"Icicle Spear","Icy Wind","Ice Beam","Blizzard"};
         attacks[6] = new String[] {"Karate Chop","Brick Break","Submission","Superpower"};
         attacks[7] = new String[] {"Acid","Bite","Poison Jab","Slam"};
         
         // 2-D array for attack power (first dimension is pokemon, second is attack)
         attackPower[0] = new int[] {40,40,90,120};
         attackPower[1] = new int[] {40,40,35,90};
         attackPower[2] = new int[] {40,40,65,110};
         attackPower[3] = new int[] {40,40,90,80};
         attackPower[4] = new int[] {40,45,55,120};
         attackPower[5] = new int[] {25,55,90,110};
         attackPower[6] = new int[] {50,75,80,120};
         attackPower[7] = new int[] {40,60,80,80};
         
         //2-D array for your attack PP (power point) (first dimension is pokemon, second is attack)
         yourAttackPP[0] = new int[] {7,6,4,3};
         yourAttackPP[1] = new int[] {7,5,3,3};
         yourAttackPP[2] = new int[] {7,6,4,1};
         yourAttackPP[3] = new int[] {6,6,3,4};
         yourAttackPP[4] = new int[] {7,5,5,3};
         yourAttackPP[5] = new int[] {6,3,2,1};
         yourAttackPP[6] = new int[] {5,3,4,1};
         yourAttackPP[7] = new int[] {6,5,4,4};
         
			//2-D array for opponent attack PP (power point) (first dimension is pokemon, second is attack)
         opponentAttackPP[0] = new int[] {7,6,4,3};
         opponentAttackPP[1] = new int[] {7,5,3,3};
         opponentAttackPP[2] = new int[] {7,6,4,1};
         opponentAttackPP[3] = new int[] {6,6,3,4};
         opponentAttackPP[4] = new int[] {7,5,5,3};
         opponentAttackPP[5] = new int[] {6,3,2,1};
         opponentAttackPP[6] = new int[] {5,3,4,1};
         opponentAttackPP[7] = new int[] {6,5,4,4};
			
         // 2-D array for Pokemon  type advantages (first dimension is your pokemon, second dimension is opponent pokemon)
         multiplier[0] = new double[] {1,1,1,1,1,1,1,1};
         multiplier[1] = new double[] {1,.5,.5,1,2,2,1,1};
         multiplier[2] = new double[] {1,2,.5,1,.5,1,1,1};
         multiplier[3] = new double[] {1,1,2,.5,.5,1,1,1};
         multiplier[4] = new double[] {1,.5,2,1,.5,1,1,.5};
         multiplier[5] = new double[] {1,.5,.5,1,2,.5,1,1};
         multiplier[6] = new double[] {2,1,1,1,1,2,1,.5};
         multiplier[7] = new double[] {1,1,1,1,2,1,1,.5};
      }
   
   public static void main(String[] args)
   {
      PokemonProject game = new PokemonProject();
      // variable declarations
      int ready = 0;
      
      // introduction
      System.out.println("Welcome to the Pokemon Fight Simulator!");
      System.out.println("Please choose 4 Pokemon, one at a time, to be in your bag:");
      System.out.println("1: Eevee (Normal Type)");
      System.out.println("2: Charmander (Fire Type)");
      System.out.println("3: Squirtle (Water Type)");
      System.out.println("4: Pikachu (Electric Type)");
      System.out.println("5: Bulbasaur (Grass Type)");
      System.out.println("6: Vanillite (Ice Type)");
      System.out.println("7: Machop (Fighting Type)");
      System.out.println("8: Ekans (Poison Type)");
      
		// choose your 4 pokemon
      for(int i = 0; i < 4; i++)
      {
         yourChoices[i] = input.nextInt();
         while(yourChoices[i] < 1 || yourChoices[i] > 8)
         {
            System.out.println("That's not a valid input! Please try again: ");
            yourChoices[i] = input.nextInt();
         }
         yourChoices[i]--;
      }
      
		// choose opponent 4 pokemon
		String takenPokemon = "";
		for(int i = 0; i < 4; i++)
      {
			int tempChoice = rand.nextInt(8);
			while(takenPokemon.contains("" + tempChoice))
				tempChoice = rand.nextInt(8);
			takenPokemon += tempChoice;
         opponentChoices[i] = tempChoice;
      }
		
      System.out.print("Time to fight! Enter 1 to begin: ");
      ready = input.nextInt();
      while(ready != 1)
      {
         System.out.println("That's not a valid input! Please try again: ");
         ready = input.nextInt();
      }
      
      fight(yourChoices, opponentChoices);
      
      
   }
   
   public static void fight(int[] yourChoices, int[] opponentChoices)
   {
      int yourAttack = 4;
      int yourCurrentPokemon = yourChoices[0];
		int opponentChoose = rand.nextInt(4);
		opponentCurrentPokemon = opponentChoices[opponentChoose];
		
		// main game loop
      while((opponentHealth[opponentChoices[0]] > 0 || opponentHealth[opponentChoices[1]] > 0 || opponentHealth[opponentChoices[2]] > 0 || opponentHealth[opponentChoices[3]] > 0) && (yourHealth[yourChoices[0]] > 0 || yourHealth[yourChoices[1]] > 0 || yourHealth[yourChoices[2]] > 0 || yourHealth[yourChoices[3]] > 0))
      {
   					
               
         printBoard(yourCurrentPokemon, opponentCurrentPokemon);
         
   		      
			
			// print your attacks and evaluate
         yourAttack = yourAttacks(yourCurrentPokemon, opponentCurrentPokemon);
			if(yourAttack == 4)		// you want to switch
			{
            do
            {
               System.out.println("Choose which Pokemon you want to fight with:");
               for(int i = 0; i < 4; i++)
               {
                  System.out.print(i + 1 + ": " + pokemon[yourChoices[i]]);
                  if(yourHealth[yourChoices[i]] <= 0)
                     System.out.println(" (fainted)");
                  else
                     System.out.println(" (Health: " + yourHealth[yourChoices[i]] + ")");
               }
               int yourChoose = input.nextInt();
               while(yourChoose < 1 || yourChoose > 4)
               {
                  System.out.print("That input is invalid! Please try again: ");
                  yourChoose = input.nextInt();
               }
               yourCurrentPokemon = yourChoices[yourChoose - 1];
               if(yourHealth[yourCurrentPokemon] <= 0)
                  System.out.println("This Pokemon has fainted!");
            }
            while(yourHealth[yourCurrentPokemon] <= 0);
				System.out.println("You switched to " + pokemon[yourCurrentPokemon] + "!"); 
			}
			else
			{
				System.out.print("You used " + attacks[yourCurrentPokemon][yourAttack] + "! ");    
				if(multiplier[yourCurrentPokemon][opponentCurrentPokemon] == 2.0)
	            System.out.println("It was super effective!");
	         else if(multiplier[yourCurrentPokemon][opponentCurrentPokemon] == .5)
	            System.out.println("It was not very effective.");
	         else
	            System.out.println("");
				opponentHealth[opponentCurrentPokemon] -= attackPower[yourCurrentPokemon][yourAttack] * multiplier[yourCurrentPokemon][opponentCurrentPokemon];
				yourAttackPP[yourCurrentPokemon][yourAttack]--;
			}
         
			// choose opponent attacks and evaluate
			if(opponentWait || multiplier[yourCurrentPokemon][opponentCurrentPokemon] != 2)		// opponent is attacking
			{
				opponentWait = false;
				int opponentAttack = rand.nextInt(4);
				System.out.print("Your opponent used " + attacks[opponentCurrentPokemon][opponentAttack] + "! ");
				if(multiplier[opponentCurrentPokemon][yourCurrentPokemon] == 2.0)
	            System.out.println("It was super effective!\n");
	         else if(multiplier[opponentCurrentPokemon][yourCurrentPokemon] == .5)
	            System.out.println("It was not very effective.\n");
	         else
	            System.out.println("\n");
	            
	         yourHealth[yourCurrentPokemon] -= attackPower[opponentCurrentPokemon][opponentAttack] * multiplier[opponentCurrentPokemon][yourCurrentPokemon];
			}
			else		// opponent wants to switch
			{
				boolean switched = true;
				for(int e : opponentChoices)
					if(opponentHealth[e] > 0 && e != opponentCurrentPokemon && multiplier[yourCurrentPokemon][e] != 2)		// makes switched false if beneficial switch is possible
						switched = false;
				// given possible beneficial switch, finds and switches to a beneficial switch
				int temp = 0 + opponentCurrentPokemon;
				rand = new Random();
				while(!switched)
				{
					opponentCurrentPokemon = opponentChoices[rand.nextInt(4)];
					if(opponentHealth[opponentCurrentPokemon] > 0 && opponentCurrentPokemon != temp && multiplier[yourCurrentPokemon][opponentCurrentPokemon] != 2)
					{
						switched = true;
						System.out.println("Your opponent switched to " + pokemon[opponentCurrentPokemon] + "!");
						opponentWait = true;
					}
					else
						opponentCurrentPokemon = temp;
				}
			}
			
			
			// your faint message
			if(yourHealth[yourCurrentPokemon] <= 0)
			   System.out.println("Your " + pokemon[yourCurrentPokemon] + " fainted!\n"); 
			
			// opponent faint
			if(opponentHealth[opponentCurrentPokemon] <= 0)
			{
				System.out.println("Your opponent's " + pokemon[opponentCurrentPokemon] + " fainted!\n");
				if(opponentHealth[opponentChoices[0]] > 0 || opponentHealth[opponentChoices[1]] > 0 || opponentHealth[opponentChoices[2]] > 0 || opponentHealth[opponentChoices[3]] > 0)
					do
						opponentCurrentPokemon = opponentChoices[rand.nextInt(4)];
					while(opponentHealth[opponentCurrentPokemon] <= 0);
			}
						
         // your faint selection
   		if(yourHealth[yourCurrentPokemon] <= 0)
         {
            do
            {
               System.out.println("Choose which Pokemon you want to fight with:");
               for(int i = 0; i < 4; i++)
               {
                  System.out.print(i + 1 + ": " + pokemon[yourChoices[i]]);
                  if(yourHealth[yourChoices[i]] <= 0)
                     System.out.println(" (fainted)");
                  else
                     System.out.println(" (Health: " + yourHealth[yourChoices[i]] + ")");
               }
               int yourChoose = input.nextInt();
               while(yourChoose < 1 || yourChoose > 4)
               {
                  System.out.print("That input is invalid! Please try again: ");
                  yourChoose = input.nextInt();
               }
               yourCurrentPokemon = yourChoices[yourChoose - 1];
               if(yourHealth[yourCurrentPokemon] <= 0)
                  System.out.println("This Pokemon has fainted!");
            }
            while(yourHealth[yourCurrentPokemon] <= 0);
         }
 
			System.out.print("Enter 1 to continue: ");
      	int ready = input.nextInt();
      	while(ready != 1)
      	{
      	   System.out.println("That's not a valid input! Please try again: ");
      	   ready = input.nextInt();
      	}   
			
			if(opponentHealth[opponentChoices[0]] <= 0 && opponentHealth[opponentChoices[1]] <= 0 && opponentHealth[opponentChoices[2]] <= 0 && opponentHealth[opponentChoices[3]] <= 0)
				System.out.println("All of your opponent's Pokemon have fainted! You win!");
         else if(yourHealth[yourChoices[0]] <= 0 && yourHealth[yourChoices[1]] <= 0 && yourHealth[yourChoices[2]] <= 0 && yourHealth[yourChoices[3]] <= 0)
            System.out.println("All of your Pokemon have fainted! Your opponent wins!");
      }
      
      
   
   
   
   
   }
   
   public static void printBoard(int yourCurrentPokemon, int opponentCurrentPokemon)
   {
      System.out.println(" ------------------------------------------------ ");
      String space = "                         ";
      String space2 = "";
      if(opponentCurrentPokemon == 0)
         printNormal(space, space2);
      else if(opponentCurrentPokemon == 1)
         printFire(space, space2);
      else if(opponentCurrentPokemon == 2)
         printWater(space, space2);
      else if(opponentCurrentPokemon == 3)
         printElectric(space, space2);
      else if(opponentCurrentPokemon == 4)
         printGrass(space, space2);
      else if(opponentCurrentPokemon == 5)
         printIce(space, space2);
      else if(opponentCurrentPokemon == 6)
         printFighting(space, space2);
      else
         printPoison(space, space2);
      
      space2 = space;
      space = "";
      if(yourCurrentPokemon == 0)
         printNormal(space, space2);
      else if(yourCurrentPokemon == 1)
         printFire(space, space2);
      else if(yourCurrentPokemon == 2)
         printWater(space, space2);
      else if(yourCurrentPokemon == 3)
         printElectric(space, space2);
      else if(yourCurrentPokemon == 4)
         printGrass(space, space2);
      else if(yourCurrentPokemon == 5)
         printIce(space, space2);
      else if(yourCurrentPokemon == 6)
         printFighting(space, space2);
      else
         printPoison(space, space2);
      
      System.out.println(" ------------------------------------------------ ");
      System.out.println("Health: " + yourHealth[yourCurrentPokemon] + "                   Opponent Health: " + opponentHealth[opponentCurrentPokemon] + "\n");
      
   }
      
   public static int yourAttacks(int yourCurrentPokemon, int opponentCurrentPokemon)     // references attacks array for attack names
   {
      int yourAttack = -1;
      do
      {
         System.out.println("Choose an attack: ");
         for(int i = 0; i < 4; i++)
            System.out.println(i + 1 + ": " + attacks[yourCurrentPokemon][i] + " (Uses remaining: " + yourAttackPP[yourCurrentPokemon][i] + ")");
         System.out.println("5: switch Pokemon");
         yourAttack = input.nextInt() - 1;
         while(yourAttack < 0 && yourAttack > 4)
         {
            System.out.print("That input is invalid! Please try again: ");
            yourAttack = input.nextInt() - 1;
         }
         
         if(yourAttack != 4 && yourAttackPP[yourCurrentPokemon][yourAttack] == 0)
            System.out.println("You have already used " + attacks[yourCurrentPokemon][yourAttack - 1] + " too many times! Please choose another attack: ");
      }
      while(yourAttack != 4 && yourAttackPP[yourCurrentPokemon][yourAttack] == 0);
      
      return yourAttack;      // [0,4]
      
   }
   
   public static void printNormal(String space, String space2)    // Eevee
   {
      System.out.println("|" + space + " /\\                    " + space2 + "|");
      System.out.println("|" + space + "|  \\         ___       " + space2 + "|");
      System.out.println("|" + space + "|  |       _/  /       " + space2 + "|");
      System.out.println("|" + space + " \\ | ___  /  _/        " + space2 + "|");
      System.out.println("|" + space + "  \\|/   \\/__/          " + space2 + "|");
      System.out.println("|" + space + "   | 0 0 |    /|       " + space2 + "|");
      System.out.println("|" + space + "    \\_-_/  __/ |       " + space2 + "|");
      System.out.println("|" + space + "    / /\\\\_/   \\|       " + space2 + "|");
      System.out.println("|" + space + "   | |  | \\   /        " + space2 + "|");
      System.out.println("|" + space + "    \\_\\/__|__/         " + space2 + "|");
      System.out.println("|" + space + "    | \\/ / | |         " + space2 + "|");
      System.out.println("|" + space + "    |_|_||_/_|         " + space2 + "|");
      // format: move (power/PP)
      // HP 55, attack 55, defense 50, tackle (40/35), quick attack (40/30), take down (90/20), double-edge (120/15)
   }
   
   public static void printFire(String space, String space2)      // Charmander
   {
      System.out.println("|" + space + "     ____              " + space2 + "|");
      System.out.println("|" + space + "    /    \\             " + space2 + "|");
      System.out.println("|" + space + "   | 0  0 |            " + space2 + "|");
      System.out.println("|" + space + "    \\ __ /             " + space2 + "|");
      System.out.println("|" + space + "  ___\\__/_____   /\\    " + space2 + "|");
      System.out.println("|" + space + " |___  __  ___| |  |   " + space2 + "|");
      System.out.println("|" + space + "     |/  \\ \\    \\__/   " + space2 + "|");
      System.out.println("|" + space + "     ||   \\ |___//     " + space2 + "|");
      System.out.println("|" + space + "     ||   | |___/      " + space2 + "|");
      System.out.println("|" + space + "   _ /|___| |_         " + space2 + "|");
      System.out.println("|" + space + "   \\_/     \\_/         " + space2 + "|");
      System.out.println("|" + space + "                       " + space2 + "|");
      // HP 39, attack 52, defense 43, scratch (40/35), ember (40/25), fire spin (35/15), flamethrower (90/15)
   }
   
   public static void printWater(String space, String space2)     // Squirtle
   {
      System.out.println("|" + space + "      ____             " + space2 + "|");
      System.out.println("|" + space + "     /    \\            " + space2 + "|");
      System.out.println("|" + space + "    | 0  0 |           " + space2 + "|");
      System.out.println("|" + space + "     \\ -- /_           " + space2 + "|");
      System.out.println("|" + space + " ____/---/  \\          " + space2 + "|");
      System.out.println("|" + space + " \\  /   /  / \\         " + space2 + "|");
      System.out.println("|" + space + " /__|   \\_/|  |  __    " + space2 + "|");
      System.out.println("|" + space + "    |      | /  / _\\   " + space2 + "|");
      System.out.println("|" + space + "   /|     _|/__/ /_||  " + space2 + "|");
      System.out.println("|" + space + "  /  \\___|  |    \\_/   " + space2 + "|");
      System.out.println("|" + space + "  |  |   |  |\\____/    " + space2 + "|");
      System.out.println("|" + space + "  |__|   |__|          " + space2 + "|");
      // HP 44, attack 48, defense 65, tackle (40/35), bubble (40/30), bubble beam (65/20), hydro pump (110/5)
   }
   
   public static void printElectric(String space, String space2)     // Pikachu
   {
      System.out.println("|" + space + "   /\\      ___         " + space2 + "|");
      System.out.println("|" + space + "  |__|    /__/         " + space2 + "|");
      System.out.println("|" + space + "  |  |   /  /          " + space2 + "|");
      System.out.println("|" + space + "   \\/___/__/        /| " + space2 + "|");
      System.out.println("|" + space + "    /   \\          / | " + space2 + "|");
      System.out.println("|" + space + "   | 0 0 \\         | | " + space2 + "|");
      System.out.println("|" + space + " ___\\ - _ \\      _/ /  " + space2 + "|");
      System.out.println("|" + space + "|___   |_| \\   _/ _/   " + space2 + "|");
      System.out.println("|" + space + "    |       \\_/ _/     " + space2 + "|");
      System.out.println("|" + space + "    |         \\/       " + space2 + "|");
      System.out.println("|" + space + "     \\ _ ___ _|        " + space2 + "|");
      System.out.println("|" + space + "      |_|   |_|        " + space2 + "|");
      // HP 35, attack 55, defense 40, thunder shock (40/30), quick attack (40/30), thunderbolt (90/15), slam (80/20)
   }
   
   public static void printGrass(String space, String space2)     // Bulbasaur
   {
      System.out.println("|" + space + "                       " + space2 + "|");
      System.out.println("|" + space + "        ____/|         " + space2 + "|");
      System.out.println("|" + space + "       /   _  \\        " + space2 + "|");
      System.out.println("|" + space + "   ___/_  /  \\ \\       " + space2 + "|");
      System.out.println("|" + space + "  /     \\/__  | \\      " + space2 + "|");
      System.out.println("|" + space + " | 0   0 |  \\/   |     " + space2 + "|");
      System.out.println("|" + space + " |  ___  |   \\_ /      " + space2 + "|");
      System.out.println("|" + space + "  \\_____/      \\       " + space2 + "|");
      System.out.println("|" + space + "    |  __|  |_  |      " + space2 + "|");
      System.out.println("|" + space + "    |_/ \\|_/  |_|      " + space2 + "|");
      System.out.println("|" + space + "                       " + space2 + "|");
      System.out.println("|" + space + "                       " + space2 + "|");
      // HP 45, attack 49, defense 49, tackle (40/35), vine whip (45/25), razor leaf (55/25), double edge (120/15)
   }
   
   public static void printIce(String space, String space2)    // Vanillite
   {
      System.out.println("|" + space + "            /|         " + space2 + "|");
      System.out.println("|" + space + "          _| |_        " + space2 + "|");
      System.out.println("|" + space + "         /     \\       " + space2 + "|");
      System.out.println("|" + space + "         \\_   _/       " + space2 + "|");
      System.out.println("|" + space + "         /     \\       " + space2 + "|");
      System.out.println("|" + space + "        /  0 0  \\      " + space2 + "|");
      System.out.println("|" + space + "       |<> --- <>|     " + space2 + "|");
      System.out.println("|" + space + "    _   \\_ ___ _/      " + space2 + "|");
      System.out.println("|" + space + "   / \\   <|   |>       " + space2 + "|");
      System.out.println("|" + space + "   \\_/    |___|   _    " + space2 + "|");
      System.out.println("|" + space + "                 / \\   " + space2 + "|");
      System.out.println("|" + space + "                 \\_/   " + space2 + "|");
      // HP 36, attack 50, defense 50, icicle spear (25/30), icy wind (55/15), ice beam (90/10), blizzard (110/5)
   }
   
   public static void printFighting(String space, String space2)     // Machop
   {
      System.out.println("|" + space + "          ||||         " + space2 + "|");
      System.out.println("|" + space + "          /  \\         " + space2 + "|");
      System.out.println("|" + space + "         |0 0 |        " + space2 + "|");
      System.out.println("|" + space + "         _\\-_/__       " + space2 + "|");
      System.out.println("|" + space + "        /       \\      " + space2 + "|");
      System.out.println("|" + space + "      _/ |-  -|\\ \\     " + space2 + "|");
      System.out.println("|" + space + "     |__/|-  -| \\ \\    " + space2 + "|");
      System.out.println("|" + space + "         |    | / /    " + space2 + "|");
      System.out.println("|" + space + "         |     \\\\/     " + space2 + "|");
      System.out.println("|" + space + "        /  __ | |      " + space2 + "|");
      System.out.println("|" + space + "       /  |  |  |      " + space2 + "|");
      System.out.println("|" + space + "      |___|  |__|      " + space2 + "|");
      // HP 70, attack 80, defense 50, karate chop (50/25), brick break (75/15), submission (80/20), superpower (120/5)
   }
   
   public static void printPoison(String space, String space2)    // ekans
   {
      System.out.println("|" + space + "   ___                 " + space2 + "|");
      System.out.println("|" + space + "  /_ 0\\                " + space2 + "|");
      System.out.println("|" + space + "   _|  \\       |\\      " + space2 + "|");
      System.out.println("|" + space + "  |_____|      |_|     " + space2 + "|");
      System.out.println("|" + space + "    /__/__     |_|     " + space2 + "|");
      System.out.println("|" + space + "   /  /   \\   /__|     " + space2 + "|");
      System.out.println("|" + space + "  |__      \\ /  /      " + space2 + "|");
      System.out.println("|" + space + " /   \\_____//  /       " + space2 + "|");
      System.out.println("|" + space + "|           \\ /        " + space2 + "|");
      System.out.println("|" + space + "|\\___________/         " + space2 + "|");
      System.out.println("|" + space + " \\          /          " + space2 + "|");
      System.out.println("|" + space + "  \\________/           " + space2 + "|");
      // HP 35, attack 60, defense 44, acid (40/30), bite (60/25), poison jab (80/20), slam (80/20)
   }
}