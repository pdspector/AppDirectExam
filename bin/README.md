# Customer Applications Argentina - Java Framewor Zalenium 

## Instructions to be executed in host (to be validated)

1. Download the chromedriver.exe, the geckodriver.exe and the IEDriverServer.exe and place them into your root folder
1. Add the drivers to your Environment Variable _PATH_
2. Search for the file config.txt in the .jar, copy and paste its content into a java file named FileWriter.java on your src/main/java folder
3. Configure the paths in your new java class and have in mind that for windows \\ are needed and for linux / will do the trick
4. Once you have configured the paths to your project inside the FileWriter.java, execute the file by making a right click, then choosing Run As, then Java 

## Instructions to be executed in Docker

### Prerequist
* You must have installed docker (of course)
* You must have running zalenium grid in docker. 
  * You have to check what is the zalenium grid url to put it into the step 4 
  * To search that `docker inspect zalenium | grep "IPAddress"`  
### Steps
1. Clone the project `git clone https://github.eagleview.com/pablo-spector/CAA_Automation_Java_Framework_Zalenium.git` 
2. Enter to root folder `cd CAA_Automation_Java_Framework_Zalenium` 
3. Build the app `docker build -t test_caa:latest .`
4. Run the app `docker run -it --rm arg_zelenium_host={ip_of_your_zalenium_grid}`


## Application

This will create the files config.local.properties which you need to configure, testng.xml which you need also to configure and the folder Tests where your BaseTest is going to be located together with all your tests, also, the folder Pages where your BasePage is going to be located together with all your pages and finally the folder Utils, where your TestListener and Retry file are going to be located.

Config your testng.xml file, so instead of having this line
`<listener class-name="utils.TestListener"/>`
change your package to whatever folder you decided to place your TestListener if needed

In the TestListener.java import the BaseTest class from the folder you have decided to create it, do the same for the Retry.java file and make sure to have the right package above both of your files

If you want to your TestRails API you can by creating a new Java class in your src/main/java folder, name it TestRailsWriter.java and look for the file testRailIntegration.txt file and copy paste the content into your TestRailWriter.java file.

Configure the paths in your TestRailWriter.java file and right click on the file, then choose run as, then Java Application. This will create the API files and it will overwrite the TestListener.java file to add the Test Rails Integration. You may need to re-import the BaseTest file in the TestListener.java file.

To run your tests, run testng.xml from your IDE or execute "mvn test -DsuiteXmlFile=testng.xml" command
  
