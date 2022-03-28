package com.tmb.tests;

import com.tmb.config.FrameworkConfig;
import com.tmb.config.converters.factory.BrowserStackConfigFactory;
import com.tmb.config.converters.factory.ConfigFactory;
import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.Test;

public class DemoTest {


    @Test
    public void testLogin(){

        FrameworkConfig config = ConfigCache.getOrCreate(FrameworkConfig.class);//-->getOrCreate uses singleTon pattern, as if FrameworkConfig is present it will call it or else create if not present, so that it will have only one instance of that class
        System.out.println(config.browser());

     //   System.out.println(BrowserStackConfigFactory.getConfig().browserStackURL());

//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.quit();
    }



}
