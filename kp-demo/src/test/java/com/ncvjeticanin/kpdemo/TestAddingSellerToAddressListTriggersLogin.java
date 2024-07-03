package com.ncvjeticanin.kpdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddingSellerToAddressListTriggersLogin extends BaseTest {

    @Test
    public void testAddingSellerToAddressListTriggersLogin() {
        findAndCLickElementWhenAvailable(By.xpath("//a[@href='" + "/najnoviji/1" + "']"));
        findAndCLickElementWhenAvailable(By.xpath("//article/a"));
        findAndCLickElementWhenAvailable(By.xpath("//span[contains(text(), 'Dodaj u adresar')]"));
        WebElement loginModalWindow = findAndCLickElementWhenAvailable(By.className("Modal_modalBody__usSbO"));
        Assert.assertTrue(loginModalWindow.isDisplayed());
        Assert.assertTrue(loginModalWindow.isEnabled());
    }
}
