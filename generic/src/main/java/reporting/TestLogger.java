package reporting;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;

public class TestLogger {
    public static void log(final String message){
        Reporter.log(message,true);
        ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }
}
