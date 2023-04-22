package io.github.tahanima.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

/**
 * @author tahanima
 */
public class SignOnPage extends BasePage {
    public Locator getStartingNote() {
        return page.locator("#Catalog").getByRole(AriaRole.PARAGRAPH).nth(0);
    }

    public Locator getUsernameAndPasswordLabels() {
        return page.locator("#Catalog").getByRole(AriaRole.PARAGRAPH).nth(1);
    }

    public SignOnPage fillUsernameInTextBox(String username) {
        page.locator("[name=username]").fill("");
        page.locator("[name=username]").fill(username);

        return this;
    }

    public SignOnPage fillPasswordInTextBox(String password) {
        page.locator("[name=password]").fill("");
        page.locator("[name=password]").fill(password);

        return this;
    }

    public Locator getLoginButton() {
        return page.locator("[name=signon]");
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void clickOnRegisterNowLink() {
        page.locator("#Catalog > a");
    }

    public Locator getEndingNote() {
        return page.locator("#Catalog:not(form)");
    }
}
