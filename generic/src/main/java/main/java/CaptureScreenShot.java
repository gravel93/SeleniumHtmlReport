package main.java;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenShot extends BrowserDriver {


    public static String captureScreenShot (WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/Test-ScreenShots/"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    public static String generateFileName(ITestResult result){
        Date date = new Date();
        String fileName = result.getName()+ "_" + dateFormat.format(date);
        return fileName;

    }


}