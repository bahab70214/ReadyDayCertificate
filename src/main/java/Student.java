 /*
 * TEAM TASK: Student Class
 *
 * Your team is responsible for creating the Student data model.
 *
 * This class represents one student from the CSV file.
 *
 * Each student should have:
 * - first name
 * - last name
 * - email address
 *
 * Example CSV row:
 * Alice Johnson,alice.johnson@example.com
 *
 * After parsing, this should become:
 * first_name = "Alice"
 * last_name = "Johnson"
 * email = "alice.johnson@example.com"
 *
 * Other parts of the project will use this class.
 * For example:
 * - CsvReader will create Student objects.
 * - CertificateGenerator will use the student's name.
 * - Email-related code may use the student's email.
 */

public class Student {

    /*
     * Instance variables:
     *
     * These store the information for one student.
     *
     * TODO:
     * - Create a private String for first name.
     * - Create a private String for last name.
     * - Create a private String for email.
     */

    private String name;

    /*
     * Constructor:
     *
     * The constructor should receive:
     * - first name
     * - last name
     * - email
     *
     * Then it should store those values in the instance variables.
     *
     * Example:
     * Student student = new Student("Alice", "Johnson", "alice.johnson@example.com");
     *
     * TODO:
     * - Add three parameters to the constructor.
     * - Assign each parameter to the correct instance variable.
     */
    public Student() {
        // TODO: Replace this empty constructor with the correct constructor.
    }

    /*
     * Getter method: getFirstName
     *
     * This method should return the student's first name.
     *
     * Example:
     * student.getFirstName() should return "Alice"
     *
     * TODO:
     * - Return the first name variable.
     */
    public String getFirstName() {
        // TODO: Return first name.
        return null;
    }

    /*
     * Getter method: getLastName
     *
     * This method should return the student's last name.
     *
     * Example:
     * student.getLastName() should return "Johnson"
     *
     * TODO:
     * - Return the last name variable.
     */
    public String getLastName() {
        // TODO: Return last name.
        return null;
    }

    /*
     * Getter method: getEmail
     *
     * This method should return the student's email address.
     *
     * Example:
     * student.getEmail() should return "alice.johnson@example.com"
     *
     * TODO:
     * - Return the email variable.
     */
    public String getEmail() {
        // TODO: Return email.
        return null;
    }

    /*
     * toString method:
     *
     * This method controls how a Student object is printed.
     *
     * Example output:
     * Student{name='Alice Johnson', email='alice.johnson@example.com'}
     *
     * This is helpful for testing whether CSV parsing worked correctly.
     *
     * TODO:
     * - Return a String containing the student's full name and email.
     */
    @Override
    public String toString() {
        // TODO: Return a readable String representation of the student. such as name='Emily Davis', email='emily.davis@example.com'
        return null;
    }
}