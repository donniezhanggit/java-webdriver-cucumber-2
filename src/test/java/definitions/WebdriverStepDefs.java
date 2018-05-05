package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.asserts.Assertion;
import sun.security.util.SecurityConstants;
import support.TestContext;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebdriverStepDefs {
    @Given("^I go to \"([^\"]*)\" page and print details$")
    public void iGoToPageAndPrintDetails(String page) throws Throwable {
        if (page.equalsIgnoreCase("google")) {
            TestContext.getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("sample")) {
            getDriver().get("http://skryabin.com/webdriver/html/sample.html");

        }

        System.out.println(TestContext.getDriver().getCurrentUrl());
        System.out.println(TestContext.getDriver().getTitle());
//        System.out.println(TestContext.getDriver().getPageSource());
        System.out.println(TestContext.getDriver().getWindowHandles());
        System.out.println(TestContext.getDriver().manage().getCookies());
        System.out.println();
    }

    @And("^I go back and forward, then refresh the page$")
    public void iGoBackAndForwardThenRefreshThePage() throws Throwable {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("^I print logs to the console$")
    public void iPrintLogsToTheConsole() throws Throwable {

        LogEntries logEntries = getDriver().manage().logs().get("browser");

        for (LogEntry element : logEntries) {
            System.out.println(element);
        }
    }

    @Given("^I open \"([^\"]*)\" then \"([^\"]*)\" then \"([^\"]*)\"$")
    public void iOpenThenThen(String arg0, String arg1, String arg2) throws Throwable {
        String[] urls = {arg0,arg1,arg2};
//
//      for (String element : urls) {
//            System.out.println(element);
//            getDriver().get(element);
////            Thread.sleep(3000);
//        }

        for (int i = 0; i < urls.length; i++){
            System.out.println(urls[i]);
            getDriver().get(urls[i]);
            Thread.sleep(1000);
        }

    }

    @And("^I change resolution to \"([^\"]*)\"$")
    public void iChangeResolutionTo(String arg0) throws Throwable {

        if (arg0.equalsIgnoreCase("phone")) {
            getDriver().manage().window().setSize(new Dimension(400,768));
            System.out.println(arg0 +" ");
        }
        else if (arg0.equalsIgnoreCase("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
            System.out.println(arg0 +" ");
        }
        Thread.sleep(3000);
    }

    @When("^I fill out first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) throws Throwable {
        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();

        Thread.sleep(3000);

    }

    @And("^I fill out required fields$")
    public void iFillOutRequiredFields() throws Throwable {
        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        getDriver().findElement(By.xpath("//*[@id='firstName']")).sendKeys("firstName");
        getDriver().findElement(By.xpath("//*[@id='lastName']")).sendKeys("secondName");
        getDriver().findElement(By.xpath("//*[text()='Save']")).click();
        getDriver().findElement(By.xpath("//*[@name='username']")).sendKeys("Username");
        getDriver().findElement(By.xpath("//*[@name='email']")).sendKeys("email@me");
        getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//*[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//*[contains(text(),'Privacy Policy')]")).click();
        getDriver().findElement(By.xpath("//*[@name='phone']")).sendKeys("12345");

        Thread.sleep(3000);
    }

    @And("^I submit the page$")
    public void iSubmitThePage() throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(3000);
    }

    @When("^I verify email field behavior$")
    public void iVerifyEmailFieldBehavior() throws Throwable {
        WebElement emailField = getDriver().findElement(By.xpath("//*[@name='email']"));
        emailField.clear();
        emailField.sendKeys("email");
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(5000);

        String emailError = getDriver().findElement(By.xpath("//label[@id='email-error']")).getText();
        assertThat(emailError).contains("valid");

//        Assertions.assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getText()).contains("enter a valid email address");

        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.clear();
        emailField.sendKeys("email@me");

//        getDriver().findElement(By.xpath("//*[@name='email']")).clear();
//        getDriver().findElement(By.xpath("//*[@name='email']")).sendKeys("email");
//        Thread.sleep(2000);
//        getDriver().findElement(By.xpath("//*[@name='email']")).sendKeys(Keys.BACK_SPACE);
//        Thread.sleep(2000);
//        getDriver().findElement(By.xpath("//*[@name='email']")).clear();
//        getDriver().findElement(By.xpath("//*[@name='email']")).sendKeys("mail@");
//        Thread.sleep(2000);

        boolean errorDisplayed = getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();
        assertThat(errorDisplayed).isFalse();
    }

    @Then("^I verify fields values recorded correctly$")
    public void iVerifyFieldsValuesRecordedCorrectly() throws Throwable {

//        String firstName = getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
//        assertThat(firstName).containsIgnoringCase("firstname");
//
//        String lastName = getDriver().findElement(By.xpath("//b[@name='lastName']")).getText();
//        assertThat(lastName).containsIgnoringCase("secondname");
//
//        String name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
//        assertThat(name).containsIgnoringCase("firstname " + "secondname");
//
//        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        assertThat(username).containsIgnoringCase("username");
//
//        boolean passwordEntered = getDriver().findElement(By.xpath("//b[@name='password']")).isDisplayed();
//        assertThat(passwordEntered).isTrue();
//
//        boolean privacyPolicy = getDriver().findElement(By.xpath("//*[@name='agreedToPrivacyPolicy'][text()='true']")).isDisplayed();
//        assertThat(privacyPolicy).isTrue();

        boolean resultDisplayed = getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed();
        assertThat(resultDisplayed).isTrue();

        String passwordText = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(passwordText).doesNotContain("12345");
        assertThat(passwordText).contains("entered");

        String resultText = getDriver().findElement(By.xpath("//div[@id='samplePageResult']//section")).getText();
        assertThat(resultText).containsIgnoringCase("firstname");
        assertThat(resultText).containsIgnoringCase("secondname");
        assertThat(resultText).containsIgnoringCase("email@me");
    }
}
