package io.github.tahanima.ui.component;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * @author tahanima
 */
public final class Table {
    private final Page page;

    public Table(Page page) {
        this.page = page;
    }

    public Locator get() {
        return page.getByRole(AriaRole.TABLE);
    }

    public Locator getAllColumnHeaders() {
        return get().locator("th");
    }

    public Locator getAllRows() {
        return get().locator("tr");
    }

    public Locator getData(int row, int col) {
        return getAllRows().nth(row + 1).locator("td").nth(col);
    }
}
