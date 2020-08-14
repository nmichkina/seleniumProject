import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWithParameters {

    @Parameters({"waitTimeOutInSeconds"})
    @Test
    public static void testWithParameterAnnotation(String waitTimeoutInSeconds){
        System.out.println("Timeout: "+ waitTimeoutInSeconds);
    }

    @Test
    public static void testWithParameterInListener(){

    }
}
