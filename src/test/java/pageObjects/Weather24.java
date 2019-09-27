package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
    private WebElement MinTemp;
    private WebElement MaxTemp;


    public void selectCity(){
        cityDropDown.click();
    }

    public void CityName(){
        CityName.click();
    }

    public void clickGo() {
        btnGo.click();
    }

    public void clickExpandedForecast(){
        weatherForecast.click();
    }

    public void MinTemp(){
        String minTemperature = MinTemp.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();
        System.out.println("The minimum temperature is: " + minTemperature);
    }

    public void MaxTemp(){
        String maxTemperature = MaxTemp.findElement(By.xpath(".//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        System.out.println("The maximum temperature is: " + maxTemperature);
    }

}
