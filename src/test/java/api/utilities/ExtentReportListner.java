package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtentReportListner implements ITestListener {
    ExtentReports reporter;

    public void onTestStart(ITestResult iTestResult) {

        Reporter.log("==================On Test Start ========================",true);

        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        ExtentReportManager.setExtentTest(reporter.createTest(iTestResult.getMethod().getMethodName(),
                iTestResult.getMethod().getDescription()));

        Reporter.log("Executing Method is: --------------"+iTestResult.getMethod().getMethodName()+"---------------",true);

        Reporter.log("This is created Reporter: "+ ExtentReportManager.getReporter().toString(),true);
        Reporter.log("This is created Test: "+ ExtentReportManager.getExtentTest().toString(),true);

        Reporter.log("==================Test End ========================",true);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("==================On Test Success ========================",true);


        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        ExtentReportManager.getExtentTest().pass("Test Passed");
        ExtentReportManager.getExtentTest().log(Status.PASS,"Test Case passed");
        Reporter.log("This is created Reporter: "+ ExtentReportManager.getReporter().toString(),true);
        Reporter.log("This is created Test: "+ ExtentReportManager.getExtentTest().toString(),true);
        Reporter.log("==================On Test Success End ========================",true);

    }

    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("==================On Test Failure ========================",true);


        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        Reporter.log("This is created Test: "+ ExtentReportManager.getExtentTest().toString(),true);
        ExtentReportManager.getExtentTest().fail("Test Failed");
        ExtentReportManager.getExtentTest().log(Status.FAIL,"Test Case failed");
        Reporter.log("==================On Test Failure End ========================",true);

    }

    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("==================On Test Skipped ========================",true);
        ExtentReportManager.setExtentTest(reporter.createTest(iTestResult.getMethod().getMethodName(),
                iTestResult.getMethod().getDescription()));

        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        ExtentReportManager.getExtentTest().skip("Test Skiped");
        ExtentReportManager.getExtentTest().log(Status.SKIP,"Test Case Skiped");

        Reporter.log("This is created Reporter: "+ ExtentReportManager.getReporter().toString(),true);
        Reporter.log("This is created Test: "+ ExtentReportManager.getExtentTest().toString(),true);
        Reporter.log("==================On Test Skipped End ========================",true);


    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        Reporter.log("==================On Start ========================",true);


        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        reporter = ExtentReporterFactory.createReportInstance();
        ExtentReportManager.setReporter(reporter);

        Reporter.log("This is created Reporter: "+ ExtentReportManager.getReporter().toString(),true);
        Reporter.log("==================On Start End ========================",true);

    }

    public void onFinish(ITestContext iTestContext) {
        Reporter.log("==================On Finish ========================",true);


        Reporter.log("Thread Id: "+ Thread.currentThread().getId(),true);
        Reporter.log("Thread Name: "+ Thread.currentThread().getName(),true);

        ExtentReportManager.getReporter().flush();
        ExtentReportManager.removeReporter();
        Reporter.log("==================On Finish End==============",true);

    }
}
