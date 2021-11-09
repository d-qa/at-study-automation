package at.study.automation.test.uiTestCase.testUI;

import at.study.automation.model.users.User;
import at.study.automation.test.uiTestCase.BaseUITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static at.study.automation.ui.browser.BrowserUtils.getElementsText;
import static at.study.automation.utils.CompareUtils.assertListSortedByUserAsc;
import static at.study.automation.utils.CompareUtils.assertListSortedByUserDesc;

public class tk_6SortedListUsersByUser extends BaseUITest {

    private User admin;

    @BeforeMethod
    public void prepareFixtures() {

        admin = new User() {{
            setIsAdmin(true);
        }}.create();

        User userOne = new User() {{
            setIsAdmin(false);
        }}.create();

        User userTwo = new User() {{
            setIsAdmin(false);
        }}.create();

        openBrowser("login");

    }

    @Test
    public void SortedListTest() throws InterruptedException {

        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();

        List<String> usersList = getElementsText(userTablePage.usersList);
        assertListSortedByUserDesc(usersList);

        userTablePage.button("Пользователь").click();
        List<String> usersListAsc = getElementsText(userTablePage.usersList);
        assertListSortedByUserAsc(usersListAsc);
    }
}
