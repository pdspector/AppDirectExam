# APP Direct Exam

## Instructions to be executed

### Prerequisite
* You must have Java and Maven installed

### Steps
1. Clone the project `git clone https://github.com/pdspector/AppDirectExam` 
2. Enter to root folder `cd CAA_Automation_Java_Framework_Zalenium`
3. Modify the paths to match your local machine in src/resources/properties/config.apptest.properties 
4. Run `mvn -DbuildDirectory=config.apptest.properties clean compile assembly:single` to compile the project into a single .jar file
5. Run the app `java -jar ./target/Selenium-0.0.1-jar-with-dependencies.jar`

  
