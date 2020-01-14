import java.util.Scanner;
import java.util.Random;

public class Game2048
{
   public static void main(String[] args)
   {
      System.out.println("Enter AWSD keys to choose the direction in which you wish to swipe.");
      
      int[][] board = new int[4][4];      //[row][column] starting at top left
      boolean gameOver = false;
      Scanner input = new Scanner(System.in);
      addTile(board);
      while(!gameOver)
      {
         addTile(board);
         printBoard(board);
         boolean moveDone = false;
         while(!moveDone && !gameOver)
         {
            String direction = input.next();
            if(direction.equals("a") && checkLeft(board))
            {
               swipeLeft(board);
               moveDone = true;
            }
            else if(direction.equals("d") && checkRight(board))
            {
               swipeRight(board);
               moveDone = true;
            }
            else if(direction.equals("w") && checkUp(board))
            {
               swipeUp(board);
               moveDone = true;
            }
            else if(direction.equals("s") && checkDown(board))
            {
               swipeDown(board);
               moveDone = true;
            }
            
            if(!checkLeft(board) && !checkRight(board) && !checkUp(board) && !checkDown(board))
               gameOver = true;
         }
         
      }
      if(gameOver)
         System.out.println("You lose!");
   }
     
   public static boolean checkLeft(int[][] board)     // sees if left move is valid
   {
      for(int i = 0; i < 4; i++)
      {
         for(int j = 0; j < 3; j++)
         {
            if((board[i][j] == 0 && board[i][j + 1] != 0) || (board[i][j] != 0 && board[i][j] == board[i][j + 1]))
               return true;
         }
      }
      return false;
   }
   
   public static boolean checkRight(int[][] board)     // sees if right move is valid
   {
      for(int i = 0; i < 4; i++)
      {
         for(int j = 3; j > 0; j--)
         {
            if((board[i][j] == 0 && board[i][j - 1] != 0) || (board[i][j] != 0 && board[i][j] == board[i][j - 1]))
               return true;
         }
      }
      return false;
   }
   
   public static boolean checkUp(int[][] board)     // sees if up move is valid
   {
      for(int i = 0; i < 3; i++)
      {
         for(int j = 0; j < 4; j++)
         {
            if((board[i][j] == 0 && board[i + 1][j] != 0) || (board[i][j] != 0 && board[i][j] == board[i + 1][j]))
               return true;
         }
      }
      return false;
   }
   
   public static boolean checkDown(int[][] board)     // sees if down move is valid
   {
      for(int i = 3; i > 0; i--)         
      {
         for(int j = 0; j < 4; j++)
         {
            if((board[i][j] == 0 && board[i - 1][j] != 0) || (board[i][j] != 0 && board[i][j] == board[i - 1][j]))
               return true;
         }
      }
      return false;
   }
      
   public static int[][] addTile(int[][] board)
   {
      Random rand = new Random();
                  
      while(true)
      {
         int newTile;
         if(rand.nextInt(10) == 0)     // 10% chance of spawning a 4
            newTile = 4;
         else
            newTile = 2;
         
         int rand1 = rand.nextInt(4);
         int rand2 = rand.nextInt(4);
         if(board[rand1][rand2] == 0)
         {
            board[rand1][rand2] = newTile;
            return board;
         }
      }
   }
   
   public static int[][] swipeRight(int[][] board)    // start at bottom right
   {
      for(int i = 3; i >= 0; i--)    // i counts row, j counts column
      {
         for(int j = 2; j >= 0; j--)      // loop for sliding
         {
            // how many times a number should attempt to slide
            for(int slideAttempt = 0; slideAttempt < 3 - j && board[i][slideAttempt + j + 1] == 0; slideAttempt++)
            {
               board[i][slideAttempt + j + 1] = board[i][slideAttempt + j];
               board[i][slideAttempt + j] = 0;
            }
         }

         for(int j = 2; j >= 0; j--)    // loop for combining
         {
            if(board[i][j + 1] == board[i][j])
            {
               board[i][j + 1] *= 2;
               board[i][j] = 0;
               
               if(j == 2)
               {
                  board[i][2] = board[i][1];
                  board[i][1] = board[i][0];
                  board[i][0] = 0;
               }
               else if(j == 1)
               {
                  board[i][1] = board[i][0];
                  board[i][0] = 0;
               }
               else
                  board[i][0] = 0;
            }
         }
      }
      
      
      return board;
   }
   
   public static int[][] swipeLeft(int[][] board)
   {
      for(int i = 3; i >= 0; i--)    // i counts row, j counts column
      {
         for(int j = 1; j <= 3; j++)      // loop for sliding
         {
            // how many times a number should attempt to slide
            for(int slideAttempt = 0; slideAttempt < j && board[i][j - 1 - slideAttempt] == 0; slideAttempt++)
            {
               board[i][j - 1 - slideAttempt] = board[i][j - slideAttempt];
               board[i][j - slideAttempt] = 0;
            }            
         }
         
         for(int j = 1; j <= 3; j++)    // loop for combining
         {
            if(board[i][j - 1] == board[i][j])
            {
               board[i][j - 1] *= 2;
               board[i][j] = 0;
               
               if(j == 1)
               {
                  board[i][1] = board[i][2];
                  board[i][2] = board[i][3];
                  board[i][3] = 0;
               }
               else if(j == 2)
               {
                  board[i][2] = board[i][3];
                  board[i][3] = 0;
               }
               else
                  board[i][3] = 0;
            }
         }
      }
      
      
      return board;
   }
   
   public static int[][] swipeUp(int[][] board)
   {
      for(int j = 3; j >= 0; j--)    // i counts row, j counts column
      {
         for(int i = 1; i <= 3; i++)      // loop for sliding
         {
            // how many times a number should attempt to slide
            for(int slideAttempt = 0; slideAttempt < i && board[i - 1 - slideAttempt][j] == 0; slideAttempt++)
            {
               board[i - 1 - slideAttempt][j] = board[i - slideAttempt][j];
               board[i - slideAttempt][j] = 0;
            }            
         }

         for(int i = 1; i <= 3; i++)    // loop for combining
         {
            if(board[i - 1][j] == board[i][j])
            {
               board[i - 1][j] *= 2;
               board[i][j] = 0;
               
               if(i == 1)
               {
                  board[1][j] = board[2][j];
                  board[2][j] = board[3][j];
                  board[3][j] = 0;
               }
               else if(i == 2)
               {
                  board[2][j] = board[3][j];
                  board[3][j] = 0;
               }
               else
                  board[3][j] = 0;
            }
         }
      }
      
      
      return board;
   }
   
   public static int[][] swipeDown(int[][] board)
   {
      for(int j = 3; j >= 0; j--)    // i counts row, j counts column
      {
         for(int i = 2; i >= 0; i--)      // loop for sliding
         {
            // how many times a number should attempt to slide
            for(int slideAttempt = 0; slideAttempt < 3 - i && board[i + 1 + slideAttempt][j] == 0; slideAttempt++)
            {
               board[i + 1 + slideAttempt][j] = board[i + slideAttempt][j];
               board[i + slideAttempt][j] = 0;
            }
         }

         for(int i = 2; i >= 0; i--)    // loop for combining
         {
            if(board[i + 1][j] == board[i][j])
            {
               board[i + 1][j] *= 2;
               board[i][j] = 0;
               
               if(i == 2)
               {
                  board[2][j] = board[1][j];
                  board[1][j] = board[0][j];
                  board[0][j] = 0;
               }
               else if(i == 1)
               {
                  board[1][j] = board[0][j];
                  board[0][j] = 0;
               }
               else
                  board[0][j] = 0;
            }
         }
      }
      
      
      return board;
   }

   
   public static void printBoard(int[][] board)
   {
      System.out.println("\n\n\n\n\n");
      for(int i = 0; i < 4; i++)
      {
         for(int j = 0; j < 4; j++)
         {
            int e = board[i][j];
            if(e == 0)
               System.out.print("*   ");
            else if(e > 0 && e < 10)
               System.out.print(e + "   ");
            else if(e >= 10 && e < 100)
               System.out.print(e + "  ");
            else if(e >= 100 && e < 1000)
               System.out.print(e + " ");
            else if(e >= 1000 && e < 10000)
               System.out.print(e + " ");
            else
               System.out.print(e);
         }
         System.out.println("");
      }
      
   }
}