import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test001 {
    WebDriver driver;

    public void launchBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritim\\IdeaProjects\\Test003\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/railways/");
        // Check if you have landed in the correct page
        // Print the URL and Title of the Page
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        String url = driver.getCurrentUrl();
        System.out.println("URL of the page is: " + url);

        // click on element using xpath
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
        // click on element using id

        Thread.sleep(1000);
        driver.findElement(
                        By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"))
                .sendKeys("Delhi");
        // wait until element is not visible
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // find the length of all the elements find using selector
        int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
        System.out.println("Length of the list is: " + length);

        // define a loop to iterate through the list
        for (int i = 0; i < length; i++) {
            // find the element using index
            String element = driver.findElements(By.cssSelector(
                            "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                    .get(i)
                    .getText();
            System.out.println("Element is: " + element);
            // check if the element is equal to the search term
            if (element.equals("Delhi")) {
                // click on the element
                driver.findElements(By.cssSelector(
                                "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                        .get(i).click();
                break;
            }
        }

        // Selecting Destination
        // click on element using xpath
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
        // click on element using id

        Thread.sleep(1000);
        driver.findElement(
                        By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"))
                .sendKeys("Lucknow");
        // wait until element is not visible
        Thread.sleep(2000);

        // find the length of all the elements find using selector
        length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
        System.out.println("Length of the list is: " + length);

        // define a loop to iterate through the list
        for (int i = 0; i < length; i++) {
            // find the element using index
            String element = driver.findElements(By.cssSelector(
                            "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                    .get(i)
                    .getText();
            System.out.println("Element is: " + element);
            // check if the element is equal to the search term
            if (element.equals("Lucknow")) {
                // click on the element
                driver.findElements(By.cssSelector(
                                "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                        .get(i).click();
                break;
            }
        }

        // Selecting Date
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath(
//                        "//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]"))
//                .click();
        String month1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
        String month2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div")).getText();
        while(month1 != "May 2023" && month2 !="May 2023") {
            driver.findElement(By.cssSelector("#root > div > div.minContainer > div > div > div > div.rsw.widgetOpen > div > div.rsw_inputBox.dayPickerRailWrap.dates.inactiveWidget.activeWidget > div.datePickerContainer > div > div > div > div.DayPicker > div > div.DayPicker-NavBar > span.DayPicker-NavButton.DayPicker-NavButton--next")).click();

            String month3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
            String month4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div")).getText();


            if (month3.equals("May 2023") || month4.equals("May 2023")) {
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]")).click();
                break;

            }


        }


        // Selecting Class
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
        length = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
        System.out.println("Length of the list is: " + length);
        for (int i = 0; i < length; i++) {
            String element = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).getText();
            System.out.println("Element is: " + element);
            if (element.equals("Third AC")) {
                driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).click();
                break;
            }
        }

        // Clicking Search button
        Thread.sleep(2000);
        driver.findElement(By.xpath("// *[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
        driver.close();

    }

    public static void main(String[] args) throws InterruptedException {
        Test001 obj = new Test001();
        obj.launchBrowser();

    }
}
