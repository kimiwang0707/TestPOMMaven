import com.google.errorprone.annotations.Var;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class AddAndDeletePage {

    public AddAndDeletePage(WebDriver driver){
        PageFactory.initElements(Global.driver, this);
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement btnAdmin;

    @FindBy(id = "btnAdd")
    WebElement btnAdd;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    WebElement systemUser;

    @FindBy(id = "systemUser_password")
    WebElement systemPassword;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "btnSave")
    WebElement btnSave;

    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUsername;

    @FindBy(id = "searchBtn")
    WebElement btnSearch;

    @FindBy(id = "btnDelete")
    WebElement btnDelete;

    @FindBy(id = "dialogDeleteBtn")
    WebElement btnDeleteConfirm;


    public String returnBtnAdmin(){
        return btnAdmin.getAttribute("id");
    }

    public String returnBtnAdd(){
        return btnAdd.getAttribute("id");
    }

    public String returnEmployeeName(){
        return employeeName.getAttribute("id");
    }

    public String returnBtnSave(){
        return btnSave.getAttribute("id");
    }

    public String returnSearchUsername(){
        return searchUsername.getAttribute("id");
    }

    public String returnBtnSearch(){
        return btnSearch.getAttribute("id");
    }

    public String returnBtnDelete(){
        return btnDelete.getAttribute("id");
    }



    public void addNDeleteUser(){
        //Click on Admin button
        Global.waitForElementClickable(Global.driver, "id", returnBtnAdmin(), 10);
        btnAdmin.click();

        //Click on Add button
        Global.waitForElementClickable(Global.driver, "id", returnBtnAdd(), 10);
        btnAdd.click();

        //Input user details
        String username = "taytay022";
        String password = "admin123";

        Global.waitForElementClickable(Global.driver,"id", returnBtnSave(), 10);
        Global.waitForElementClickable(Global.driver,"id", returnEmployeeName(), 10);
        Select roles = new Select(userRole);
        roles.selectByVisibleText("Admin");
        employeeName.sendKeys("John Smith");
        employeeName.sendKeys(Keys.ENTER);
        systemUser.sendKeys(username);
        systemPassword.sendKeys(password);
        confirmPassword.sendKeys(password);

        //Save the user
        Global.waitForElementClickable(Global.driver,"id", returnBtnSave(), 10);
        btnSave.click();

        //Search new added user
        Global.waitForElementPresent(Global.driver,"id", "btnAdd",10);
        Global.waitForElementClickable(Global.driver,"id", returnBtnSearch(), 10);
        Global.waitForElementClickable(Global.driver,"id", returnSearchUsername(), 10);
        searchUsername.sendKeys(username);
        btnSearch.click();

        //Select the new added user
        Global.waitForElementPresent(Global.driver,"xpath", "//a[contains(text(), '" + username+ "')]",10);
        Global.driver.findElement(By.xpath("(//input[@name='chkSelectRow[]'])[last()]")).click();

        //Delete the user
        btnDelete.click();


        //Confirm deletion
        Global.waitForElementClickable(Global.driver,"id",returnBtnDelete(), 10);
        btnDeleteConfirm.click();

    }


}
