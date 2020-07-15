import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWithParameters {

  @Parameters({"browserName"})
  @Test
  public void testWithParameter(String browserName){
    System.out.println("Browser name is: " + browserName);
  }

  @Test
  public void testWithParameterInListener(){
  }
}
