import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class CertificateGenerator {

    public static void generateCertificate(String studentName, String outputPath, String logoPath) {
        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                float pageWidth = page.getMediaBox().getWidth();
                float pageHeight = page.getMediaBox().getHeight();

                // Outer border
                contentStream.setLineWidth(3);
                contentStream.addRect(40, 40, pageWidth - 80, pageHeight - 80);
                contentStream.stroke();

                // Inner border
                contentStream.setLineWidth(1);
                contentStream.addRect(55, 55, pageWidth - 110, pageHeight - 110);
                contentStream.stroke();

                // Logo
                File logoFile = new File(logoPath);
                if (logoFile.exists()) {
                    PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);

                    float logoWidth = 300;
                    float logoHeight = 90;
                    float logoX = (pageWidth - logoWidth) / 2;
                    float logoY = pageHeight - 170;

                    contentStream.drawImage(logo, logoX, logoY, logoWidth, logoHeight);
                }

                PDType1Font titleFont = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD);
                PDType1Font regularFont = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
                PDType1Font italicFont = new PDType1Font(Standard14Fonts.FontName.TIMES_ITALIC);

                writeCenteredText(contentStream, "Certificate of Completion",
                        pageWidth, pageHeight - 230, 30, titleFont);

                writeCenteredText(contentStream, "This certificate is proudly presented to",
                        pageWidth, pageHeight - 290, 16, regularFont);

                writeCenteredText(contentStream, studentName,
                        pageWidth, pageHeight - 345, 30, titleFont);

                writeCenteredText(contentStream, "for successfully completing the",
                        pageWidth, pageHeight - 405, 16, regularFont);

                writeCenteredText(contentStream, "READY Day Git and GitHub Workshop",
                        pageWidth, pageHeight - 435, 20, titleFont);

                writeCenteredText(contentStream, "Using Git and GitHub to Showcase Your Work",
                        pageWidth, pageHeight - 490, 14, italicFont);

                writeText(contentStream, "Date: ____________________",
                        90, 120, 14, regularFont);

                writeText(contentStream, "Presenter: ____________________",
                        pageWidth - 280, 120, 14, regularFont);
            }

            document.save(outputPath);
            System.out.println("Certificate created: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error creating certificate: " + e.getMessage());
        }
    }

    private static void writeCenteredText(
            PDPageContentStream contentStream,
            String text,
            float pageWidth,
            float y,
            int fontSize,
            PDType1Font font
    ) throws IOException {

        float textWidth = font.getStringWidth(text) / 1000 * fontSize;
        float x = (pageWidth - textWidth) / 2;

        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }

    private static void writeText(
            PDPageContentStream contentStream,
            String text,
            float x,
            float y,
            int fontSize,
            PDType1Font font
    ) throws IOException {

        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }
}