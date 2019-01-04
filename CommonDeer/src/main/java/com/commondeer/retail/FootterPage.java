package com.commondeer.retail;

import com.aplicationpagebase.ApplicationPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FootterPage extends ApplicationPageBase {

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

        }
    }

}
