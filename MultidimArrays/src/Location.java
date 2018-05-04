public class Location {
/** initialize three public properties **/
public int row = 0;
public int column = 0;
public double maxValue = 0.0;

  /** method that returns largest element in a two-dimensional array **/
  public static Location locateLargest(double[][] a) {
    /** create an instance of the Class Location **/
    Location spot = new Location();

    /** loop through the length of rows **/
    for (int i = 0; i < a.length; i++) {
      /** loop through the columns of the index of that row **/
      for (int j = 0; j < a[i].length; j++) {
        /** if any given value at the column of the index row is greater than the current maxValue **/
        if (a[i][j] > spot.maxValue) {
          /** then maxValue takes that current value **/
          spot.maxValue = a[i][j];
          /** we note which row this occurred **/
          spot.row = i;
          /** we also note which column this occurred **/
          spot.column = j;
        }
      }
    }
    /** return the object **/
    return spot;
  }
}
