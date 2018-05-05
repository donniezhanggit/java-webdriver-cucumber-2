package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static support.TestContext.getDriver;

public class USPSStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) throws Throwable {
        switch (page) {
            case "USPS": getDriver().get("https://www.usps.com/");
            break;
            case "sample": getDriver().get("http://skryabin.com/webdriver/html/sample.html");
            break;
            case "google": getDriver().get("https://www.google.com/");
            break;
            default: System.out.println("Not supported page!");
            break;
        }

    }

    @When("^go to lookup ZIP page by address$")
    public void goToLookupZIPPageByAddress() throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//p[@class='icon-cta--label'][contains(text(),'Look Up a ZIP Code™')]")).click();
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//*[@title='byaddress']"));
        Thread.sleep(2000);
    }
}
