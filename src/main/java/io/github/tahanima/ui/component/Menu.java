package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class Menu {
    private final Page page;

    public Menu(Page page) {
        this.page = page;
    }

    private Locator getAllLinks() {
        return page.locator("#MenuContent > a");
    }

    public Locator getShoppingCartLink() {
        return getAllLinks().nth(0);
    }

    public Locator getSignInLink() {
        return getAllLinks().nth(1);
    }

    public Locator getHelpLink() {
        return getAllLinks().nth(2);
    }
}
