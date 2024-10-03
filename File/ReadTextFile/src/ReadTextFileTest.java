	// Fig. 14.12: ReadTextFileTest.java
    // This program test class ReadTextFile.
    public class ReadTextFileTest
    {
        public static void main( String args[] )
        {
            ReadTextFile application = new ReadTextFile();
            application.openFile();
            application.readRecords();
            application.closeFile();
        } // end main
    } // end class ReadTextFileTest

//        Account   First Name  Last Name      Balance
//        100       Bob         Jones            24.98
//        200       Steve       Doe            -345.67
//        300       Pam         White             0.00
//        400       Sam         Stone           -42.16
//        500       Sue         Rich            224.62
//