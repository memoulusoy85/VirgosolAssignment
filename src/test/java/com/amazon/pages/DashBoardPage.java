package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;

public class DashBoardPage extends  BasePage{

    public DashBoardPage() { PageFactory.initElements(Driver.get(), this);}


   public Select dropdownSelect;

    @FindBy(id="nav-link-accountList-nav-line-1")
    public WebElement userNameWebElement;

    @FindBy(css="#nav-al-wishlist>a")
    public WebElement myAccount;


    //LIST
    @FindBy(css="input[aria-labelledby=\"createList-announce\"]")
    public WebElement btnCreateList;

    @FindBy(xpath="//input[ @class=\"a-button-input\"][ @type=\"submit\"]")
    public List<WebElement> btnCreateOneList;


    @FindBy(id="list-name")
    public WebElement inputListname;


    @FindBy(xpath="//span[@class='a-button-inner'][.='Liste Oluştur']")
    public WebElement btnSubmitListName;


    //CATEGORY
    @FindBy(id="searchDropdownBox")
    public WebElement dropdownCategoryList;

    //SearchBox
    @FindBy(id="twotabsearchtextbox")
    public WebElement inputSearchBox;

    @FindBy(id="nav-search-submit-button")
    public WebElement btnSearch;

    @FindBy(css=".a-section.a-spacing-small.a-spacing-top-small>span:nth-of-type(3)")
    public WebElement resultSearchVerify;




    public String getUserName(){

      String name= userNameWebElement.getText().substring(0,5);
        Log.info("getUserName() method , SUCCESS");

       return name;
    }

    public void createList(String listName){

        BrowserUtils.hover(btnHello);
        myAccount.click();
        btnCreateList.click();

       if(btnCreateOneList.size()!=0){
          // new WebDriverWait(Driver.get(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[ @class=\"a-button-input\"][ @type=\"submit\"]")));
           btnCreateOneList.get(0).click();
       }


        new WebDriverWait(Driver.get(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("list-name")));
        inputListname.click();
        inputListname.clear();
        inputListname.sendKeys(listName);

       // new WebDriverWait(Driver.get(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-button-inner'][.='Liste Oluştur']")));
        btnSubmitListName.click();
        BrowserUtils.waitFor(3);

        Log.info("createList() method , SUCCESS");

    }


   public void  selectCategory(String category){

          dropdownSelect = new Select(Driver.get().findElement(By.id("searchDropdownBox")));
          dropdownSelect.selectByVisibleText("Bilgisayarlar");
           BrowserUtils.waitFor(3);

           Log.info("selectCategory() method, SUCCESS");
    }



    public void  searchProduct(String product){

        new WebDriverWait(Driver.get(),Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        Driver.get().findElement(By.id("twotabsearchtextbox")).sendKeys("msi");
        Driver.get().findElement(By.id("nav-search-submit-button")).click();
        BrowserUtils.waitFor(3);
        Log.info("searchProduct method, SUCCESS");
    }


    public void logout(){
        BrowserUtils.hover(btnHello);
        btnLogout.click();
        Log.info("logout method, SUCCESS");

    }

}
