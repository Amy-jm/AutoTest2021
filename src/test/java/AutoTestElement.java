import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class AutoTestElement {
    private WebDriver driver;
    @BeforeTest
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\AutoTest2021\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //浏览器最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://192.168.7.130:8088/login");
        Thread.sleep(3000);
        //浏览器最大化
    }
    @AfterTest
    public void closeChrom(){
        driver.quit();
    }
    /*
    打开浏览器，定位到用户名和密码输入框，输入用户名和密码，点击登录
    校验登录成功，页面右上角出现admin
     */
    @Test
    public void login_Admin_id() throws InterruptedException {

        WebElement username =  driver.findElement(By.id("login_username"));
        System.out.println(username);
        WebElement password =  driver.findElement(By.id("login_password"));
        System.out.println(password);
        username.sendKeys("admin");
        password.sendKeys("Yeastar202");
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();
        //登录成功的校验为实现
        //WebElement loginSucc =driver.findElement(By.className("ellipsis-tip-wra"));
        //Assert.assertEquals(loginSucc,"admin","登录成功");
        Thread.sleep(3000);

    }
    @Test
    public void login_Admin_xpath() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"login_username\"]"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login_password\"]"));
        password.sendKeys("Yeastar202");
        WebElement loginbButton = driver.findElement(By.xpath("//*[@id=\"login-btn\"]"));
        loginbButton.click();
        Thread.sleep(3000);
    }
    @Test
    public void login_Admin_css() throws InterruptedException {
        WebElement username = driver.findElement(By.cssSelector("#login_username"));
        username.sendKeys("admin");
        WebElement password =driver.findElement(By.cssSelector("#login_password"));
        password.sendKeys("Yeastar202");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-btn"));
        loginButton.click();
        Thread.sleep(3000);
        String url= driver.getCurrentUrl();
        Assert.assertEquals(url,"https://192.168.7.130:8088/","admin登录成功");

    }
    @Test
    public void BD(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
        System.out.println(list);
        int size = list.size();
        int i;
        for (i = 0; i < size; i++) System.out.println(list.get(i).getText());
    }



}
