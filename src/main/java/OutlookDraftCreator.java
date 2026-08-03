import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutlookDraftCreator {

    public static void createDraftEmail(
            String toEmail,
            String subject,
            String body,
            String attachmentPath
    ) {
        try {
            File attachment = new File(attachmentPath);

            if (!attachment.exists()) {
                System.out.println("Attachment not found: " + attachmentPath);
                return;
            }

            File script = File.createTempFile("create_outlook_draft", ".ps1");

            try (FileWriter writer = new FileWriter(script)) {
                writer.write("$outlook = New-Object -ComObject Outlook.Application\n");
                writer.write("$mail = $outlook.CreateItem(0)\n");
                writer.write("$mail.To = \"" + escapePowerShell(toEmail) + "\"\n");
                writer.write("$mail.Subject = \"" + escapePowerShell(subject) + "\"\n");
                writer.write("$mail.Body = \"" + escapePowerShell(body) + "\"\n");
                writer.write("$mail.Attachments.Add(\"" + escapePowerShell(attachment.getAbsolutePath()) + "\")\n");
                writer.write("$mail.Display()\n");
            }

            ProcessBuilder processBuilder = new ProcessBuilder(
                    "powershell.exe",
                    "-ExecutionPolicy",
                    "Bypass",
                    "-File",
                    script.getAbsolutePath()
            );

            processBuilder.start();

            System.out.println("Outlook draft created for: " + toEmail);

        } catch (IOException e) {
            System.out.println("Error creating Outlook draft: " + e.getMessage());
        }
    }

    private static String escapePowerShell(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "`\"");
    }
}