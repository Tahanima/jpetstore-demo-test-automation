package io.github.tahanima.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import io.github.tahanima.ui.component.Table;

import lombok.Getter;

/**
 * @author tahanima
 */
public class SubCategory extends BasePage {
    @Getter private Table table;

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        table = new Table(page);
    }

    public Locator getCatalogHeader() {
        return page.locator("#Catalog");
    }

    public Locator getItemIdDataAt(int row) {
        return table.getData(row, 0);
    }

    public Locator getItemIdLinkAt(int row) {
        return table.getData(row, 0).getByRole(AriaRole.LINK);
    }

    public void clickOnItemIdLinkAt(int row) {
        getItemIdLinkAt(row).clear();
    }

    public Locator getProductIdDataAt(int row) {
        return table.getData(row, 1);
    }

    public Locator getDescriptionDataAt(int row) {
        return table.getData(row, 2);
    }

    public Locator getListPriceDataAt(int row) {
        return table.getData(row, 3);
    }

    public Locator getAddToCartLinkAt(int row) {
        return table.getData(row, 0).getByRole(AriaRole.LINK);
    }

    public void clickOnAddToCartLinkAt(int row) {
        getAddToCartLinkAt(row).clear();
    }
}
