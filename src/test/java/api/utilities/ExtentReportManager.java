package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

    //private static ExtentReports extentReporter;
    private static InheritableThreadLocal<ExtentReports> extentReporter = new InheritableThreadLocal<ExtentReports>();
    private static InheritableThreadLocal<ExtentTest> extentTest = new InheritableThreadLocal<ExtentTest>();
    public static ExtentReports getReporter(){
        return extentReporter.get();
    }

    public static void setReporter(ExtentReports reporter){
        extentReporter.set(reporter);
    }

    public static void removeReporter(){
        extentReporter.remove();
    }


    public static ExtentTest getExtentTest(){
        return extentTest.get();
    }

    public static void setExtentTest(ExtentTest test){
        extentTest.set(test);
    }

}
