import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")
    WebElement usernameLogin;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
    WebElement passwordLogin;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")
    WebElement submitLogin;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
    WebElement homeButton;

    public void logIn(String username, String password){
        usernameLogin.sendKeys(username);
        passwordLogin.sendKeys(password);
        submitLogin.click();
        homeButton.click();
    }

}
