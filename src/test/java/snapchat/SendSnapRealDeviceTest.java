package snapchat;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class SendSnapRealDeviceTest {
	
	AppiumDriver<MobileElement> driver;

    @Test
    public void openApp() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", true);
        cap.setCapability("fullReset", false);
        cap.setCapability("deviceName", "OnePlus 9R");
        
        // Provide your device UDID - command to get it - "adb devices"
        cap.setCapability("udid", "1c585e49");
        
     	// Provide your device platform
        cap.setCapability("platformName", "Android");
        
        // Provide your device platformVersion visible in Phone settings
        cap.setCapability("platformVersion", "11");
        
        
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        cap.setCapability("appPackage", "com.snapchat.android");
        cap.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");

        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        
        WebDriverWait wait = new WebDriverWait(driver, 240);
        
        //wait for activity to launch
        Thread.sleep(1000);
        
        TouchAction t =new TouchAction(driver);
        
        for (int i = 0; i < 10000; i++) {
        	System.out.println("clicked on big button - " + i );
        	
        	// wait for emojiIcon to appear
        	MobileElement emojiiButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/lenses_camera_button_icon")))); 
        	
        	// click on camera button
        	t.tap(PointOption.point(546, 2043)).perform();

        	// wait for send_button to appear and then click       	
        	MobileElement send_button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_btn_hint_label")))); 
        	send_button.click();
            
        	// wait for friend list to be visible and then click - Modify View[6] to any number 
            MobileElement friend = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[6]")))); 
            friend.click();
            
            // wait for send to appear and then click     
            MobileElement send = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_to_send_button")))); 
            send.click();
            
            // Go back to main page 
            driver.navigate().back();
		}

    }

}
