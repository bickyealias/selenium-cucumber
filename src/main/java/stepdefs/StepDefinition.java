package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.CreateDriver;

/**
 * Created by bicky on 4/10/2018.
 */
public class StepDefinition {
    public String expectedproduct="";
    @Given("^User is on shopping site \"([^\"]*)\" Home Page$")
    public void open_url(String url){
        WebDriver webDriver = CreateDriver.getDriver();
        webDriver.get(url);

    }
    @When("^Page is loaded search for (.*)$")
    public void page_is_loaded_search_for_products(String product)  {
        // Write code here that turns the phrase above into concrete actions
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        expectedproduct = product;
        WebElement searchbox = CreateDriver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys(product);
        CreateDriver.getDriver().findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();



    }

    @Then("^User is taken to the respective landing pages$")
    public void user_is_taken_to_the_respective_landing_pages(){
        WebDriverWait wb =new  WebDriverWait(CreateDriver.getDriver(),5);
        wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"s-result-count\"]/span/span")));
        String actualval=CreateDriver.getDriver().findElement(By.xpath("//*[@id=\"s-result-count\"]/span/span")).getText();
        org.testng.Assert.assertEquals(actualval,"\""+expectedproduct+"\"");


    }



}
