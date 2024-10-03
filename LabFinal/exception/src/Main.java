public class Main {
    public static void main(String[] args) throws Exception {
        try{
            throw new Exception();
        }
        finally {
            System.out.println("Hello world!");
        }

    }
}