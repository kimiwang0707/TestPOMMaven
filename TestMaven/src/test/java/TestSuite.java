import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;

public class TestSuite {

    @BeforeTest
    public void loginToSystem(){
        System.out.println("Test begins from here:");

        LoginPage login = new LoginPage();
        login.loginSteps();

    }

    @Test(priority = 2)
    public void AddNDeleteUser(){
        AddAndDeletePage addNewUser = new AddAndDeletePage(Global.driver);
        addNewUser.addNDeleteUser();
        System.out.println("Test 001");

    }

    @Test(priority = 1)
    public void GetCurrentPath(){
        System.out.println("Test 002");
        Path currentPath = Paths.get("");
        String s = currentPath.toAbsolutePath().toString();
        System.out.println("Current path is:" + s);
    }

    @AfterTest
    public void FinishTest(){
        Global.driver.close();
        Global.driver.quit();
        System.out.println("Test finished here.");
    }


}
