package miro.objects;
import org.openqa.selenium.By;

public class LoginPageObjects {
    public static final By UserName = By.xpath("//input[@id='email']");
    public static final By Password = By.xpath("//input[@id='password']");
    public static final By SigninBtn = By.xpath("//button[@type='submit']");

//    public static final By noOfBoards = By.xpath("//boards-grid-view/div/div");
//    public static final By gotestingTeamElem = By.xpath("//div[@aria-label='Switch to Testing team']");
    public static final String name = "shaikhnishad2014@outlook.com";
    public static final String pwd =  "@Assignment1234";
    public static final String seconduser = "nishadquality@outlook.com";









    //homebutton
    public static final By homeButton = By.xpath("//div[@data-testid='board-header__logo']");





    public static final By canvas = By.xpath("(//div[@id='pixiCanvasContainer']/canvas)[2]");

}
