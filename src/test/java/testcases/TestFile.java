package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Accuweather;
import pageObjects.Weather24;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestFile {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl = "http://weather.news24.com";
        driver.get(baseUrl);
        //Thread.sleep(3000);
        //String accuURL = "https://www.accuweather.com";
        //driver.get(accuURL);
    }

    @Test
    public void testWeather24() throws Exception {

        Weather24 weather24 = PageFactory.initElements
                (driver, Weather24.class);

        weather24.selectCity();
        weather24.CityName();
        weather24.clickGo();
        weather24.clickExpandedForecast();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")));

        System.out.println("<<<<< WEATHER24 TEMPERATURES >>>>>");
        System.out.println("------------------------------------");
        System.out.println("|Day" + "      |" + "Max" + "      |" + "Min");
        System.out.println("------------------------------------");
        for(int i = 3; i <= 7; i++){
            String Days = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr" +"[" + i +"]"+"/td[1]")).getText();
            String MinTemp = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr"+"[" + i + "]"+"/td[5]")).getText();
            String MaxTemp = driver.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr"+"[" + i + "]"+"/td[4]")).getText();
            System.out.println(Days + "       " + MaxTemp + "       " + MinTemp);
        }

        String accuURL = "https://www.accuweather.com";
        driver.get(accuURL);
        Thread.sleep(3000);

        Accuweather accuweather = PageFactory.initElements(driver, Accuweather.class);
        Thread.sleep(3000);
        accuweather.query();
        driver.findElement(By.xpath("./html/body/div/div[1]/div[2]/div[1]/form/input")).sendKeys(Keys.ENTER);
        accuweather.selectLocation();
        accuweather.clickDaily();

        System.out.println("<<<<< ACCUWEATHER TEMPERATURES >>>>>");
        System.out.println("------------------------------------");
        System.out.println("|Day" + "      |" + "Max" + "      |" + "Min");
        System.out.println("------------------------------------");
        for (int x = 1; x <= 5; x++){
            String days = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[" + x + "]/div[1]/p[1]")).getText();
            String tempMax = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[" + x + "]/div[2]/span[1]")).getText();
            String tempMin = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[" + x + "]/div[2]/span[2]")).getText();
            System.out.println(days + "       " + tempMax + "C" + "       " + tempMin.substring(2));
        }


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
