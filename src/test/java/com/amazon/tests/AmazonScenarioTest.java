package com.amazon.tests;


import com.amazon.pages.DashBoardPage;
import com.amazon.pages.LoginPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonScenarioTest extends TestBase {


    @Test
    public void amazonScenario() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr/");
        Log.info("Amazon.com.tr sayfasi acildi, SUCCESS");

        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.btnAcceptCookie.click();
        BrowserUtils.hover(dashBoardPage.btnHello);
        dashBoardPage.btnEnter.click();
        Log.info("Login page opened, SUCCESS");

        //Login page and assert
        new LoginPage().login();
        Assert.assertEquals(dashBoardPage.getUserName(), "Kenan");
        Log.info("Login done, Success");

        //create Virgosol List
        dashBoardPage.createList("Virgosol");
        Log.info("Virgosol List was created, Success");

        //select category and asssert
        dashBoardPage.selectCategory("Bilgisayarlar");
        Assert.assertEquals(dashBoardPage.dropdownSelect.getFirstSelectedOption().getText(), "Bilgisayarlar");
        Log.info("Category Bilgisayar was selected, Success");

        //input "msi" and assert
        dashBoardPage.searchProduct("msi");
        Assert.assertEquals(dashBoardPage.resultSearchVerify.getText(),"\"msi\"");
        Log.info("msi was searched on searchbox, Success");

         // go to page "2" and assert
        dashBoardPage.goToPage("2");
        Assert.assertEquals(driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-selected")).getText(),"2");
        Log.info("page 2 was opened, Success");


        // add 2.product to List  and assert
        dashBoardPage.addProductToList("2");
        Assert.assertEquals(driver.findElement(By.cssSelector("#huc-atwl-header-section>div>.a-size-medium-plus")).getText(),"1 ürün şuraya eklendi:");
        Log.info(" Second product was selected, Success");


         //go to list and assert
        dashBoardPage.btnViewList.click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#my-lists-tab>a")).getText(),"Listelerim");
        Log.info(" Second product was added to List, Success");

        //delete product from list and assert
        dashBoardPage.btnDeleteProductFromList.click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(dashBoardPage.verifyDeletedProduct.size()!=0,"Product removed from List");
        Log.info(" Product was deleted from  List, Success");

        //logout and assert
        dashBoardPage.logout();
        Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='a-spacing-small']")).getText(),"Giriş yap");
        Log.info("Logout from amazon.com.tr  done, Success");



    }




}