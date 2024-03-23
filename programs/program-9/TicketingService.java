import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingService {

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String personName;
      int counter = 0;
      int youPosition = -1; // Initialize youPosition to -1, as you haven't entered the queue yet

      Queue<String> peopleInQueue = new LinkedList<String>();

      personName = scnr.nextLine();
      while (!personName.equals("-1")) {
         peopleInQueue.add(personName);
         counter++;

         if (personName.equalsIgnoreCase("you")) {
            youPosition = counter; // Set youPosition when you enter the queue
         }

         personName = scnr.nextLine();
      }

      System.out.println("Welcome to the ticketing service... ");
      if (youPosition != -1) {
         System.out.println("You are number " + youPosition + " in the queue.");
      } else {
         System.out.println("You are not in the queue.");
         scnr.close();
         return; // Exit if you're not in the queue
      }

      while (!peopleInQueue.isEmpty()) {
         String currentPerson = peopleInQueue.remove();
         if (!currentPerson.equalsIgnoreCase("you")) {
            System.out.println(currentPerson + " has purchased a ticket.");
         }

         if (currentPerson.equalsIgnoreCase("you")) {
            System.out.println("You can now purchase your ticket!");
            break; // Stop processing when you get your ticket
         } else {
            --youPosition; // Update your position as others move out
            System.out.println("You are now number " + youPosition);
         }
      }

      scnr.close();
   }
}
