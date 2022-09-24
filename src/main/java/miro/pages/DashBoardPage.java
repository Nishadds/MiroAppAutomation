package miro.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import static miro.objects.DashBoardObjects.*;
import static miro.objects.LoginPageObjects.*;
import static miro.objects.LoginPageObjects.UserName;

public class DashBoardPage {
    WebDriver driver;
    public void assertDashboard(WebDriver _driver){
        driver = _driver;
        String teamName = driver.findElement(teamNameTitle).getText();
        //validating team should be Testing Team.
        Assert.assertEquals(teamName,"Testing team");
    }

    //Opens board from Dash board using board name.
    public void openSharedBoard(String boardname) throws InterruptedException {
        //assert login successful
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getboardElement(boardname)));
        driver.findElement(getboardElement(boardname)).click();
        Thread.sleep(10000);
    }

    public void signOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //click on home page
        driver.findElement(homeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(createDashboard));

        //Signout
        driver.findElement(openProfile).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOut));
        driver.findElement(signOut).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        driver.findElement(UserName).click();

    }

    public void verifyBoardIsSame(String boardID){
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains(boardID));
    }
}
