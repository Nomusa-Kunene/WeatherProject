package testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFile {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        String baseUrl = "http://weather.news24.com";
        driver.get(baseUrl);
        WebElement minTemp;
        WebElement maxTemp;
        /*
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);*/
    }

    @Test
    public void testWeather24() throws Exception {

        driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")).click();
        driver.findElement(By.xpath("//*//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[11]")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ext-gen32\"]")).click();
        Thread.sleep(3000);
        String currentWeather =  driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        System.out.println(currentWeather);
        Thread.sleep(3000);
        String currentWeather2 =  driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();
        System.out.println(currentWeather2);
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}

