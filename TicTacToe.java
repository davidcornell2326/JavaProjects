import java.util.Scanner;

public class TicTacToe
{
   public static void main(String[] args)
   {  
      Scanner input = new Scanner(System.in);
      int ready = 0;
      int turn = 1;
      int box = 0;
      boolean gameOver = false;
		boolean tie = false;
      String box1 = " ";
      String box2 = " ";
      String box3 = " ";
      String box4 = " ";
      String box5 = " ";
      String box6 = " ";
      String box7 = " ";
      String box8 = " ";
      String box9 = " ";
      
      System.out.println("Welcome to TicTacToe! You know how to play. Just remember that each boc is numbered and enter that number to select it.");
      System.out.println("Enter 1 to begin:");
      do
      {
         ready = input.nextInt();
         if(ready != 1)
            System.out.println("That's not a valid input! Please try again: ");
      }
      while(ready != 1);
      
      do    // loops main game until gameOver == true
      {
                  
         if((box1 == box2 && box2 == box3 && box1 != " ") || (box4 == box5 && box5 == box6 && box4 != " ") || (box7 == box8 && box8 == box9 && box7 != " "))      // detect horizontal wins
            gameOver = true;
         if((box1 == box4 && box4 == box7 && box1 != " ") || (box2 == box5 && box5 == box8 && box2 != " ") || (box3 == box6 && box6 == box9 && box3 != " "))      // detect vertical wins
            gameOver = true;
         if((box1 == box5 && box5 == box9 && box1 != " ") || (box3 == box5 && box5 == box7 && box3 != " "))    // detect diagonal wins
            gameOver = true;
			if(box1 != " " && box2 != " " && box3 != " " && box4 != " " && box5 != " " && box6 != " " && box7 != " " && box8 != " " && box9 != " ")
				tie = true;

         // prints out tic tac toe board with string in each box and a second board as a key
         System.out.println("\n\n\n\n\n\n\n\n\n");
         System.out.println("          -----------             -----------");
         System.out.println("         | " + box1 + " | " + box2 + " | " + box3 + " |           | 1 | 2 | 3 |");
         System.out.println("         |-----------|           |-----------|");
         System.out.println("         | " + box4 + " | " + box5 + " | " + box6 + " |     Key:  | 4 | 5 | 6 |");
         System.out.println("         |-----------|           |-----------|");
         System.out.println("         | " + box7 + " | " + box8 + " | " + box9 + " |           | 7 | 8 | 9 |");
         System.out.println("          -----------             -----------");
         System.out.println("\n\n\n");
   
         if(gameOver)      // determines winner based on current turn if game is over
         {
            if(turn == 1)
               System.out.println("O player won! Congrats!");
            else
               System.out.println("X player won! Congrats!");
         }
         
         if(!gameOver)
         {
            if(turn == 1)
            {
               System.out.println("X player, it's your turn! Please choose a box:");
               do    // redoes user input if invalid
               {
                  box = input.nextInt();
                  // ensures selected box is empty
                  if((box == 1 && box1 != " ") || (box == 2 && box2 != " ") || (box == 3 && box3 != " ") || (box == 4 && box4 != " ") || (box == 5 && box5 != " ") || (box == 6 && box6 != " ") || (box == 7 && box7 != " ") || (box == 8 && box8 != " ") || (box == 9 && box9 != " "))
                     System.out.println("That box has already been taken! Choose again:");
                  // ensures number 1-9 is selected
                  if(box < 1 || box > 9)
                     System.out.println("That input is invalid! Please try again:");
               }
               while((box == 1 && box1 != " ") || (box == 2 && box2 != " ") || (box == 3 && box3 != " ") || (box == 4 && box4 != " ") || (box == 5 && box5 != " ") || (box == 6 && box6 != " ") || (box == 7 && box7 != " ") || (box == 8 && box8 != " ") || (box == 9 && box9 != " ") || box < 1 || box > 9); 
               
               // turns selected box into X
               if(box == 1 && box1 == " ") box1 = "X";
               else if(box == 2 && box2 == " ") box2 = "X";
               else if(box == 3 && box3 == " ") box3 = "X";
               else if(box == 4 && box4 == " ") box4 = "X";
               else if(box == 5 && box5 == " ") box5 = "X";
               else if(box == 6 && box6 == " ") box6 = "X";
               else if(box == 7 && box7 == " ") box7 = "X";
               else if(box == 8 && box8 == " ") box8 = "X";
               else box9 = "X";
               turn = 2;      // next turn
            }
            else     // all is the same as X's turn, but for O
            {
               System.out.println("O player, it's your turn! Please choose a box:");
               do
               {
                  box = input.nextInt();
                  if((box == 1 && box1 != " ") || (box == 2 && box2 != " ") || (box == 3 && box3 != " ") || (box == 4 && box4 != " ") || (box == 5 && box5 != " ") || (box == 6 && box6 != " ") || (box == 7 && box7 != " ") || (box == 8 && box8 != " ") || (box == 9 && box9 != " "))
                     System.out.println("That box has already been taken! Choose again:");
                  if(box < 1 || box > 9)
                     System.out.println("That input is invalid! Please try again:");
               }
               while((box == 1 && box1 != " ") || (box == 2 && box2 != " ") || (box == 3 && box3 != " ") || (box == 4 && box4 != " ") || (box == 5 && box5 != " ") || (box == 6 && box6 != " ") || (box == 7 && box7 != " ") || (box == 8 && box8 != " ") || (box == 9 && box9 != " ") || box < 1 || box > 9); 
               
               if(box == 1 && box1 == " ") box1 = "O";
               else if(box == 2 && box2 == " ") box2 = "O";
               else if(box == 3 && box3 == " ") box3 = "O";
               else if(box == 4 && box4 == " ") box4 = "O";
               else if(box == 5 && box5 == " ") box5 = "O";
               else if(box == 6 && box6 == " ") box6 = "O";
               else if(box == 7 && box7 == " ") box7 = "O";
               else if(box == 8 && box8 == " ") box8 = "O";
               else box9 = "O";
               turn = 1;
            }
         }
      }
      while(gameOver == false);
   }
}