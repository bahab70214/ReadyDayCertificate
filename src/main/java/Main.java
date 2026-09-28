import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Student> students = CsvReader.readStudentsFromCsv("data/students.csv");

        for (Student student : students) {
            System.out.println(student);
            String studentFirstName = student.getFirstName();
            String studentLastName = student.getLastName();
            String studentEmail = student.getEmail();
            String certificatePath = "output/"+ studentFirstName+"_"+ studentLastName+"_Certificate.pdf";

         

         OutlookDraftCreator.createDraftEmail(
                studentEmail,
                "READY Day Git/GitHub Workshop Certificate",
                "Congratulations " + studentFirstName+" "+ studentLastName + "!\n\n" +
                        "Attached is your certificate for completing the READY Day Git and GitHub Workshop.\n\n" +
                        "Best,\n" +
                        "Semih",
                certificatePath
        );
       

        }
        

        

        

       
       
    }
}