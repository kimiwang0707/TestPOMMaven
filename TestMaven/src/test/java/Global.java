import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Global {

    public static WebDriver driver;

    public static void waitForElementClickable(WebDriver driver, String key, String value, int secs)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
        if (key == "id"){
            wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
        }
        if (key == "name"){
            wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
        }
        if (key == "xpath"){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
        }
        if (key == "cssSelector"){
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
        }
        if (key == "className"){
            wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
        }
        if (key == "linkText"){
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
        }

    }

    public static void waitForElementPresent(WebDriver driver, String key, String value, int secs)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
        if (key == "id"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
        }
        if (key == "name"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
        }
        if (key == "xpath"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
        }
        if (key == "cssSelector"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
        }
        if (key == "className"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
        }
        if (key == "linkText"){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
        }

    }

    public static void forceWait(int secs){
        try {
            Thread.sleep(secs);
        }catch(InterruptedException e){

        }
    }


    public static void implicitWait(int secs){
        Global.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }

}
