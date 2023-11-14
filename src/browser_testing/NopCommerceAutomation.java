package browser_testing;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl= %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class NopCommerceAutomation {
    static String baseURL = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Use scanner to get browser choice from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the browser name (Chrome/Firefox/Edge): ");
        String browser = scanner.nextLine();
        // Multi Browser choice
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
            return; // exit the program if the browser name is incorrect
        }
        // Step 1: Setup Browser
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // add implicit waiting
        driver.manage().window().maximize(); // to maximise browser screen
        // Step 2: Open URL
        driver.get(baseURL);
        Thread.sleep(5000);
        // Step 3: Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        // Step 4: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Step 5: Print the page source
        System.out.println("Page Source: " + driver.getPageSource());
        // Step 6: Navigate to URL
        String loginURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginURL);
        // Step 7: Print the current URL
        System.out.println("Current URL after navigation: " + driver.getCurrentUrl());
        // Step 8: Navigate back to the homepage
        driver.navigate().back();
        // Step 9: Navigate to the login page
        driver.navigate().to(loginURL);
        // Step 10: Print the current URL
        System.out.println("Current URL on login page: " + driver.getCurrentUrl());
        // Step 11: Refresh the page
        driver.navigate().refresh();
        // Step 12: Enter email to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime@gmail.com");
        // Step 13: Enter password to password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("123456");
        // Step 14: Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        loginButton.click();
        // Step 15: Close the browser
        driver.quit();
        // Close scanner
        scanner.close();
    }
}
