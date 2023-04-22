package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class Search {
    private final Page page;

    public Search(Page page) {
        this.page = page;
    }

    public Locator getSearchKeywordTextBox() {
        return page.locator("[name=keyword]");
    }

    public Search fillInSearchKeywordTextBox(String searchKeyword) {
        getSearchKeywordTextBox().clear();
        getSearchKeywordTextBox().fill(searchKeyword);

        return this;
    }

    public Locator getSearchButton() {
        return page.locator("[name=searchProducts]");
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }
}
