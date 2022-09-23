package miro;

import miro.objects.*;
import miro.pages.DashBoardPage;
import miro.pages.LoginPage;
import miro.API.*;
import miro.pages.BoardPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Map;

public class Miro {
    public LoginPage login;
    public WebDriver driver;
    public boardActions board;
    public Utils utils;
    public DashBoardPage dashboard;
    public BoardPage canvas;
    public Miro(){
        login = new LoginPage();
        board = new boardActions();
        utils = new Utils();
        dashboard = new DashBoardPage();
        canvas = new BoardPage();
    }

    public void openMiroApplication() {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        String baseUrl = "https://miro.com/login/";
        String expectedTitle = "Sign in | Miro | Online Whiteboard for Visual Collaboration";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void refreshPage(){
        this.getDriver().navigate().refresh();
    }

}
