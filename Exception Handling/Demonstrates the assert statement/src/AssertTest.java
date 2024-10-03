	// Fig. 13.9: AssertTest.java
    // Demonstrates the assert statement
    import java.util.Scanner;
public class AssertTest
{
    public static void main( String args[] )
    {
        Scanner input = new Scanner( System.in );
        System.out.print( "Enter a number between 0 and 10: " );
        int number = input.nextInt();
        // assert that the absolute value is >= 0
        assert ( number >= 0 && number <= 10 ) : "bad number: " + number;
        System.out.printf( "You entered %d\n", number );
    } // end main
} // end class AssertTest

//        Enter a number between 0 and 10: 5
//        You entered 5
//
//
//
//        Enter a number between 0 and 10: 50
//        Exception in thread "main" java.lang.AssertionError: bad number: 50
//        at AssertTest.main(AssertTest.java:15)
