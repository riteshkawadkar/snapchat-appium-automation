package parallel;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class SnapChatEmulatorTwoTest {
	
	private final static String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";	
	

	 private AppiumDriver<MobileElement> driver;    

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    
	@BeforeTest(alwaysRun = true)
	public void setup() throws Exception {
	    URL url = new URL(APPIUM_SERVER_URL);
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
	    capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8200");

	    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
	    

	    
	    capabilities.setCapability("appPackage", "com.snapchat.android");
	    capabilities.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");
	    
        driver = new AppiumDriver<MobileElement>(url, capabilities);
	}
	
	
//	@AfterTest(alwaysRun = true)
//	public void teardown() throws Exception {
//	    if (driver!= null) {
//	    	driver.quit();
//	    	Date date = new Date();  
//	        System.out.println(formatter.format(date));  
//	    }
//	}
	
	


    @Test
    public void openApp() throws MalformedURLException, InterruptedException
    {

        Date date = new Date();  
        System.out.println(formatter.format(date));  
        
        
        WebDriverWait wait = new WebDriverWait(driver, 240);
        
        TouchAction t =new TouchAction(driver);

        
        for (int i = 0; i < 1000; i++) {
        	

        	MobileElement emojiiButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/camera_sounds_button")))); 
//        	System.out.println("emojiiButton Found");
        	
        	Thread.sleep(1500);
        	t.tap(PointOption.point(538, 1510)).perform();
        	System.out.println("The thread ID for Chrome Test is "+ Thread.currentThread().getId() + " - clicked on big button - " + i );
        	
        	
        	Thread.sleep(2000);
        	MobileElement timerIcon = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/timer_icon")))); 
//            System.out.println("timer found ");
        	t.tap(PointOption.point(907, 1730)).perform();
//        	System.out.println("clicked on send ");
            
        	
        	Thread.sleep(4000);
        	MobileElement friend = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[6]")))); 
//            System.out.println("friend found ");
            friend.click();
//            System.out.println("clicked fwill ");
            
            Thread.sleep(300);
            MobileElement send = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_to_send_button")))); 
            send.click();
//            System.out.println("send found ");
            
            
            Thread.sleep(2000);
            driver.navigate().back();
//            System.out.println("navigated back found ");
            
            Thread.sleep(1000);
            
		}
        
        
        

        
    }

}
