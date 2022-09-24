package miro;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class miroTests {
    Miro miro;
    WebDriver driver;

    @BeforeTest
    public void openMiroApp(){
        miro = new Miro();
        miro.openMiroApplication();
        driver = miro.getDriver();
    }

    @Test(testName ="VerifySharedBoard",description = "verify miro app share board between users")
    public void verifyShareBoardBetweenTwoUsers() throws IOException, InterruptedException {
        miro.login.assertLoginPage(driver);
        miro.login.loginWithUserOne();
        miro.dashboard.assertDashboard(driver);
        //create board for User One using API Call
        String boardname = miro.board.createBoard();
        String boardid = miro.board.getBoardid();
        miro.refreshPage();
        //Share board with user Two using API Call
        miro.board.shareBoard();
        miro.dashboard.openSharedBoard(boardname);
        miro.canvas.addSticker(driver);
        //using api
        miro.board.verifyStickerImageAdded();
        miro.dashboard.signOut();
        //Second User Validations
        miro.login.loginWithUserTwo();
        miro.dashboard.openSharedBoard(boardname);
        miro.dashboard.verifyBoardIsSame(boardid);
    }

    @Test(testName ="VerifySharedBoard",description = "verify miro app share board between users")
    public void verifyShareBoardBetweenTwoUsersUsingImageComparison() throws IOException, InterruptedException {
        miro.login.assertLoginPage(driver);
        miro.login.loginWithUserOne();
        miro.dashboard.assertDashboard(driver);
        //create board for User One using API Call
        String boardname = miro.board.createBoard();
        String boardid = miro.board.getBoardid();
        miro.refreshPage();
        //Share board with user Two using API Call
        miro.board.shareBoard();
        miro.dashboard.openSharedBoard(boardname);
        miro.utils.captureScreenshotWithoutSticker(driver);
        miro.canvas.addSticker(driver);
        miro.utils.captureScreenshotWithSticker(driver);
        //using api
        miro.utils.compareScreenshots(driver);
        miro.dashboard.signOut();
        //Second User Validations
        miro.login.loginWithUserTwo();
        miro.dashboard.openSharedBoard(boardname);
        miro.dashboard.verifyBoardIsSame(boardid);
    }


    @AfterTest
    public void tearDown() throws IOException {
        driver.quit();
        miro.board.deleteBoard();
    }

}
