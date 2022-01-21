import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        //Evoke browser and initiate elements
        /*
        WebDriverManager.chromedriver().setup();
        Global.driver = new ChromeDriver();
        //WebDriver Manger was intercepted by firewall when use the device in office. So replaced it with the traditional webdriver.
         */
        System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
        Global.driver = new EdgeDriver();
        Global.driver.get("https://opensource-demo.orangehrmlive.com/");
        Global.driver.manage().window().maximize();

        PageFactory.initElements(Global.driver, this);
    }

    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    WebElement btnLogin;


    public void loginSteps(){
        //Login
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();
    }

}
