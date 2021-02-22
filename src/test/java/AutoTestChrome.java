import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AutoTestChrome {

    private WebDriver webDriver;

    //WebDriver webDriver = new ChromeDriver();
    /*
    打开Chrome浏览器，输入网址
     */
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\AutoTest2021\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://192.168.7.144:8088");
        Thread.sleep(3000);
    }
    /*
    关闭浏览器
     */
    @AfterMethod
    public void quitChrome(){

        webDriver.quit();
    }
    /*
    后退
     */
    @Test
    public void chrome_01(){

        webDriver.navigate().back();

    }
    /*
    前进
     */

    @Test
    public void chrome_02(){

        webDriver.navigate().forward();

    }
    /*
    刷新
     */
    @Test
    public void chrome_03(){

        webDriver.navigate().refresh();
    }
    /*
    设置浏览器大小 500*500
    浏览器最大化
     */
    @Test
    public void chrome_04() throws InterruptedException {

        //实例化窗口大小
        Dimension dimension = new Dimension(500,500);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        webDriver.manage().window().maximize();
        Thread.sleep(3000);


    }
    /*
    获取URL,校验当前的URL是不是预期值
     */
    @Test
    public void chrome_05(){
        String url = webDriver.getCurrentUrl();
        System.out.println("获取到的URL:" + url);
        Assert.assertEquals(url,"https://192.168.7.144:8088/login");

    }

}
