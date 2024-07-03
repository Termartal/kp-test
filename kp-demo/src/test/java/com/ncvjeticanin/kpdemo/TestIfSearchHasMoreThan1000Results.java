package com.ncvjeticanin.kpdemo;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIfSearchHasMoreThan1000Results extends BaseTest {


    @Test
    public void testSearchReturnsMoreThan1000Results(){
        findAndCLickElementWhenAvailable(By.id("arrowDown"));
        findAndCLickElementWhenAvailable(By.id("react-select-categoryId-input"));
        findAndCLickElementWhenAvailable(By.xpath("//a[@href='" + "/odeca-zenska/kategorija/743" + "']"));
        findAndCLickElementWhenAvailable(By.xpath("//a[@href='" + "/odeca-zenska/bluze/grupa/743/1992/1" + "']"));

        WebElement priceForm = findAndCLickElementWhenAvailable(By.id("priceFrom"));
        priceForm.sendKeys("100");

        WebElement condition = findAndCLickElementWhenAvailable(By.id("react-select-condition-input"));
        condition.sendKeys("Novo");
        condition.sendKeys(Keys.ENTER);

        WebElement conditionRepeated = findAndCLickElementWhenAvailable(By.id("react-select-condition-input"));
        conditionRepeated.sendKeys("nekorisceno");
        conditionRepeated.sendKeys(Keys.ENTER);
        findAndCLickElementWhenAvailable(By.className("Button_children__tDTVo"));


        WebElement count =findAndCLickElementWhenAvailable(By.xpath("//div[@class='BreadcrumbHolder_breadcrumbHolder__riFtq']/div/div/span/div/span"));
        if(!count.isDisplayed()){
            throw new RuntimeException("Element that displays item count not available");
        }
        String resultText = count.getText();
        Integer number = Integer.parseInt(resultText.split(" ")[0].replaceAll("[^0-9]", ""));
        Assert.assertTrue(number > 1000);

    }


}

