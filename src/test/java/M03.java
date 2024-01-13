import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class M03 {
    public static void main(String[] args) {
        /*
        1- http://babayigit.net/testdocs/ adresine gidilir ve pencere maximize edilir
        2- INFO FORM butonuna tıklanır
        3- Form verileri girilir
        4- Save butonuna tıklanır
        5- Sonuç yazdırılır
         */

        System.setProperty("webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // 1- http://babayigit.net/testdocs/ adresine gidilir ve pencere maximize edilir
        driver.get("http://babayigit.net/testdocs/");
        driver.manage().window().maximize();

        //2- INFO FORM butonuna tıklanır
        driver.findElement(By.xpath("//img[@src='img/info.png']")).click();
        //3-Form verileri girilir
        driver.findElement(By.id("firstName")).sendKeys("Tarık");
        driver.findElement(By.id("lastName")).sendKeys("Yiğit");
        driver.findElement(By.id("email")).sendKeys("yigit@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("905559876543");
        driver.findElement(By.xpath("//*[@type='number']")).sendKeys("41");
        driver.findElement(By.id("occupation")).sendKeys("Engineer");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("city")).sendKeys("Kirikkale");
        driver.findElement(By.id("country")).sendKeys("Turkiye");
        driver.findElement(By.xpath("//button")).click();

        System.out.println("Result Message: \n"+driver.findElement(By.id("resultMessage")).getText());


        driver.quit();
    }
}
