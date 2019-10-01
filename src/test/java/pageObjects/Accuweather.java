package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Accuweather {
    @FindBy(how = How.XPATH, using = "./html/body/div/div[1]/div[2]/div[1]/form/input")
    private WebElement query;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")
    private WebElement selectLocation;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div/div[3]/a[4]")
    private WebElement clickDaily;

    public void query(){
        query.click();
        query.clear();
        query.sendKeys("Bloemfontein");
    }

    /*public void location(){
        query.clear();
        query.sendKeys("Bloemfontein");
    }*/

    public void selectLocation(){
        selectLocation.click();
    }

    public void clickDaily(){
        clickDaily.click();
    }
}
