package jdbcDemo;
import java.io.File;
import java.util.Scanner;

public class Slip14B {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Enter the file extension (without dot): ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith("." + fileExtension));

        if (files.length == 0) {
            System.out.println("No files found with the given extension in the directory.");
        } else {
            System.out.println("Files with ." + fileExtension + " extension in the directory:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}