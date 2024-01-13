import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M04 {
    public static void main(String[] args) {
          /*
        1- https://www.google.com adresine gidilir
        2- Sayfanın title ve Url değerleri yazdırılır
        3- Yeni bir sekme açılarak https://www.wisequarter.com adresine gidilir
        4- Gidilen sayfanın title ve url değerleri yazdırılır ve
           title'in wisequarter içerip içermediği kontrol edilir ve bilgi verilir
        5- Ilk sekmeye geçilip, burada https://www.testotomasyonu.com adresine gidilir
        6- Gidilen sayfanın title ve url değerleri yazdırılır ve
           title'in testotomasyonu içerip içermediği kontrol edilir ve bilgi verilir
        7- Açılan pencere kapatılır.
         */

        System.setProperty("webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Sayfa 10 sn içinde yüklenmezse testi durdurur
                                                                          // 10 saniye dolmadan yüklenirse 10 saniyeyi beklemez

        // 1- https://www.google.com adresine gidilir
        driver.get("https://www.google.com");
        //2- Sayfanın title ve Url değerleri yazdırılır
        System.out.println("İlk Site Title: "+ driver.getTitle());
        System.out.println("İlk Site URL: "+ driver.getCurrentUrl());
        String handle1=driver.getWindowHandle();
        System.out.println("İlk Site Window Handle: "+ handle1);

        //Yeni bir sekme açılarak https://www.wisequarter.com adresine gidilir
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.wisequarter.com");

        //4- Gidilen sayfanın title ve url değerleri yazdırılır ve
        //  title'in wisequarter içerip içermediği kontrol edilir ve bilgi verilir
        String actualTitle=driver.getTitle();
        System.out.println("İkinci Site Title: "+actualTitle );
        System.out.println("İkinci Site URL: "+ driver.getCurrentUrl());
        System.out.println("İkinci Site Window Handle: "+ driver.getWindowHandle());
        String expectedWord="wisequarter";
        if (actualTitle.contains(expectedWord)){
            System.out.println("Title "+expectedWord+" içeriyor.");
        }else{
            System.out.println("Title "+expectedWord+" içermiyor.");
        }
        //5- Ilk sekmeye geçilip, burada https://www.testotomasyonu.com adresine gidilir
        driver.switchTo().window(handle1);
        driver.navigate().to("https://www.testotomasyonu.com");

        //6-Gidilen sayfanın title ve url değerleri yazdırılır ve
        //itle'in testotomasyonu içerip içermediği kontrol edilir ve bilgi verilir
        String sonTitle= driver.getTitle();
        System.out.println("Son Site Title: "+ sonTitle);
        System.out.println("Son Site URL: "+ driver.getCurrentUrl());
        String handle2=driver.getWindowHandle();
        System.out.println("Son Site Window Handle: "+ handle2);
        String expectedWord2="testotomasyonu";

        if (sonTitle.contains(expectedWord2)){
            System.out.println("Title "+expectedWord2+" içeriyor.");
        }else{
            System.out.println("Title "+expectedWord2+" içermiyor.");
        }


        //7-Sayfayı kapatır
        driver.quit();

        /*
        git init
        git add .
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/muratbabayigit/T130SeleniumPractice.git
        git push -u origin main
         */










    }
}
