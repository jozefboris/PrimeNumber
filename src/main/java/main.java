import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the path to the xlsx file:");
        String name = reader.readLine();

        while (name.equals("")) {
            name = reader.readLine();
        }

        PrimeNumberReader primeNumberReader = new PrimeNumberReader();
        try {
            primeNumberReader.readerXLSX(name.trim());
        } catch (Exception e) {
            System.out.println("The file was not found.");
        }
    }
}
