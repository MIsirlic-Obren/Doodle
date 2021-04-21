package doodle.com;

import java.util.List;
import org.junit.Assert;
import model.CreatePollPage;
import model.Dashboard;
import model.LandingPage;
import model.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoodleCom {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        

        driver.manage().window().maximize();
        driver.get("https://doodle.com/en/");
        LandingPage landingPage = new LandingPage();

        WebElement loginField = driver.findElement(By.xpath(landingPage.loginBtn));
        loginField.click();

        LoginPage loginPage = new LoginPage();

        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.name(loginPage.email));
        Thread.sleep(2000);

        emailField.click();
        emailField.clear();
        emailField.sendKeys("misirlicobren@gmail.com");

        WebElement passwordField = driver.findElement(By.name(loginPage.password));
        passwordField.click();
        passwordField.sendKeys("123456789obren");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.xpath(loginPage.loginBtn));
        loginButton.click();

        Thread.sleep(4000);

        Dashboard dashboard = new Dashboard();

        WebElement createPoll = driver.findElement(By.xpath(dashboard.createPoll));

        createPoll.click();

        WebElement meetingType = driver.findElement(By.xpath(dashboard.oneOnOne));
        meetingType.click();

        CreatePollPage createPollPage = new CreatePollPage();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createPollPage.iFrame)));
        WebElement inputTitle = driver.findElement(By.xpath(createPollPage.title));

        wait.until(ExpectedConditions.elementToBeClickable(inputTitle));

        inputTitle.sendKeys("MyMeeting");
        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.xpath(createPollPage.continueBtn));

        continueButton.click();

        Thread.sleep(4000);

        WebElement month = driver.findElement(By.xpath("//a[@href=\"#month\"]"));
        month.click();

        WebElement btnDate = driver.findElement(By.xpath("//td[@data-date=\"2021-04-29\"]"));
        btnDate.click();
        WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"d-wizardOptionsNavigationView\"]/div/div/div[2]/button[2]"));
        btnContinue.click();

        Thread.sleep(3000);
        WebElement btnFinish = driver.findElement(By.xpath("//*[@id=\"d-wizardSettingsNavigationView\"]/div/div/div[2]/button[2]"));
        btnFinish.click();

        Thread.sleep(3000);

        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);

        Assert.assertTrue(driver.getCurrentUrl().contains("https://doodle.com/poll"));

        System.out.println("Test Passed");

    }

}
