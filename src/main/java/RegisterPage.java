import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy (id = "email")
    WebElement emailBox;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
    WebElement passwordBox1;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input")
    WebElement passwordBox2;

    @FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input")
    WebElement submitButton;


    public void enterDetails(String username, String password1, String password2){
        emailBox.sendKeys(username);
        passwordBox1.sendKeys(password1);
        passwordBox2.sendKeys(password2);
        submitButton.click();
    }


}
