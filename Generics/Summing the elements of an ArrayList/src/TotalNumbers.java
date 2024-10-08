	// Fig. 18.14: TotalNumbers.java
    // Summing the elements of an ArrayList.
    import java.util.ArrayList;
public class TotalNumbers
{
    public static void main( String args[] )
    {
        // create, initialize and output ArrayList of Numbers containing
        // both Integers and Doubles, then display total of the elements
        Number[] numbers = { 1, 2.4, 3, 4.1 }; // Integers and Doubles
        ArrayList< Number > numberList = new ArrayList< Number >();
        for ( Number element : numbers )
            numberList.add( element ); // place each number in numberList
        System.out.printf( "numberList contains: %s\n", numberList );
        System.out.printf( "Total of the elements in numberList: %.1f\n",
                sum( numberList ) );
    } // end main
    // calculate total of ArrayList elements
    public static double sum( ArrayList< Number > list )
    {
        double total = 0; // initialize total
        // calculate sum
        for ( Number element : list )
            total += element.doubleValue();
        return total;
    } // end method sum
} // end class TotalNumbers