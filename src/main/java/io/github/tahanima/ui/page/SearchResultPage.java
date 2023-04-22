package io.github.tahanima.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import io.github.tahanima.ui.component.Table;

import lombok.Getter;

/**
 * @author tahanima
 */
public class SearchResultPage extends BasePage {
    @Getter private Table table;

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        table = new Table(page);
    }

    public Locator getBackLink() {
        return page.locator("#BackLink").getByRole(AriaRole.LINK);
    }

    public Locator getProductImage(int row) {
        return table.getData(row, 0).getByRole(AriaRole.IMG);
    }

    public Locator getProductLink(int row) {
        return table.getData(row, 0).getByRole(AriaRole.LINK);
    }

    public Locator getProductIdDataAt(int row) {
        return table.getData(row, 1);
    }

    public Locator getProductIdLinkAt(int row) {
        return getProductIdDataAt(row).getByRole(AriaRole.LINK);
    }

    public void clickOnProductIdLinkAt(int row) {
        getProductIdLinkAt(row).click();
    }

    public Locator getNameDataAt(int row) {
        return table.getData(row, 1);
    }
}
