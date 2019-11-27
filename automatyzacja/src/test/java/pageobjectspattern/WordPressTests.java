package pageobjects;

import org.junit.jupiter.api.Assertions;

public class WordPressTests extends BaseTests
{
    @Test
    void firstNoteAllowsComments()
    {
        //Arrange
        var WpMainPage mainPage = WpMainPage.open();

        //Act
        var WpNotePage notePage = mainPage.openLatestNote();

        //Assert
        Assertions.assertTrue(notePage.commentsAreAllowed());

    }
}
