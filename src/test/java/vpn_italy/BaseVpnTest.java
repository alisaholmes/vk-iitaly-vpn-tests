package vpn_italy;
import org.junit.jupiter.api.AfterEach;
import utils.DriverConfig;
import io.appium.java_client.AppiumDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import utils.EmulatorManager;

public class BaseVpnTest {
    protected AppiumDriver driver;
    private EmulatorManager emulatorManager;
    private final Dotenv dotenv = Dotenv.load();

    @BeforeEach
    public void setUp() throws Exception {
        emulatorManager = new EmulatorManager();
        emulatorManager.startEmulator(dotenv.get("DEVICE_NAME"));
        String appPackage = dotenv.get("VPN_APP_PACKAGE");
        String appActivity = dotenv.get("VPN_APP_ACTIVITY");

        driver = DriverConfig.createDriver(appPackage, appActivity);
    }
    @AfterEach
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Не удалось закрыть приложение: " + e.getMessage());
        }
        try {
            if (emulatorManager != null) {
                emulatorManager.stopEmulator();
            }
        } catch (Exception e) {
            System.err.println("Не удалось остановить эмулятор: " + e.getMessage());
        }
    }
}