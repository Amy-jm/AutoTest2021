import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoTestCreateExtension {
    WebDriver driver;
    @BeforeTest
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\AutoTest2021\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://192.168.7.130:8088/login");
        WebElement username = driver.findElement(By.id("login_username"));
        WebElement password = driver.findElement(By.id("login_password"));
        username.sendKeys("admin");
        password.sendKeys("Yeastar202");
        WebElement login =driver.findElement(By.id("login-btn"));
        login.click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://192.168.7.130:8088/","登录成功");
    }



    @Test
    public void addExtension(){
        WebElement extandTrunk = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div[1]/aside/div/ul/li[2]/div"));
        extandTrunk.click();
        WebElement ext = driver.findElement(By.id("m_extensions"));
        ext.click();
        WebElement add = driver.findElement(By.xpath("///*[@id=\"root\"]/div/section/section/div/div[2]/div/div[1]/div[1]/button[1]"));
        add.click();
        WebElement save = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/div/div[2]/div/div/button[1]"));
        save.click();
        WebElement ext1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[8]/td[4]"));
        Assert.assertEquals(ext1.getText(),"1006","添加成功");


    }

    @AfterTest
    public void closeChrome(){
        driver.quit();
    }

}
