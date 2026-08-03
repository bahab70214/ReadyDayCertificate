import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = CsvReader.readStudentsFromCsv("data/students.csv");

        for (Student student : students) {
            System.out.println(student);
        }
        String studentName = "Alice Johnson";
        String studentEmail = "alice.johnson@example.com";

        String certificatePath = "output/Alice_Johnson_Certificate.pdf";

        CertificateGenerator.generateCertificate(
                studentName,
                certificatePath,
                "resources/otterbein-logo.png"
        );

        OutlookDraftCreator.createDraftEmail(
                studentEmail,
                "READY Day Git/GitHub Workshop Certificate",
                "Congratulations " + studentName + "!\n\n" +
                        "Attached is your certificate for completing the READY Day Git and GitHub Workshop.\n\n" +
                        "Best,\n" +
                        "Semih",
                certificatePath
        );
        CertificateGenerator.generateCertificate(
                "Alice Johnson",
                "output/Alice_Johnson_Certificate.pdf",
                "resources/otterbein-logo.png"
        );
    }
}