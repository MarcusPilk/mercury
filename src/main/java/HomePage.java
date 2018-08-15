import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
    WebElement registerLink;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
    WebElement signOutLink;


    public void registerButton(){
        registerLink.click();
    }

    public void signOffButton(){
        signOutLink.click();
    }

    public Boolean checkSignedIn(){
        if(signOutLink.getText().equals("SIGN-OFF")){
            return true;
        }else{
            return false;
        }
    }
}
