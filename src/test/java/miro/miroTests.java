package miro;

import miro.Miro;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class miroTests {

    @Test(priority = 0)
    public void verifyShareBoardBetweenTwoUsers() throws IOException, InterruptedException {
        Miro miro = new Miro();
        //create board for User One using Token
        String boardname = miro.board.createBoard();

        //Share board with user Two
        miro.board.shareBoard();
        miro.openMiroApplication();
        WebDriver driver = miro.getDriver();
        miro.login.assertLoginPage(driver);
        miro.login.loginWithUserOne();
        miro.dashboard.assertDashboard(driver);
        miro.dashboard.openSharedBoard(boardname);
        miro.canvas.addSticker(driver);
        miro.utils.captureUserOneboardscreenshot(driver);
        miro.dashboard.signOut();
        //Second User Validations
        miro.login.loginWithUserTwo();
        miro.dashboard.openSharedBoard(boardname);
        Thread.sleep(10000);
        miro.utils.captureUserTwoboardscreenshot(driver);
        driver.quit();
        miro.board.deleteBoard();
        miro.utils.compareBothDashBoardsAreSame(driver);
    }

}
