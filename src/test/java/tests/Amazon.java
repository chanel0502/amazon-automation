package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.AmazonHomePage;
import utilities.Config;
import utilities.Driver;

public class Amazon {

    AmazonHomePage amazonHomePage = new AmazonHomePage();

    @Test
    public void search() {

        Faker faker = new Faker();
        String testData = faker.lorem().word();
        Driver.getDriver().get(Config.readValue("amazonURL"));
        amazonHomePage.searchInput.sendKeys(testData + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(testData));

    }
}