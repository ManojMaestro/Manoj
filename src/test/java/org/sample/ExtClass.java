package org.sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExtClass extends DataDriven {
	public static void main(String[] args) throws IOException, InterruptedException {

		launchChrome();
		winMax();
		launchUrl("https://facebook.com/");
		Thread.sleep(3000);
		WebElement txtUsr = driver.findElement(By.id("email"));
		fill(txtUsr, getData(4, 1));
		Thread.sleep(7000);
		WebElement lgIn = driver.findElement(By.id("signin-continue-btn"));
		btnClick(lgIn);
	}

}
