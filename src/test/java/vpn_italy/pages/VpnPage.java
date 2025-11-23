package vpn_italy.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VpnPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By statusVpn = By.id("com.helalik.italy.vpn:id/TextView4");

    public VpnPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String statusVpn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusVpn)).getText();
    }

}
