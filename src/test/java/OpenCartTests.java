import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTests {

    private WebDriver driver;
    private String url = "http://opencart.abstracta.us/";
    String searchField = "//*[@id='search']/input";
    String result = "//*[@id='content']/div[3]/div/div/div[1]/a/img";
    String query = "Macbook Air";

    @Test
    public void launchSite(){
        driver.get(url);
        String title = driver.getTitle();
        Assert.assertEquals(title,"Your Store");
    }

    @Test
    public void searchForProduct(){
        driver.findElement(By.xpath(searchField)).sendKeys(query + Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath(result)).isDisplayed());
    }

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
