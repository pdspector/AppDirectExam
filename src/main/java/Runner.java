import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.TestNG;


import utils.Config;

public class Runner {

    public static void main(String[] args) {
        List<String> file = new ArrayList<String>();
        file.add(System.getProperty("user.dir")+"/src/resources/testng/testng.xml");
        TestNG testNG = new TestNG();
        testNG.setTestSuites(file);
        testNG.run();
        
    	final String username = "pablo.spector@eagleview.com";
        final String password = "Zante70458610.";

        Properties props = new Properties();        
        props.put("mail.smtp.host", "smtp.office365.com"); 
        props.put("mail.smtp.auth", true); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.starttls.enable", true); 
        props.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pablo.spector@eagleview.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("pablo.spector@eagleview.com"));
            message.setSubject("Connect Admin Report");
            message.setText("PFA");
            String cadena = Config.getGridHubAddress();
            int cantidad= 7;
            int m = Math.max(0, cadena.length() - cantidad); 

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file2 = "/selenium/test/caa/src/resources/reports/ExtentReportResults.html";
            String fileName = "ConnectAdminAppTest.html";
            DataSource source = new FileDataSource(file2);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            messageBodyPart2.setContent("<a href=\"http://localhost:4444/dashboard/\">See the Zalenium Dashboard</a>", "text/html");
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messageBodyPart2);


            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
      }
    

    }

