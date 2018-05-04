import java.util.Scanner;

public class Main {

public static void main(String[] args) {
  /** print instructions to screen **/
  System.out.println("This banking app has 10 accounts initialized with a balance of $100.\n " +
    "When prompted for ID, enter a value between 0-9, then follow instructions on the menu.\n\n");

  /** create a new instance of Scanner called 'in' **/
  Scanner in = new Scanner(System.in);

  /** create 10 user accounts with IDs 0-9 **/
  Account[] users = new Account[10];

  /** setting up all 10 users with an initial balance of 100 **/
  for (int i = 0; i < users.length; i++) {
    users[i] = new Account(i, 100.00);
  }

  /** prompt the user to enter ID and store that value in the userId variable **/
  System.out.print("Enter an id: ");
  int userId = in.nextInt();

  /** if the user enters an ID less than 1 and greater than 10 then it is invalid **/
  while (userId < 0 || userId > 9) {
    System.out.print("Invalid ID. Try again: ");
    userId = in.nextInt();
  }
  /** if the user enters an ID within the range 0-9, bring up the main menu screen **/
  while (userId >= 0 && userId < 10) {
    System.out.println("\nMain menu");
    System.out.println("1: check balance");
    System.out.println("2: withdraw");
    System.out.println("3: deposit");
    System.out.println("4: exit");

    System.out.print("Enter a choice: ");
    int selection = in.nextInt();

    /** if the user enters a value outside the range of the main menu options, prompt them to enter again **/
    while (selection < 1 || selection > 4){
      System.out.print("Invalid menu selection. Try again: ");
      selection = in.nextInt();
    }
    /** if the user chooses 4 to exit, prompt again from the ID selection menu **/
    if (selection == 4) {
      System.out.print("Enter an id: ");
      userId = in.nextInt();
      while (userId < 0 || userId > 9) {
        System.out.print("Invalid ID. Try again: ");
        userId = in.nextInt();
      }
    }
    /** call method using userID, selection, and users as parameters **/
    userSelection(userId, selection, users);
  }
}


public static void userSelection(int id_, int selection_, Account[] users){
  /** create a new instance of Scanner called 'in' **/
  Scanner in = new Scanner(System.in);
  switch (selection_){
    case 1:
      /** use the Accessor method from the Account class to retrieve balance for user **/
      System.out.println("The balance is $" + String.format("%.2f", users[id_].getBalance()));
      break;
    case 2:
      System.out.print("Enter the amount to withdraw:  ");
      /** use the Mutator method from the Account class to withdraw money **/
      double amountWithdrawn = in.nextDouble();
      users[id_].withdraw(amountWithdrawn);
      break;
    case 3:
      System.out.print("Enter the amount to deposit:  ");
      /** use the Mutator method from the Account class to deposit money **/
      double amountDeposited = in.nextDouble();
      users[id_].deposit(amountDeposited);
      break;
    default:
      break;
  }
}
}