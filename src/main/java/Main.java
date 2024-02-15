import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        boolean num = true;
        Database.getDate();
        
        try {
            while (num == true) {

                System.out.println("Chcete přidat nové údaje?");
                String answer = sc.nextLine().toLowerCase().trim();
                switch (answer) {

                    case "ano" -> {
                        System.out.println("Zadejte jméno, příjmení a věk");
                        String name =sc.nextLine();
                        String lastName = sc.nextLine();
                        int age = sc.nextInt();
                        Database.setData(name, lastName, age);
                        sc.nextLine();
                        System.out.println();
                        Database.getDate();
                    }
                    case "ne" -> {
                        num = false;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }










        /*LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));

        File file = new File("textik.txt");
        try (FileWriter writer = new FileWriter("textik.txt")) {
            for (int i = 0; i < 5; i++) {
                System.out.println("zadej text");
                writer.write(sc.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader("textik.txt")) {
            int character;
            while ((character=reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
