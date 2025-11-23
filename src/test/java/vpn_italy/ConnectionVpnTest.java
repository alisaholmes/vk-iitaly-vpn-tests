package vpn_italy;

import org.junit.jupiter.api.Test;
import vpn_italy.pages.VpnPage;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConnectionVpnTest extends BaseVpnTest {

    @Test
    public void testConnectionVpnTest() {
        VpnPage vpn = new VpnPage(driver);
        String status = vpn.statusVpn();
        System.out.println("Текущий статус VPN: " + status);
        boolean validStatus = status.equalsIgnoreCase("Connected!") ||
                status.equalsIgnoreCase("Disconnected!") ||
                status.equalsIgnoreCase("No VPN connection");
        assertTrue(validStatus, "Статус VPN некорректный: " + status);
    }
}
