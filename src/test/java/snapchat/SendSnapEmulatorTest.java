package snapchat;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class SendSnapEmulatorTest {
	
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
	    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
	    

	    
	    capabilities.setCapability("appPackage", "com.snapchat.android");
	    capabilities.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");
	    
	    driver = new AppiumDriver<MobileElement>(url, capabilities);
	}
	



    @Test
    public void openApp() throws MalformedURLException, InterruptedException
    {
    	
        Date date = new Date();  
        System.out.println(formatter.format(date));  
        
        WebDriverWait wait = new WebDriverWait(driver, 240);
        
        TouchAction t =new TouchAction(driver);

        Thread.sleep(3000);
        
        for (int i = 0; i < 1000; i++) {
        	System.out.println("clicked on big button - " + i );

        	MobileElement emojiiButton = (MobileElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.snapchat.android:id/camera_sounds_button")))); 
        	
        	Thread.sleep(2000);
        	t.tap(PointOption.point(540, 1510)).perform();
        	
        	
        	
        	Thread.sleep(4000);
        	MobileElement send_button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_btn_hint_label")))); 
        	send_button.click();

            
        	
        	Thread.sleep(3000);
        	MobileElement friend = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[6]")))); 
            friend.click();
            
            Thread.sleep(1000);
            MobileElement send = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_to_send_button")))); 
            send.click();
            
            
            Thread.sleep(1500);
            driver.navigate().back();
            
            Thread.sleep(1000);
            
		}
        
        
        

        
    }

}
