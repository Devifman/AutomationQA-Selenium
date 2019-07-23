package BestPractices;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static BestPractices.BaseTest.LOGGER;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult){
        LOGGER.info("Test Started");
    }
    public void onTestSuccess(ITestResult iTestResult){
        LOGGER.info("Test passed");
    }
    public void onTestFailure(ITestResult iTestResult){
        LOGGER.error("Test Fall!");
    }
    public void onTestSkipped(ITestResult iTestResult){
        LOGGER.info("Test was Skipped");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){
        LOGGER.error("We have some problems");
    }
    public void  onStart(ITestContext iTestContext){
        LOGGER.info("BeginOfTheTest");
    }
    public void onFinish(ITestContext iTestContext){
        LOGGER.info("This test was passed: "+iTestContext.getPassedTests());
        LOGGER.info("This test was Failed: "+iTestContext.getFailedTests());
        LOGGER.info("Finish");
    }
}
