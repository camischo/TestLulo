package com.conexia.qa.mensajero.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class OwnWebDriver {

	private WebDriver driver;

	private static List<OwnWebDriver> listOwnWebDriver = new ArrayList<>();

	public static OwnWebDriver withChrome() {
		String downloadPath = "";
		int timeOut = 20;
		ChromeOptions chromeOptions = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

		chromePrefs.put("download.default_directory", downloadPath);
		chromeOptions.addArguments(
				"" + "--start-maximized " + "--ignore-certificate-errors " + "--disable-extensions " + "--incognito");

		chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		chromeOptions.setExperimentalOption("prefs", chromePrefs).setExperimentalOption("excludeSwitches",
				new String[] { "enable-automation" });
		//System.setProperty("webdriver.chrome.driver", "/home/cschottlaender/Librerias/WebDrivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:\\Librerias\\WebDrivers\\chromedriver.exe");

		listOwnWebDriver.add(new OwnWebDriver());
		listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver = new ChromeDriver(chromeOptions);
		listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver.manage().timeouts().implicitlyWait(timeOut,
				TimeUnit.SECONDS);
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1);
	}

	public WebDriver setURL(String url) {
		driver.get(url);
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

	public static WebDriver getDriver() {
		return listOwnWebDriver.get(listOwnWebDriver.size() - 1).driver;
	}

}
