package miro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import static miro.objects.BoardObjects.*;

public class BoardPage {

    public void addSticker(WebDriver driver) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreToolsElement));
        driver.findElement(moreToolsElement).click();
        WebDriverWait otherwait = new WebDriverWait(driver, Duration.ofSeconds(30));
        otherwait.until(ExpectedConditions.visibilityOfElementLocated(inputAppsElement));
        driver.findElement(inputAppsElement).sendKeys("Stickers");
        otherwait.until(ExpectedConditions.visibilityOfElementLocated(stickerEmojiToolbar));
        driver.findElement(stickerEmojiToolbar).click();

        otherwait.until(ExpectedConditions.visibilityOfElementLocated(selectStickerTab));
        driver.findElement(selectStickerTab).click();

        otherwait.until(ExpectedConditions.visibilityOfElementLocated(inputSticker));
        driver.findElement(inputSticker).sendKeys("100");
        Thread.sleep(5000);
        otherwait.until(ExpectedConditions.visibilityOfElementLocated(firstSticker));
        driver.findElement(firstSticker).click();

        Actions actions = new Actions(driver);
        WebElement object1 = driver.findElement(firstSticker);
        WebElement canvas = driver.findElement(canvasElement);
        actions.dragAndDrop(object1, canvas);
        actions.build().perform();
        Thread.sleep(5000);
        driver.findElement(closeStickersToolBar).click();
    }
}
