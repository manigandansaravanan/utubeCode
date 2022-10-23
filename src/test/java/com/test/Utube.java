package com.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.apache.commons.codec.language.Nysiis;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utube {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.youtube.com/");
	driver.manage().window().maximize();
	
	
	List<WebElement> brokenLink = driver.findElements(By.tagName("href"));
	int size = brokenLink.size();
	System.out.println(size);
	
//	for (WebElement x : brokenLink) {	
//		String attribute = x.getAttribute("href");
//		if (attribute!=null) {
//			URL url = new URL(attribute);
//			URLConnection openConnection = url.openConnection();
//			HttpURLConnection http = (HttpURLConnection)openConnection;
//			int responseCode = http.getResponseCode();
//			if (responseCode>=400) {
//				System.out.println(attribute);
//			}	
//		}
//	}
	
	
	WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
	searchBox.sendKeys("Mr.Bell_Mani");
	WebElement click = driver.findElement(By.id("search-icon-legacy"));
	click.click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//yt-formatted-string[contains(text(),'kerala')])[1]")));
			WebElement myVideo = driver.findElement(By.xpath("(//yt-formatted-string[contains(text(),'kerala')])[1]"));
	myVideo.click();
	
	Thread.sleep(5000);
//	WebElement subscribe = driver.findElement(By.id("(//yt-formatted-string[text()='Subscribe'])[1]"));
//	subscribe.click();
//	WebElement frame = driver.findElement(By.name("passive_signin"));
//	driver.switchTo().frame(frame);
//	Thread.sleep(5000);
//	WebElement alert = driver.findElement(By.name("passive_signin"));
//	alert.click();
	
	
	WebElement cmd = driver.findElement(By.xpath("//div[text()='Add a comment...']"));
	cmd.click();
	
	WebElement cmdIt = driver.findElement(By.id("placeholder-area"));
	cmdIt.click();
	
	
	
	driver.close();
	
}
}
