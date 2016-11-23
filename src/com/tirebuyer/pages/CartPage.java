package com.tirebuyer.pages;

import com.tirebuyer.automation.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by divi on 8/9/2016.
 */
public class CartPage {

    final WebDriver driver;

    @FindBy(xpath = ("//*[@id='installer1']"))
    @CacheLookup
    public WebElement delivery_to_a_tire_buyer_radio_btn;

    @FindBy(xpath = ("//a[@class='deliver-to-installer btn btn-success mt visible-xs']"))
    @CacheLookup
    public List<WebElement> deliver_to_this_installer_btn;

    @FindBy(xpath = "//a[@id='gotoCheckoutBtn']")
    @CacheLookup
    public WebElement cart_checkout_btn;



    public CartPage(WebDriver driver)

    {
        this.driver = driver;
    }

    public void clickOnDeliveryToATireBuyerInstallerRadioButton()
    {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GenericMethods.click(delivery_to_a_tire_buyer_radio_btn);
        GenericMethods.waitForElementToAppear(driver,deliver_to_this_installer_btn.get(0));

    }

    public void clickOnInstallerRadioButtonByRowNumber(int rownumber)
    {
        GenericMethods.click(deliver_to_this_installer_btn.get(rownumber-1));
        GenericMethods.waitForElementToAppear(driver,cart_checkout_btn);

    }


    public void clickOnCartCheckoutButton()
    {CheckoutPage checkoutpage  = PageFactory.initElements(driver, CheckoutPage.class);
        GenericMethods.click(cart_checkout_btn);
        GenericMethods.waitForElementToAppear(driver,checkoutpage.checkout_with_paypal_btn);
    }
}
