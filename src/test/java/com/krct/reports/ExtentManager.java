package com.krct.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
            reporter.config().setReportName("DemoBlaze Automation Report");
            reporter.config().setDocumentTitle("Automation Results");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}