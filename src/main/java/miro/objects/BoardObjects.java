package miro.objects;

import org.openqa.selenium.By;

public class BoardObjects {
    public static final By moreToolsElement = By.xpath("//div[@tooltip='More tools']");
    public static final By inputAppsElement = By.xpath("//input[@id='library-root-search']");
    //div[@class='library-root toolbar-library__inner']/div//span[text()='Stickers and Emojis']
    public static final By stickerEmojiToolbar = By.xpath("//button[contains(@class,'MEDIA_LIBRARY')]");
    public static final By selectStickerTab = By.xpath("//button[@data-testid='media-library__stickers-button']");
    public static final By inputSticker = By.xpath("//input[@placeholder='Search'][1]");
    public static final By firstSticker = By.xpath("(//div[@data-testid='stickers-grid']//button)[1]");

    public static final By canvasElement = By.xpath("//*[@id='active_users_layer']");
    public static final By closeStickersToolBar = By.xpath("//div[@tooltip='More tools']");
}
