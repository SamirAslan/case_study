package enuygun;

import com.thoughtworks.gauge.Step;
import helper.FindElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillity.Driver;
import com.thoughtworks.gauge.Gauge;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StepImplementation extends Driver {


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Step("<url> sayfasina gidilir.")
    public void goToUrl(String url) {
        driver.navigate().to(url);
    }

    @Step("<key> elementine tikla")
    public void click(String key) {
        By byElement = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
        driver.findElement(byElement).click();
    }

    @Step("<text> textine esit olana <key> elementine tikla")
    public void clickTextToElement(String text, String key) {
        By byElement = FindElement.getDynamicElementInfoToBy(key, text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        driver.findElement(byElement).click();
    }

    @Step("<key> elementine <text> degerini yaz")
    public void sendKey(String key, String text) {
        By byElement = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
        WebElement element = driver.findElement(byElement);
        element.sendKeys(text);

    }

    @Step("<second> saniye kadar bekle")
    public void waitWithSecond(int key) throws InterruptedException {
        Gauge.captureScreenshot();
        Gauge.writeMessage("Saniye bekleniyor");
        Thread.sleep(key * 1000L);
    }

    @Step("<key> li elemente scroll yapılır.")
    public void scrollElement(String key)  {
        By byElement = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
        WebElement element = driver.findElement(byElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 30; i++) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    @Step("Gidis icin <key> elementlerinden <depatureDate> tarihi seciliyor. <nextMonth>")
    public void depatureDatePicker(String key, String depatureDate, String nextMonth) {
        LocalDate depatureD = LocalDate.parse(depatureDate);
        LocalDate currentDate = LocalDate.now();
        Integer betweenMonth = Math.toIntExact(ChronoUnit.MONTHS.between(currentDate, depatureD));
        By nextMonthElement = FindElement.getElementInfoToBy(nextMonth);
        wait.until(ExpectedConditions.presenceOfElementLocated(nextMonthElement));
        for (int i = 0; i < betweenMonth; i++) {
            driver.findElement(nextMonthElement).click();
        }

        String[] dateParts = depatureDate.split("-");
        int parseDay = Integer.parseInt(dateParts[2]);
        String day = String.valueOf(parseDay);
        By byElement = FindElement.getDynamicElementInfoToBy(key, day);
        driver.findElement(byElement).click();
    }

    @Step("Donus icin <key> elementlerinden <returnDate> tarihi seciliyor. <nextMonth>,<depatureDate>")
    public void returnDatePicker(String key, String returnDate, String nextMonth, String depatureDate) {
        LocalDate returnD = LocalDate.parse(returnDate);
        LocalDate depatureD = LocalDate.parse(depatureDate);
        Integer betweenMonth = Math.toIntExact(ChronoUnit.MONTHS.between(depatureD, returnD));
        By nextMonthElement = FindElement.getElementInfoToBy(nextMonth);
        wait.until(ExpectedConditions.presenceOfElementLocated(nextMonthElement));
        for (int i = 0; i < betweenMonth; i++) {
            driver.findElement(nextMonthElement).click();
        }

        String[] dateParts = returnDate.split("-");
        int parseDay = Integer.parseInt(dateParts[2]);
        String day = String.valueOf(parseDay);
        By byElement = FindElement.getDynamicElementInfoToBy(key, day);
        driver.findElement(byElement).click();
    }

    @Step("Arama sonuc sayfasinin url'inin <nereden>,<nereye>,<gidis>,<donus> bilgileri icerdigi dogrulanır")
    public void searchUrlControl(String nereden, String nereye, String gidis, String donus) {
        String depatureAirport = nereden.toLowerCase(Locale.forLanguageTag("en"));
        String returnAirport = nereye.toLowerCase(Locale.forLanguageTag("en"));

        DateTimeFormatter currentFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(gidis, currentFormat);
        LocalDate date2 = LocalDate.parse(donus, currentFormat);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String depatureDate = date1.format(newFormatter);
        String returnDate = date2.format(newFormatter);

        String partUrl = "havalimani-" + depatureAirport + "-" + returnAirport + "/?gidis=" + depatureDate + "&donus=" + returnDate;
        String url = driver.getCurrentUrl();
        if (url.contains(partUrl)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Url'deki parametreler dogru degil...");
        }
    }

    @Step("Arama sonuc sayfasinin url'inin <nereden>,<nereye>,<gidis> bilgileri icerdigi dogrulanır")
    public void searchUrlControl2(String nereden, String nereye, String gidis) {
        String depatureAirport = nereden.toLowerCase(Locale.forLanguageTag("en"));
        String returnAirport = nereye.toLowerCase(Locale.forLanguageTag("en"));

        DateTimeFormatter currentFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(gidis, currentFormat);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String depatureDate = date1.format(newFormatter);

        String partUrl = "havalimani-" + depatureAirport + "-" + returnAirport + "/?gidis=" + depatureDate;
        System.out.printf(partUrl);

        String url = driver.getCurrentUrl();
        if (url.contains(partUrl)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Url'deki parametreler dogru degil...");
        }
    }

    @Step({"<key> elementi var mı?"})
    public void checkElement(String key) {
        try {
            By byElement = FindElement.getElementInfoToBy(key);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (Exception e) {
            Assert.assertTrue("Element bulunamadı.", false);
        }
    }

    @Step({"<text> li <key> elementi var mı?"})
    public void checkElementWithText(String text, String key) {
        try {
            By byElement = FindElement.getDynamicElementInfoToBy(key, text);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (Exception e) {
            Assert.assertTrue("Element bulunamadı.", false);
        }
    }

    @Step("<key> elementinin değeri <text> olarak ayarlanir")
    public void setValue1(String key, String text) throws InterruptedException {
        String[] timeParts1 = text.split(":");
        int hours1 = Integer.parseInt(timeParts1[0]);
        int minutes1 = Integer.parseInt(timeParts1[1]);
        int totalMinutes1 = (hours1 * 10) + minutes1;
        By byElement1 = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement1));
        Actions actions1 = new Actions(driver);
        actions1.dragAndDropBy(driver.findElement(byElement1), totalMinutes1, 0).perform();
        Thread.sleep(3000);
    }

    @Step("<key> elementinin değeri <text> olarak ayarlanir.")
    public void setValue2(String key, String text) throws InterruptedException {
        String[] timeParts2 = text.split(":");
        int hours2 = Integer.parseInt(timeParts2[0]);
        int minutes2 = Integer.parseInt(timeParts2[1]);
        int totalMinutes2 = ((24 - hours2) * 10 * (-1)) + minutes2;
        By byElement2 = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement2));
        Actions actions2 = new Actions(driver);
        actions2.dragAndDropBy(driver.findElement(byElement2), totalMinutes2, 0).perform();
        Thread.sleep(3000);

    }

    @Step("<key> elementinin degerleri <saat1> ile <saat2> arasinda oldugu dogrulanir")
    public void checkValues(String key, String saat1, String saat2) {
        LocalTime startTime = LocalTime.parse(saat1);
        LocalTime endTime = LocalTime.parse(saat2);
        By byElement = FindElement.getElementInfoToBy(key);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byElement));
        List<WebElement> elements = driver.findElements(byElement);
        for (WebElement element : elements) {
            LocalTime checkTime = LocalTime.parse(element.getText());
            if (!checkTime.isBefore(startTime) && !checkTime.isAfter(endTime)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(checkTime + " saati " + startTime + " ile " + endTime + " saatleri arasında değil.");
            }
        }

    }


    @Step({"<key> li elementlerden <text> değerine eşit olanın karsisindaki <key2> elementinin degerleri kontrol edilir"})
    public void checkAllPrice(String key, String text, String key2) {
        By byElement = FindElement.getDynamicElementInfoToBy(key, text);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byElement));
        List<WebElement> elements = driver.findElements(byElement);
        ArrayList<Float> list = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                WebElement newElement = element.findElement(FindElement.getElementInfoToBy(key2));
                list.add(Float.valueOf(newElement.getText()));
            }
        }
        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i) <= list.get(i+1)){
                Assert.assertTrue(true);
            }else {
                Assert.fail("Fiyatlar artan sırada değil...");
            }
        }
    }

}
