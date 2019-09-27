package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Weather24 {
    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")
    private WebElement cityDropDown;
    @FindBy(how = How.XPATH, using = "//*//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[11]")
    private WebElement CityName;
    private WebElement MinTemp;
    private WebElement MaxTemp;
    @FindBy(how = How.XPATH, using = ".//*[@id='main']/form/div[2]/fieldset/p/input")
    private WebElement Go;

    public void selectCity(){
        cityDropDown.click();
    }

    public void CityName(String text){
        CityName.click();;
    }

    public void MinTemp(String text){
        MinTemp.clear();
        MinTemp.sendKeys(text);
    }

    public void MaxTemp(String text){
        MaxTemp.clear();
        MaxTemp.sendKeys(text);
    }

    public void clickGo() {
        Go.click();
    }
}
