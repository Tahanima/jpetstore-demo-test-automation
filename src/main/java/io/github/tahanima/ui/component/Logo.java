package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class Logo {
    private final Page page;

    public Logo(Page page) {
        this.page = page;
    }

    public Locator getLink() {
        return page.locator("#LogoContent > a");
    }

    public Locator getImage() {
        return page.locator("#LogoContent > a > img");
    }
}
