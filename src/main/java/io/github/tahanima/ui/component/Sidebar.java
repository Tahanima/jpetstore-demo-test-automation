package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class Sidebar {
    private final Page page;

    public Sidebar(Page page) {
        this.page = page;
    }

    public Locator getContent() {
        return page.locator("#SidebarContent");
    }

    private Locator getAllLinks() {
        return page.locator("#SidebarContent > a");
    }

    public Locator getFishLink() {
        return getAllLinks().nth(0);
    }

    public Locator getDogsLink() {
        return getAllLinks().nth(1);
    }

    public Locator getCatsLink() {
        return getAllLinks().nth(2);
    }

    public Locator getReptilesLink() {
        return getAllLinks().nth(3);
    }

    public Locator getBirdsLink() {
        return getAllLinks().nth(4);
    }
}
