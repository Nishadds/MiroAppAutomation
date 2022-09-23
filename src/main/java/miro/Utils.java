package miro;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static miro.objects.LoginPageObjects.*;


public class Utils {
    String userOneBoard="useronescreenshot";
    String userTwoReceivedBoard="usertwoscreenshot";
    String imagepath = "src/test/java/Images/";
    public boolean captureUserOneboardscreenshot(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
        WebElement canvaselem = driver.findElement(canvas);
        Shutterbug.shootElement(driver, canvaselem).withName(userOneBoard).save("src/test/java/Images/");
        return true;
    }

    public void captureUserTwoboardscreenshot(WebDriver driver) throws IOException {
//        File image = new File(imagepath+"useronescreenshot.png");
//        BufferedImage expectedImage = ImageIO.read(image);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(canvas));
        WebElement canvaselem = driver.findElement(canvas);
        Shutterbug.shootElement(driver, canvaselem).withName(userTwoReceivedBoard).save("src/test/java/Images/");
    }

    public void compareBothDashBoardsAreSame(WebDriver driver) throws IOException {
        userOneBoard = imagepath+userOneBoard+".png";
        userTwoReceivedBoard = imagepath+userTwoReceivedBoard+".png";

//        Shutterbug.shootPage(driver).equalsWithDiff(userOneBoard,userTwoReceivedBoard,0.9);
//        Shutterbug.shootPage(driver).equalsWithDiff(userTwoReceivedBoard,userTwoReceivedBoard);

    }

}
