package miro.objects;

import org.openqa.selenium.By;

public class BoardObjects {
    public static final By moreToolsElement = By.xpath("//div[@class='board-toolbar__items']/div[@tooltip='more tools']");
    public static final By inputAppsElement = By.xpath("//input[@id='library-root-search']");
    //div[@class='library-root toolbar-library__inner']/div//span[text()='Stickers and Emojis']
    public static final By stickerEmojiToolbar = By.xpath("//button[contains(@class,'MOJI_ICONS')]");
    public static final By selectStickerTab = By.xpath("//div[@data-testid='stickers-library-breadcrumbs']/div[1]");
    public static final By inputSticker = By.xpath("//input[@placeholder='Search stickers']");
    public static final By firstSticker = By.xpath("(//div[@id='stickers-library-content']/div/div/div[2]/div[1]/div)[1]");

    public static final By canvasElement = By.xpath("//*[@id='active_users_layer']");
    public static final By closeStickersToolBar = By.xpath("(//button[@aria-label='Close'])[1]");
}
