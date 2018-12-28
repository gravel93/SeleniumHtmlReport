package com.commondeer.retail;

import main.java.ForEveryClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FootterPage extends ForEveryClass {

    @FindBy(xpath = "//div[@class='grid']")
    private List<WebElement> li;

    @FindBy(xpath = "//div[@class='grid']//following-sibling::li")
    private List<WebElement> links;


    public void countLi(){
        for (int i = 0; i <li.size() ; i++) {
            String abc = li.get(i).getText();
            System.out.println(abc);
            int countLinksinFotter = links.size();
            System.out.println(countLinksinFotter);
            Assert.assertEquals(19,countLinksinFotter);
            System.out.println("Number of links matched to requirements");

        }
    }

}
