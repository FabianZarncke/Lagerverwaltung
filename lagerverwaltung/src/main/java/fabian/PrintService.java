package fabian;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/* unsuded imports
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
*/


public class PrintService {
    
    static String PathPDF ="C:\\Users\\Fabian\\Desktop\\";
    public static void createPDF(Rental rental) throws IOException{
        PDDocument document = new PDDocument();
        
        String PatheFile = PathPDF + rental.getId()+".pdf";

        PDPage Page = new PDPage();

        document.addPage(Page);
        

        //Text

        PDPageContentStream contentStream = new PDPageContentStream(document, Page);

        contentStream.beginText(); 

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);




        

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String RentalDate = "";    
        RentalDate = formatter.format(rental.getDate());

        String DateNow ="";
        Date test = new Date();

        DateNow = formatter.format(test);

        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(400, 725);
        contentStream.newLine();
        contentStream.showText(DateNow);

        contentStream.setFont(PDType1Font.TIMES_BOLD, 18);
        contentStream.newLine();
        contentStream.newLine();
        
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(-375, 0);
        
        contentStream.showText("Vermietung [ " + RentalDate + " ]: "+rental.getId());  
        
        contentStream.newLine();
        contentStream.newLine();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        if(rental.getCustomer().getClass().getSimpleName().equals("PrivateCustomer")){
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.showText("PrivatKunde:");
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLine();
            contentStream.showText( rental.getCustomer().getFirstname() + " " + rental.getCustomer().getLastname() + " | " + rental.getCustomer().getEmailaddress() + " | " +rental.getCustomer().getPhonenumber());
        }
        else{
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.showText("Geschäftskunde:");
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLine();
            contentStream.showText(rental.getCustomer().getFirstname() + " " + rental.getCustomer().getLastname() + " | " + rental.getCustomer().getEmailaddress() + " | " +rental.getCustomer().getPhonenumber());
        }

        
        contentStream.newLine();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
        contentStream.newLine();
        contentStream.showText("Techniker:");
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        for(Technician technician : rental.getTechnicians()){
            contentStream.newLine();  
            contentStream.showText(technician.getFirstname() +" " + technician.getLastname()); 
        }

        contentStream.newLine();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
        contentStream.newLine();
        contentStream.showText("Technikteile:"); 
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        for(Technology technology: rental.getTechnologies()){
            contentStream.newLine();
            contentStream.showText(technology.getName() + " | " + technology.getPrice()+ " | " + technology.getDescription()); 
        }


        contentStream.setNonStrokingColor(Color.RED);
        contentStream.newLine();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
        

        contentStream.newLine();
        contentStream.showText("Rabatt: "+rental.getDiscount() + "%");

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.setNonStrokingColor(Color.BLACK);


        DecimalFormat f = new DecimalFormat("#0.00");

        contentStream.newLine();
        contentStream.setFont(PDType1Font.TIMES_BOLD, 15);
        contentStream.newLine();
        contentStream.showText("Preis: " + f.format(rental.calcPrice()) +"€");

        contentStream.endText();
        contentStream.close();
        document.save(PathPDF + rental.getId()+".pdf");
        document.close();
        //End

        File file = new File(PatheFile);
        PDDocument.load(file);
    }
    

}
