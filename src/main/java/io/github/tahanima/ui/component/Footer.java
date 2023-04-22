package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class Footer {
    private final Page page;

    public Footer(Page page) {
        this.page = page;
    }

    public Locator getPoweredByLink() {
        return page.locator("#PoweredBy > a");
    }
}
