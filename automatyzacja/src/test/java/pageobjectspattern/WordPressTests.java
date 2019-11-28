package pageobjectspattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.WpMainPage;
import pageobjects.WpNotePage;

import java.util.List;
import java.util.UUID;


public class WordPressTests extends BaseTests
{

    @Test
    void firstNoteAllowsComments()
    {
        //Arrange
        WpMainPage mainPage = WpMainPage.open(getBrowser());

        //Act
        WpNotePage notePage = mainPage.openLatestNote();

        //Assert
        Assertions.assertTrue(notePage.commentsAreAllowed());

    }

    @Test
    void canEnterComment()
    {
        //arrange
        String comment = UUID.randomUUID().toString();
        String author = UUID.randomUUID().toString();
        String email = UUID.randomUUID().toString() + "@gmail.com";
        WpMainPage mainPage = WpMainPage.open(getBrowser());

        //Act
        WpNotePage notePage = mainPage.openLatestNote();
        WpNotePage refreshedNote = notePage.publishComment(comment, author, email);
        Assertions.assertTrue(refreshedNote.hasComment(comment, author));
    }

    @Test
    void canLogIn()
    {
        String check = "http://www.automation.markowicz.pro/wp-admin";
        WpMainPage mainPage = WpMainPage.open(getBrowser());
        WpMainPage logInPrompt = mainPage.logInToWordpress();

        Assertions.assertEquals("http://www.automation.markowicz.pro/wp-admin", check);


    }

    @Test
    void canLogOut()
    {
        WpMainPage mainPage = WpMainPage.open(getBrowser());
        WpMainPage logInPrompt = mainPage.logInToWordpress();
        WpAdminPanel adminPanel = WpAdminPanel.logOut();

    }

}
