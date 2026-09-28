import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * TEAM TASK: CSV Reader
 *
 * Your team is responsible for reading student data from a CSV file.
 *
 * The CSV file has this format:
 *
 * name,email
 * Alice Johnson,alice.johnson@example.com
 * Brian Smith,brian.smith@example.com
 *
 * Your goal:
 * 1. Open and read the CSV file.
 * 2. Skip the first line because it is the header.
 * 3. Read each remaining line.
 * 4. Convert each line into a Student object.
 * 5. Add each Student object to a list.
 * 6. Return the list of students.
 *
 * Helpful Java classes:
 * - BufferedReader: reads a text file line by line
 * - FileReader: opens the file
 * - ArrayList: stores the Student objects
 * - List: return type for a collection of students
 *
 * Helpful methods:
 * - reader.readLine(): reads one line from the file
 * - line.split(","): separates name and email
 * - name.split(" "): separates first name and last name
 * - trim(): removes extra spaces
 *
 * Important:
 * - Do not read the header as a student.
 * - Make sure the file closes properly.
 * - Use try-with-resources for BufferedReader.
 * - Return an empty list if the file cannot be read.
 */

public class CsvReader {

    /*
     * Method: readStudentsFromCsv
     *
     * Input:
     * - filePath: the path to the CSV file, for example "data/students.csv"
     *
     * Output:
     * - A List<Student> containing all students from the CSV file
     *
     * Steps:
     * 1. Create an empty List<Student>.
     * 2. Open the CSV file using BufferedReader and FileReader.
     * 3. Skip the first line because it contains column names.
     * 4. Use a while loop to read each remaining line.
     * 5. For each line, call parseStudent(line).
     * 6. Add the returned Student object to the list.
     * 7. Return the list.
     */
    public static List<Student> readStudentsFromCsv(String filePath) {
        // TODO: Create an empty list of Student objects.
List<Student> students = new ArrayList<>();
        // TODO: Open the CSV file using BufferedReader and FileReader.

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // TODO: Skip the header line.
            br.readLine(); // Skip the first line (header)
            // TODO: Read each line using a while loop.
            String line;
            while ((line = br.readLine()) != null) {
                // TODO: Convert each line into a Student object using parseStudent(line).
                Student student = parseStudent(line);
                // TODO: Add each Student object to the list.
                students.add(student);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        // TODO: Return the list of students.
        return students;
    }

    /*
     * Helper Method: parseStudent
     *
     * Input:
     * - line: one row from the CSV file.
     *
     * Example input:
     * "Alice Johnson,alice.johnson@example.com"
     *
     * Expected output:
     * new Student("Alice", "Johnson", "alice.johnson@example.com")
     *
     * Steps:
     * 1. Split the line by comma.
     * 2. The first part is the full name.
     * 3. The second part is the email.
     * 4. Split the full name by space.
     * 5. The first name is the first part of the name.
     * 6. The last name is the second part of the name.
     * 7. Return a new Student object.
     *
     * Helpful methods:
     * - line.split(",")
     * - name.split(" ")
     * - trim()
     */
    private static Student parseStudent(String line) {
        // TODO: Split the line by comma.
        String[] parts = line.split(",");
        // TODO: Store the full name.
        String fullName = parts[0].trim();

        // TODO: Store the email.
        String email = parts[1].trim();

        // TODO: Split the full name into first name and last name.
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0].trim();
        String lastName = nameParts[1].trim();
        Student student = new Student(firstName, lastName, email);  
        // TODO: Create and return a new Student object.
        return student;
    }
}