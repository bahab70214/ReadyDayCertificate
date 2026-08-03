import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Student> readStudentsFromCsv(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line: name,email
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Student student = parseStudent(line);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return students;
    }

    private static Student parseStudent(String line) {
        String[] parts = line.split(",");

        String name = parts[0].trim();
        String email = parts[1].trim();

        return new Student(name, email);
    }
}