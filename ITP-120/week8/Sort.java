/**
 * Write a program that lets the user enter numbers from the keyboard with a sentinel value for ending the input.  
 * You then should allow the user to print out the list of numbers a) sorted  b) shuffled and c) reversed.   
 * @author A.Bunk 7.10.2014
 * */
package week8;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.*;

public class Sort
{

  public static void main (String [] args) 
  {
    /** Choice: 

   1.  Enter Some Whole Numbers 

   2.  Sort Numbers � Low to High 

   3.  Shuffle Numbers - Random 

   4.  Reverse Numbers - High to Low 

   5.  Reverse Numbers of your Current List 

   6.  QUIT!!!!
    
    */ 
    
    // You need to add in the above menu and then you also need to add in commands for each of those.
    int choice = 0;
    Scanner scan = new Scanner (System.in);
    ArrayList <Integer> list = new ArrayList <Integer>();
    
    while (true)
    { 
      try 
      {
        System.out.println ("Choice:\n1.  Enter some Whole Numbers \n2.  Sort Numbers - Low to High \n3." +  
                            "  Shuffle Numbers - Random\n4.  Reverse Numbers - High to Low \n5.  Reverse Numbers of your Current List \n6.  QUIT!!!");
        choice = scan.nextInt();
        if (choice == 1)
        {
          addNums(list);
          // make sure -999 is not part of the list
          System.out.println("The numbers you entered are: \n" + list);
        }
          // need a method to have the user enter the whole numbers, you need to set up a loop here that will add the user's entries
          // to an ArrayList.  If the user inputs -999 then the program will exit.
          else if (choice == 2)
            lowToHigh(list);
          // need a method to sort the numbers from low to high.
      
          else if (choice == 3)
            random(list);
          // need a method to randomly shuffle the #s
      
          else if (choice == 4)
            highToLow(list);
          
          else if (choice ==5)
            reverse(list);
        
          else if (choice ==6)
          {
            System.out.println ("Have a wonderful day!");
            break;
          }
          else if (choice > 6)
          {
            System.out.println ("You did not enter a # between 1 and 6. Please try again!");  
          }
          else if (choice < 1)
          {
            System.out.println ("You did not enter a # between 1 and 6. Please try again!"); 
          }
      }
      // check this catch statement in Eclipse, there is an issue here 
      catch (InputMismatchException e)
      {
       System.out.println ("You did not enter a # between 1 and 6. Please try again!");  
       scan.nextLine(); // due to the Scanner issue!
      }
      
        
    }
    
    scan.close();
    
    
  } // end of main
    
  public static void addNums (ArrayList <Integer> list)
  {
    // we want to clean out the list every time the user chooses this option
    list.removeAll(list);
    // add a scanner and the sentinel, then we will prompt the user to enter #'s which will be added to list
    // if the user enters -999 then the loop ends
    Scanner scan = new Scanner (System.in);
    int num =  0;
    System.out.println ("Please add the whole numbers you want to sort (hit enter to add a new number), enter -999 to stop inputting numbers.");
    while ( num != -999)
    {
      try
      {
        num = scan.nextInt();
        list.add(num);
      }
      catch (InputMismatchException e)
      {
        System.out.println ("You did not enter a whole number. Please try again!");
        scan.nextLine(); // due to the Scanner issue!
      }
    }
    // since we know -999 will always be the last number in the list we remove the last element of list.
    list.remove(list.size()-1);
   
  }
    
  public static void lowToHigh (ArrayList <Integer> list)
  {
    Collections.sort(list);
    for (int i = 0; i < list.size(); ++i)
      System.out.println(list.get(i));
  }
    
  public static void random (ArrayList <Integer> list)
  {
    Collections.shuffle(list);
    for (int i = 0; i < list.size(); ++i)
      System.out.println(list.get(i));
  }
  
  public static void highToLow (ArrayList <Integer> list)
  {
    Collections.sort(list, Collections.reverseOrder());
    for (int i = 0; i < list.size(); ++i)
      System.out.println(list.get(i));
  }
  
  public static void reverse (ArrayList <Integer> list)
  {
    Collections.reverse(list);
    for (int i = 0; i < list.size(); ++i)
      System.out.println(list.get(i));
  }
 
    
} //end of class