import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {

    private static WebDriver webDriver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        practice1_accessWebPage();
        //practice2_getWebPageDetails();
        //practice3_navigation();
        //practice4_locateRead();
        //practice5_differentSelectors();
        //practice6_interactingWithElements();
    }

    static void practice1_accessWebPage(){
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");
    }

    static void practice2_getWebPageDetails(){
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");

        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getPageSource());
        System.out.println(webDriver.getWindowHandle());
        webDriver.quit();
    }

    static  void practice3_navigation()  {
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");

        try{
            Thread.sleep(3000);
            webDriver.navigate().to("https://www.google.com");
            Thread.sleep(4000);
            webDriver.navigate().back();
            Thread.sleep(4000);
            webDriver.navigate().forward();
            Thread.sleep(4000);
            webDriver.navigate().refresh();
        }
        catch (InterruptedException e){e.printStackTrace();}
    }

    static  void practice4_locateRead()  {
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");

        WebElement btnVerify = webDriver.findElement(By.id("btnVerifyNumber"));
        System.out.println("button's text : " + btnVerify.getAttribute("value"));
        System.out.println("button's tag name : " + btnVerify.getTagName());
        System.out.println("button's class : " + btnVerify.getAttribute("class"));
        System.out.println("is button displayed : " + btnVerify.isDisplayed());
        webDriver.quit();
    }

    static void practice5_differentSelectors(){
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");

        WebElement buttonByTagName = webDriver.findElement(By.tagName("input"));
        System.out.println("this web element is found by tagName : " + buttonByTagName.getAttribute("value"));

        WebElement buttonByCss = webDriver.findElement(By.cssSelector(".w3-button.w3-blue"));
        System.out.println("this web element is found by css : " + buttonByCss.getAttribute("value"));

        WebElement buttonByXPath = webDriver.findElement(By.xpath("(//h4)[1]/following-sibling::input[1]"));
        System.out.println("this web element is found by xpath : " + buttonByXPath.getAttribute("value"));

        WebElement buttonByClassName = webDriver.findElement(By.className("w3-button"));
        System.out.println("this web element is found by className : " + buttonByClassName.getAttribute("value"));
    }

    static void practice6_interactingWithElements(){
        webDriver.get("http://practice.kicchi.net/AutomizationPortal.html");

        try{
            //locating elements
            WebElement buttonGenerateNumber = webDriver.findElement(By.tagName("input"));
            WebElement labelGeneratedNumber = webDriver.findElement(By.tagName("p"));
            WebElement textForNumberVerification = webDriver.findElement(By.name("verifyText"));
            WebElement buttonVerifyNumber = webDriver.findElement(By.id("btnVerifyNumber"));

            Thread.sleep(2000);
            //performing steps
            buttonGenerateNumber.click();                               Thread.sleep(2000);

            String generatedNumber = labelGeneratedNumber.getText();    Thread.sleep(2000);

            textForNumberVerification.sendKeys(generatedNumber);        Thread.sleep(2000);

            buttonVerifyNumber.click();                                 Thread.sleep(2000);

            webDriver.quit();
        }catch (InterruptedException e){e.printStackTrace();}
    }

}
