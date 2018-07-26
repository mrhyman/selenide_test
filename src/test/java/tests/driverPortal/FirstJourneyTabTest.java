package tests.driverPortal;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.GTCDriverPortal.FirstJourneyTab;
import tests.BaseTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class FirstJourneyTabTest extends BaseTest {

    private static FirstJourneyTab firstJourneyTab;

    @BeforeClass
    public static void openPortalPage() {
        firstJourneyTab = loginPage.login(validDriver);
    }

    @Test
    public void logoIsShown() {
        firstJourneyTab.verifyLogo();
    }

    @Test
    public void correctFooterIsShown() {
        firstJourneyTab.verifyFooter();
    }

    @Test
    public void logoutButtonIsShown() {
        firstJourneyTab.verifyLogoutButton();
    }

    @Test
    public void correctDriverNameIsShown() {
        firstJourneyTab.verifyDriverName();
    }

    @Test
    public void mapIsShown() {
        firstJourneyTab.verifyMap();
    }

    @Test
    public void correctPageTitleIsShown() {
        firstJourneyTab.verifyTitle();
    }

    @Test
    public void correctDriverAddressIsShown() {
        firstJourneyTab.verifyAddress();
    }

    @Test
    public void driverShiftIsShown() {
        firstJourneyTab.verifyCurrentShift();
    }

    @Test
    public void correctDriverAddressLabelIsShown() {
        firstJourneyTab.verifyAddressLabel();
    }

    @Test
    public void correctDriverShiftLabelIsShown() {
        firstJourneyTab.verifyCurrentShiftLabel();
    }

    @Test
    public void correctTabsAreShown() {
        firstJourneyTab.verifyTabs();
    }

    @Test
    public void jobsTableIsShown() {
        firstJourneyTab.verifyJobsTable();
    }

    @Test
    public void correctJobsTableTitleIsShown() {
        firstJourneyTab.verifyJobsTableTitle();
    }

    @Test
    public void correctJobsTableHeadersAreShown() {
        firstJourneyTab.verifyJobsTableHeaders();
    }

    @Test
    public void selectButtonIsShown() {
        firstJourneyTab.verifySelectButton();
    }

    @Test
    public void selectFirstJobTest() {
        if(firstJourneyTab.verifySelectButton()) {
            firstJourneyTab.selectJob();
            firstJourneyTab.verifySelectedJobTableHeader();
        } else {

        }
    }

    @Test
    public void testGetSingleUserProgrammatic() throws IOException {
        CookieStore httpCookieStore = new BasicCookieStore();
        Set<org.openqa.selenium.Cookie> driverCookies = driver.manage().getCookies();
        Iterator iterator = driverCookies.iterator();
        while (iterator.hasNext()) {
            org.openqa.selenium.Cookie driverCookie = (org.openqa.selenium.Cookie) iterator.next();
            Cookie cookie = new BasicClientCookie(driverCookie.getName(), driverCookie.getValue());
            httpCookieStore.addCookie(cookie);
        }

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .setDefaultCookieStore(httpCookieStore)
                .build();
        HttpGet httpGet = new HttpGet("https://192.0.2.67/driver-portal/api/jobSelection/jobFilter");

        iterator = httpCookieStore.getCookies().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HttpResponse response = httpClient.execute(httpGet);


        System.out.println("----------------------------------------------------");

//        Set<Cookie> cookies= driver.manage().getCookies();
//        iterator = cookies.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//
//        }

        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        int code = response.getStatusLine().getStatusCode();
        System.out.println(body + " ; " + code);
    }
}
