package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Weather24 {
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")
    private WebElement cityDropDown;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[11]")
    private WebElement CityName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]")
    private WebElement btnGo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen32\"]")
    private WebElement weatherForecast;


    public void selectCity(){
        cityDropDown.click();
    }

    public void CityName(){
        CityName.click();
    }

    public void clickGo() {
        btnGo.click();
    }

    public void clickExpandedForecast() {
        weatherForecast.click();
    }
}
