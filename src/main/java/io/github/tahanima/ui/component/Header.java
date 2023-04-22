package io.github.tahanima.ui.component;

import com.microsoft.playwright.Page;

import lombok.Getter;

/**
 * @author tahanima
 */
public final class Header {
    @Getter private final Logo logo;
    @Getter private final Menu menu;
    @Getter private final Search search;

    public Header(Page page) {
        logo = new Logo(page);
        menu = new Menu(page);
        search = new Search(page);
    }
}
