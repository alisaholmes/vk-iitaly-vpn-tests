package video_vk.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoVkPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By trending = By.xpath(
            "//android.widget.TextView[@resource-id='android:id/text1' and @text='Trending']"
    );
    private final By firstVideo = By.xpath(
            "(//*[@resource-id='com.vk.vkvideo:id/video_display'])[1]"
    );
    private final By currentTime = By.id("com.vk.vkvideo:id/current_progress");
    private final By closeBtn = By.id("com.vk.vkvideo:id/fast_login_tertiary_btn");

    public VideoVkPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openTreading(){
        wait.until(ExpectedConditions.elementToBeClickable(trending)).click();
    }

    public void closeBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
            System.out.println("Всплывающее окно закрыто");
        } catch (Exception e) {
            System.out.println("Всплывающее окно не появилось, пропускаем шаг");
        }

    }

    public void openFirstVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(firstVideo)).click();
    }

    public String getCurrentTimeText() {
        driver.findElement(firstVideo).click(); // тап по видео, чтобы контролы появились
        // Фиксация текущего времени видео
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(currentTime));
        return el.getText().trim();
    }

    public boolean isVideoPlaying() throws InterruptedException {
        String startTime = getCurrentTimeText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String endTime = getCurrentTimeText();
        return !startTime.equals(endTime); // если время изменилось, видео играет
    }
}


