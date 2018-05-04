import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
        /** create a new instance of Scanner called 'in '**/
    Scanner in  = new Scanner(System.in);
        /** prompt instructions on to the screen **/
    System.out.println("This program will return the location of the largest element in a \n" +
      "two-dimensional array entered by the user. So if the user enters: \n" +
      "\t23.5\t35\t2\t10\n \t4.5\t3\t45\t3.5\n \t35\t44\t5.5\t9.6\n" +
      "It will output:\n The location of the largest element, 45, is at (row: 1, column: 2).\n\n");
        /** print to the screen a prompt for the user **/
    System.out.print("Enter the number of the rows and columns in the array \n " +
      "(e.g. If here are 3 rows and 4 columns, write 3 4): ");
        /** the first number entered becomes row **/
    int row     = in.nextInt();
        /** the second number entered becomes column **/
    int column  = in.nextInt();
        /** create a multi-dimensional array called MaxValue that has as many rows and columns as the user specified **/
    double[][] maxValue = new double[row][column];

        /** here we prompt the user to enter those values for the rows/columns **/
    System.out.println("Enter the array (separate elements in row by space, press enter\n to go to next row - see example above):");
        /** the numbers entered will be for row(s) for the index as it loops **/
    for (int i = 0; i < row; i++){
          /** the second loop will still be dealing with rows, but the subsequent columns for that row index **/
      for (int j = 0; j < column; j++){
            /** we store the values entered in the subsequent index **/
        maxValue[i][j] = in.nextDouble();
      }
        /** goes to the next line soon as we received the right amount of columns **/
      in.nextLine();
    }

        /** create an instance of the Location class that calls the LocateLargest method taking in as a parameter the multi-dimensional array **/
    Location value = Location.locateLargest(maxValue);
        /** this condition checks if the element is an integer or double so that if the element is 45, it returns 45 and not 45.0 **/
    if (value.maxValue == (int)value.maxValue) {
      System.out.println("The location of the largest element, " + (int)value.maxValue + ", is at (row: " + value.row + ", column: " + value.column + ")");
    } else {
      System.out.println("The location of the largest element, " + String.format("%.1f", value.maxValue) + ", is at (row: " + value.row + ", column: " + value.column + ")");
    }
  }
}