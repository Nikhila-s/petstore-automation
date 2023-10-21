package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;


import java.io.File;

class ExtentReporterFactory {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports createReportInstance() {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("." + File.separator + "reports" + File.separator + "extent2.html");
//        htmlReporter.config().setTestViewChartLocation(BOTTOM);
//      htmlReporter.config()).setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("reports");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

}
