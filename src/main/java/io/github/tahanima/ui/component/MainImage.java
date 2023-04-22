package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class MainImage {
    private final Page page;

    public MainImage(Page page) {
        this.page = page;
    }

    public Locator getAllAreas() {
        return page.locator("[name=estoremap] > area");
    }

    public Locator getBirdsArea(boolean isParent) {
        return isParent ? getAllAreas().nth(0) : getAllAreas().nth(5);
    }

    public Locator getFishArea() {
        return getAllAreas().nth(1);
    }

    public Locator getDogsArea() {
        return getAllAreas().nth(2);
    }

    public Locator getReptilesArea() {
        return getAllAreas().nth(3);
    }

    public Locator getCatsArea() {
        return getAllAreas().nth(4);
    }
}
