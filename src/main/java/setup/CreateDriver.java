package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by bicky on 4/10/2018.
 */
public class CreateDriver {
    private static WebDriver webDriver=null;
    private CreateDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bicky\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    public static WebDriver getDriver(){
        if (webDriver==null){
            new CreateDriver();

        }
        return webDriver;

    }

}
