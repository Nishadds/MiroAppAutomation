package miro;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class miroTests {

    @Test(priority = 0)
    public void verifyShareBoardBetweenTwoUsers() throws IOException, InterruptedException {
        Miro miro = new Miro();
        miro.openMiroApplication();
        WebDriver driver = miro.getDriver();
        miro.login.assertLoginPage(driver);
        miro.login.loginWithUserOne();
        miro.dashboard.assertDashboard(driver);
        //create board for User One using Token
        String boardname = miro.board.createBoard();
        miro.refreshPage();
        //Share board with user Two
        miro.board.shareBoard();

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
