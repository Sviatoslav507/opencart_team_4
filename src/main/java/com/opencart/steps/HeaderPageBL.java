package com.opencart.steps;

import com.opencart.driver.DriverRepository;
import com.opencart.enums.Currencies;
import com.opencart.pages.CartPage;
import com.opencart.pages.HeaderPage;
import com.opencart.pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageBL {

    private HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.getMyAccountButton().click();
        return this;
    }

    public RegisterPageBL clickOnRegisterButton() {
        headerPage.getHeaderRegisterButton().click();
        return new RegisterPageBL();
    }

    public LoginPageBL clickOnLoginButton(){
        headerPage.getHeaderLoginButton().click();
        return new LoginPageBL();
    }

    public CartPageBL clickOnHeaderUpperCartButton(){
        headerPage.getHeaderUpperCart().click();
        return new CartPageBL();
    }

    /*public SharePageBL clickOnHeaderShareButton(){
        headerPage.getHeaderShareButton().click();
        return new SharePageBL();
    }*/

    public HeaderPageBL headerCurrencyCaretDownClick(){
        headerPage.getHeaderCurrencyCaretDown().click();
        return this;
    }

    public HeaderPageBL headerCurrencyChoose(String Currencies){
        for(WebElement current : headerPage.getHeaderCurrencyList()){
            if(current != null & current.getAttribute("name").equalsIgnoreCase(Currencies)){
                current.click();
                break;
            }
        }
        return this;
    }

    public SearchPageBL useSearch(String product){
        headerPage.getSearch().click();
        headerPage.getSearch().clear();
        headerPage.getSearch().sendKeys(product);
        headerPage.getSearchStringSubmit().click();
        return new SearchPageBL();
    }

}
