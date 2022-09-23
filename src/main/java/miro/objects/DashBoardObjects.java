package miro.objects;

import org.openqa.selenium.By;

public class DashBoardObjects {
    public static final By teamNameTitle = By.xpath("//div[@data-testid='team-menu']/div/div/span");
    public static By getboardElement(String boardname) {
        //boards-grid-view/div/div//span[text()='new board5']
        String xpath = "//boards-grid-view/div/div//span[text()='"+boardname+"']";
        return By.xpath(xpath);
    }

    public static final By createDashboard = By.xpath("//span[text()='Boards in this team']");
    //open profile
    public static final By openProfile = By.xpath("(//div[@data-testid='user-profile-button__user-icon'])[1]");
    public static final By signOut = By.xpath("//span[text()='Log out']");

}
