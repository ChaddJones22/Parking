import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Gate pl = new Gate(0,0,0);
        Scanner userInput = new Scanner(System.in); //for console inputs
        int size1 = 0, size2 = 0, size3 = 0;
        int counter= 0;
        char answer = 'N';  //for console inputs.

        System.out.print("Testing Parking Lot Program!\n");
        System.out.println("Inputting Lot A, B, and C");
        size1 = pl.fileScan.nextInt();

        //creating lot size with one input for testing
        //Lot A, B, and C will have the exact same size.
         pl.lotCapA = pl.lotCapB = pl.lotCapC = size1;
        TimeUnit.SECONDS.sleep(2);

        //testing data using inputs from a file.
         while(true){
             char fileInput = pl.fileScan.next().charAt(0);
             TimeUnit.SECONDS.sleep(2);
             if (fileInput == 'E'){
             System.out.println("Car is attempting to enter parking lot.");
             pl.EnteringLot();
             counter++;
             }
             if (fileInput == 'L'){
                 System.out.println("1 min wait time.");
                 TimeUnit.MINUTES.sleep(1); //sim leaving
                 System.out.println("Insert Ticket....");
                 int key = pl.fileScan.nextInt();
                 pl.ExitingLot(key); counter--;
             }
             if(counter <= 0) break;
             /*else{
             System.out.println("Do you want to run program again? y or n");
             answer = pl.fileScan.next().charAt(0);
             System.out.println("input: "+answer);
             if(answer == 'n' || answer == 'N') break;

             }*/
         }


        //----------------------------------------------------------------------------------------------------------------
         /*
         //Console drive
         while(true){
         System.out.println("Do you want the lot sizes to be equal? Y or N?");
         answer = userInput.next().charAt(0);
         if (answer == 'y'|| answer == 'Y'){
             System.out.println("Enter lot size.");
             size1 = size2 = size3 = userInput.nextInt(); break;
         }
         if (answer == 'n'||answer=='N'){
         System.out.println("Enter Lot A, B, and C size.");
         size1 = userInput.nextInt(); size2 = userInput.nextInt(); size3 = userInput.nextInt(); break;
         }
         else System.out.println("Error!");}
          while(true){
              System.out.println("Is there a car entering or leaving the lot? E or L");
              answer = userInput.next().charAt(0);
              if(answer == 'E' || answer == 'e') {
                  System.out.println("Car entering lot.");
                  pl.EnteringLot();
              }
              if(answer == 'L' || answer == 'l'){
                  System.out.println("Car is attempting to exit the lot\nEnter your ticket.");
                  int ticketID = userInput.nextInt();
                  pl.ExitingLot(ticketID);
              }
              else;
              System.out.println("Do you want to run program again? Y or N");
              answer = userInput.next().charAt(0);
              if (answer == 'N' || answer =='n') break;
          }
            System.out.println("What data do you want from the Parking Lot?" +
                    "\n1 for Profit " +
                    "\n2 for total cars parked" +
                    "\n3 for current parked cars. " +
                    "\n4 for all.");
          int getData = userInput.nextInt();
          switch (getData){
              case 1: System.out.println("Total profit: " + pl.getProfit()); break;
              case 2: System.out.println("Total cars parked: " + pl.getTotalCarsParked()); break;
              case 3: System.out.println("Cars still parked in all the lots: " + pl.getTotalCarsParkedCurrently()); break;
              case 4: System.out.println("Profit: "+ pl.getProfit() + "\nTotal cars parked: "+ pl.getTotalCarsParked() + "\nCars currently park: "+ pl.getTotalCarsParkedCurrently()); break;
          }

          */
         System.out.println("End of Program.");
    }
}

