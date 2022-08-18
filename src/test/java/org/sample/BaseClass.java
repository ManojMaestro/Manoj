package org.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Select g;
	public static Robot r;
	public static Alert al;
	public static JavascriptExecutor js;

	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void winMax() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String Url) {
		driver.get(Url);
	}

	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void btnClick(WebElement ele) {
		ele.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void rightClick(WebElement ele) {
		a = new Actions(driver);
		a.contextClick(ele).perform();
	}

	public static void dClick(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void rfresh() {
		driver.navigate().refresh();
	}

	public static void frwrdUrl() {
		driver.navigate().forward();
	}

	public static void bckwrdUrl() {
		driver.navigate().back();
	}

	public static void frame() {
		driver.switchTo().frame("greens@123");
	}

	public static void getElements(List<WebElement> ref) {
		int s = ref.size();
		System.out.println("No. of frames:" + s);
	}

	public static void dDown(WebElement s) {
		g = new Select(s);
		g.selectByIndex(0);
		g.selectByValue("Greens");
		g.selectByVisibleText("Technology");
		g.deselectByIndex(0);
		g.deselectByValue("Greens");

		List<WebElement> o = g.getOptions();
		int o1 = o.size();
		System.out.println("No.of options:" + o1);
		for (int i = 0; i < o.size(); i++) {
			WebElement o2 = o.get(i);
			System.out.println(o2.getText());
		}

		List<WebElement> g1 = g.getAllSelectedOptions();
		o.removeAll(g1);
		for (int i = 0; i < o.size(); i++) {
			WebElement unSelect = o.get(i);
			System.out.println(unSelect.getText());
		}
	}

	public static void choose(WebElement s) {
		g = new Select(s);
		g.selectByIndex(0);
		g.selectByValue("Grape");
		g.selectByVisibleText("Banana");
		g.deselectByIndex(0);
		g.deselectByValue("Grape");

		WebElement f = g.getFirstSelectedOption();
		System.out.println("First Selected Option:" + f.getText());
		System.out.println("Value Of Selected Option:" + f.getAttribute("Value"));
	}

	public static void vKey(WebElement v) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_COPY);
		r.keyRelease(KeyEvent.VK_COPY);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void simpleAlert() {
		al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}

	public static void confirmAlert() {
		al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	}

	public static void promptAlert() {
		al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.sendKeys("Greens");
		al.accept();
	}

	public static void Scroll(String s, WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript(s, ele);
	}

	public static void jsExecute(String s1, WebElement ele1) {
		js = (JavascriptExecutor) driver;
		js.executeScript(s1, ele1);
	}

}
