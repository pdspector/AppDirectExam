package utils;


import com.relevantcodes.extentreports.ExtentReports;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager extends Config{
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(System.getProperty("user.dir")+"/src/resources/reports/ExtentReportResults.html", true);
        }
        return extent;
    }
}
