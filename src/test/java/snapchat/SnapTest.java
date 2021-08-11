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

public class SnapTest {
	
	AppiumDriver<MobileElement> driver;

    @Test
    public void openApp() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", true);
        cap.setCapability("fullReset", false);
        cap.setCapability("deviceName", "OnePlus 9R");
//        cap.setCapability("udid", "1c585e49");
        cap.setCapability("udid", "1c585e49");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        cap.setCapability("appPackage", "com.snapchat.android");
        cap.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        
        WebDriverWait wait = new WebDriverWait(driver, 240);
        
//        Thread.sleep(400);
        
//        emojiiButton.click();
        
        TouchAction t =new TouchAction(driver);
        
        for (int i = 0; i < 10000; i++) {
//        	Thread.sleep((long)(Math.random() * 1000));
        	System.out.println("clicked on big button - " + i );
        	
        	MobileElement emojiiButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/lenses_camera_button_icon")))); 
        	
        	t.tap(PointOption.point(546, 2043)).perform();

        	
//            MobileElement uploadLens = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='56976340891:SCAN_UNLOCKED']/android.widget.ImageView"));
//            uploadLens.click();
//            Thread.sleep(100);
            
        	
        	MobileElement send_button = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_btn_hint_label")))); 
        	send_button.click();
//            Thread.sleep(100);
            
            
            MobileElement friend = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.View[6]")))); 
            friend.click();
//            Thread.sleep(100);
            
            MobileElement send = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.snapchat.android:id/send_to_send_button")))); 
            send.click();
//            Thread.sleep(100);
            
            driver.navigate().back();
//            Thread.sleep(300);
		}
        
        
        

        System.out.println("App Started");
    }

}
