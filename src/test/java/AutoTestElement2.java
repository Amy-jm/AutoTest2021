import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AutoTestElement2 {
    WebDriver driver;
    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\AutoTest2021\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //浏览器最大化
        driver.manage().window().maximize();
        //打开浏览器，输入网址
        driver.get("https://192.168.11.150:8088/login");

    }
    @Test
    public void autoTestClear() throws InterruptedException {
        //登录操作
        WebElement username = driver.findElement(By.id("login_username"));
        WebElement password = driver.findElement(By.id("login_password"));
        username.sendKeys("admin");
        password.sendKeys("Yeastar123");
        //通过权限然后继续赋值来清除输入框，如果是直接用password.clear会报错，可以试下看运行效果就知道
        //https://blog.csdn.net/sun_977759/article/details/108731881
        password.sendKeys(Keys.CONTROL, "a");
        Thread.sleep(3000);
        password.sendKeys("Yeastar202");
        WebElement login = driver.findElement(By.id("login-btn"));
        login.click();
        Thread.sleep(5000);
        WebElement admin = driver.findElement(By.xpath("//*[@id=\"h-info\"]/span[2]/p"));
        String user = admin.getText();
        Assert.assertEquals(user,"admin","登录成功");
    }
    @Test
    public void getAtt() throws InterruptedException {
        WebElement username = driver.findElement(By.id("login_username"));
        Thread.sleep(3000);
        String defaultUsername = username.getAttribute("placeholder");
        Assert.assertEquals(defaultUsername,"用户名");
    }
    @Test
    public void getTagname() throws InterruptedException {
        WebElement username = driver.findElement(By.id("login_username"));
        Thread.sleep(3000);
        String input = username.getTagName();
        Assert.assertEquals(input,"input");
    }
    @Test
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title,"Yeastar P570");

    }
    @Test
    public void displan(){

        WebElement username = driver.findElement(By.id("login_username"));
        boolean a = username.isDisplayed();
        Assert.assertTrue(a);

    }
    @Test
    public void selectExt() throws InterruptedException {
        WebElement username = driver.findElement(By.id("login_username"));
        WebElement password = driver.findElement(By.id("login_password"));
        username.sendKeys("admin");
        password.sendKeys("Yeastar202");
        WebElement login = driver.findElement(By.id("login-btn"));
        login.click();
        Thread.sleep(2000);
        WebElement extAndTrunk = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div[1]/aside/div/ul/li[2]/div"));
        extAndTrunk.click();
        Thread.sleep(2000);
        WebElement ext = driver.findElement(By.id("m_extensions"));
        ext.click();
        Thread.sleep(2000);
        WebElement extall = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/label/span/input"));
        Thread.sleep(2000);
        boolean a = extall.isSelected();
        Assert.assertFalse(a);

    }
    @Test
    public void isEnableButton() throws InterruptedException {
        WebElement username = driver.findElement(By.id("login_username"));
        WebElement password = driver.findElement(By.id("login_password"));
        username.sendKeys("admin");
        password.sendKeys("Yeastar202");
        WebElement login = driver.findElement(By.id("login-btn"));
        login.click();
        Thread.sleep(2000);
        WebElement extAndTrunk = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/div/div[1]/aside/div/ul/li[2]/div"));
        extAndTrunk.click();
        Thread.sleep(2000);
        WebElement ext = driver.findElement(By.id("m_extensions"));
        ext.click();
        Thread.sleep(2000);
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/div[2]/div/div[1]/div[1]/button[2]"));
        boolean a = edit.isEnabled();
        Assert.assertFalse(a);

    }
    @Test
    public void testScreenShot(){
        // 把driver修改为TaskScreenshot类型，调用getScreenshotAS 方法，方法需传入OutputType.FILE
        //将获取到的截图赋值给变量screen
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            //FileUtils.copyFile把变量存放到路径下，并且命名为login.png
            FileUtils.copyFile(screen, new File("F:/login.png"));
            //如果无截图，则抛出异常错误
        }catch (IOException e){
            e.printStackTrace();
        }

    }
      @AfterTest
    public void closeChrome(){
        driver.quit();
    }


}
