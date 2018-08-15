import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountSuccessPage {

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[1]")
    WebElement signIn;

    public void signIn(){
        signIn.click();
    }
}
