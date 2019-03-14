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
     
    }
}

