package main.java;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BrowserDriver {

    public static ExtentReports extent;
    public static WebDriver driver = null;


    @BeforeSuite(alwaysRun = true)
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    public String methodName;

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    public static String captureScreenshot(WebDriver driver,String screenshotName) {

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir") + "//Test-ScreenShots//" + screenshotName + ".png";

        File target = new File(dest);
        try {
            FileUtils.copyFile(src,target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dest;

    }

    @BeforeMethod(alwaysRun = true)
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(className + " " + methodName);
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS,methodName,ExtentTestManager.getTest().addScreenCapture((captureScreenshot(driver,"ScreenShoot"))));
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL,methodName,ExtentTestManager.getTest().addScreenCapture((captureScreenshot(driver,"ScreenShoot"))));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL,methodName,ExtentTestManager.getTest().addScreenCapture((captureScreenshot(driver,"ScreenShoot"))));
        }
        driver.quit();
    }

        public WebDriver getLocalDriver(String browserName, String os) {
            if (browserName.equalsIgnoreCase("chrome")) {
                if (os.equalsIgnoreCase("windows")) {
                    System.setProperty("webdriver.chrome.driver", "../generic/driver/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (os.equalsIgnoreCase("mac")) {
                    System.setProperty("webdriver.chrome.driver", "../generic/driver/chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            return driver;
        }

        @AfterMethod(alwaysRun = true)
        public void closeOut() {
            driver.quit();
        }

    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("false") boolean useCloudEnv,@Optional("false") String cloudEnvName,
                      @Optional("windows") String os,@Optional("10") String os_version,@Optional("chrome") String browserName,@Optional("34")
                              String browserVersion,@Optional("https://commondeer.com/") String url) {
        getLocalDriver(browserName,os);
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS); // 20
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS); //35
        driver.get(url);
        driver.manage().window().maximize();
    }
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    public static String generateFileName(ITestResult result){
        Date date = new Date();
        String fileName = result.getName()+ "_" + dateFormat.format(date);
        return fileName;

    }


    public static WebDriver  getDriver()
    {
        return driver;
    }
    /**
     * This method returns the url.
     *
     * @return Returns the string.
     */
    public static String getUrl()
    {
        return driver.getCurrentUrl();
    }

    }

