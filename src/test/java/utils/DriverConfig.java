package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.URL;

public class DriverConfig {
    private static final Dotenv DOTENV = Dotenv.load();

    public static AppiumDriver createDriver(String appPackage, String appActivity) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(DOTENV.get(("DEVICE_NAME")))
                .setPlatformName(DOTENV.get("PLATFORM", "Android"))
                .setAutomationName("UiAutomator2")
                .setAppPackage(appPackage)
                .setAppActivity(appActivity)
                .setNoReset(true)
                .setFullReset(false);
        String remote = DOTENV.get("REMOTE_URL");
        return new AndroidDriver(new URL(remote),
                options);
    }
}