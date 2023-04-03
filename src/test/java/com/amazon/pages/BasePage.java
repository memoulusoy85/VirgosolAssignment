package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {

   public BasePage() { PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = "#sp-cc-accept")
    public WebElement btnAcceptCookie;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    public WebElement btnHello;

    @FindBy(xpath = "//a[starts-with(@class, 'nav-a')][.='Giriş yap']")
    public WebElement btnEnter;


    @FindBy(css="a[aria-label='2 sayfasına git']")
    public WebElement btnSecondPage;

    @FindBy(id="add-to-wishlist-button-submit")
    public WebElement btnAddToList;


    @FindBy(css="#huc-view-your-list-button>.a-button-inner")
    public WebElement btnViewList;


    @FindBy(css="input[name=\"submit.deleteItem\"]")
    public WebElement btnDeleteProductFromList;

    @FindBy(xpath="//div[.='Silindi'][@class='a-alert-content']")
    public List<WebElement> verifyDeletedProduct;

    @FindBy(css="#nav-item-signout>.nav-text")
    public WebElement btnLogout;














 public void goToPage(String pageNo){

     String pageLocator = "a[aria-label='"+pageNo+" sayfasına git']";

     try {
         BrowserUtils.waitForClickablility(By.cssSelector(pageLocator), Duration.ofSeconds(5));
         WebElement pageElement = Driver.get().findElement(By.cssSelector(pageLocator));
         new Actions(Driver.get()).moveToElement(pageElement).pause(200).click(pageElement).build().perform();
     } catch (Exception e) {
         BrowserUtils.clickWithWait(By.cssSelector(pageLocator), 5);
     }

     Log.info("goToPage method , SUCCESS");
 }


 public void addProductToList (String listNo){
     String productLocator = "div[data-index='"+listNo+"']";

     try {
         BrowserUtils.waitForClickablility(By.cssSelector(productLocator), Duration.ofSeconds(20));
         WebElement productElement = Driver.get().findElement(By.cssSelector(productLocator));
         productElement.click();
         //new Actions(Driver.get()).moveToElement(productElement).pause(200).click(productElement).build().perform();

     } catch (Exception e) {
         BrowserUtils.clickWithWait(By.cssSelector(productLocator), 5);
         Log.error("Product order locator not found");
     }

       BrowserUtils.waitFor(2);
       btnAddToList.click();

     Log.info("addProduct() method , SUCCESS");
 }




}
