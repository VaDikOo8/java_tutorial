package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Вадим on 24.12.2016.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("158.69.57.69");
    assertEquals(geoIP.getReturnCodeDetails(), "Success");
  }

  @Test
  public void testInvalidIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("158.69.57.xxx");
    assertEquals(geoIP.getReturnCodeDetails(), "Invalid IP address");
  }
}
