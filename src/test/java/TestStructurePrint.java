import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestStructurePrint{


    @BeforeMethod
    public void setUp() {
        // любой Java Code
        System.out.println("I'm BeforeMethod");
    }


//    @Test()
//    public void unsuccessfulTest() {
//        assertFalse(1==0);
//        System.out.println("I'm Unsuccessful Test");
//    }

    @Test
    public void successfulTest(){
        assertTrue(1==1);
        System.out.println("I'm successful Test");
    }
    @AfterMethod

    public void tearDown() {
        System.out.println("I'm AfterMethod");
    }
}
