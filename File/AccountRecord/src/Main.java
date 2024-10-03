public class Main {
    public static void main(String[] args) {
        // Create an instance of AccountRecord

        // Create an instance of CreateTextFile
        CreateTextFile createTextFile = new CreateTextFile();

        // Open the file
        createTextFile.openFile();

        // Add records to the file
        createTextFile.addRecords();

        // Close the file
        createTextFile.closeFile();
    }
}
