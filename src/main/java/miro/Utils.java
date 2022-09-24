package miro;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import static miro.objects.LoginPageObjects.*;

public class Utils {
    String userOneBoard="useronescreenshot";
    String userTwoReceivedBoard="usertwoscreenshot";

    /*Image comparision functions implemented in case needed*/
    public void captureScreenshotWithoutSticker(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
        WebElement canvaselem = driver.findElement(canvas);
        Shutterbug.shootElement(driver, canvaselem).withName(userOneBoard).save("src/test/java/Images/");
    }

    public void captureScreenshotWithSticker(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
        WebElement canvaselem = driver.findElement(canvas);
        Shutterbug.shootElement(driver, canvaselem).withName(userTwoReceivedBoard).save("src/test/java/Images/");
    }

    public void compareScreenshots(WebDriver driver) throws IOException {
        String root = System.getProperty("user.dir");
        userOneBoard = root + "/src/test/java/Images/useronescreenshot.png";
        userTwoReceivedBoard = root + "/src/test/java/Images/usertwoscreenshot.png";
        boolean isSame = Shutterbug.shootPage(driver).equalsWithDiff(userOneBoard,userTwoReceivedBoard,0);
        if(isSame){
            //images should not be equal since we added the stickers.
            Assert.fail();
        }
    }

}
