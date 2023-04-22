package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class QuickLinks {
    private final Page page;

    public QuickLinks(Page page) {
        this.page = page;
    }

    private Locator getAllLinks() {
        return page.locator("#QuickLinks > a");
    }

    public Locator getFishLink() {
        return getAllLinks().nth(0);
    }

    public void clickOnFishLink() {
        getFishLink().click();
    }

    public Locator getDogsLink() {
        return getAllLinks().nth(1);
    }

    public void clickOnDogsLink() {
        getDogsLink().click();
    }

    public Locator getReptilesLink() {
        return getAllLinks().nth(2);
    }

    public void clickOnReptilesLink() {
        getReptilesLink().click();
    }

    public Locator getCatsLink() {
        return getAllLinks().nth(3);
    }

    public void clickOnCatsLink() {
        getCatsLink().click();
    }

    public Locator getBirdsLink() {
        return getAllLinks().nth(4);
    }

    public void clickOnBirdsLink() {
        getBirdsLink().click();
    }
}
