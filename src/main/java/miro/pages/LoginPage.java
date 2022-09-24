package miro.pages;
import static miro.objects.LoginPageObjects.*;
import static miro.objects.DashBoardObjects.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    public void  assertLoginPage(WebDriver driverinstance){
        driver = driverinstance;
        Assert.assertFalse(driver.findElements(UserName).isEmpty());
    }

    private void loginWithCredentials(String name){
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys(name);

        driver.findElement(Password).sendKeys(pwd);
        driver.findElement(SigninBtn).click();
        //assert login successful
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createDashboard));
    }

    public void loginWithUserOne(){
        loginWithCredentials(name);
    }

    public void loginWithUserTwo(){
        loginWithCredentials(seconduser);

    }
}
