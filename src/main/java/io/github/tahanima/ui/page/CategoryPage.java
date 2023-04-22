package io.github.tahanima.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import io.github.tahanima.ui.component.Table;

import lombok.Getter;

/**
 * @author tahanima
 */
public class CategoryPage extends BasePage {
    @Getter private Table table;

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        table = new Table(page);
    }

    public Locator getCatalogHeader() {
        return page.locator("#Catalog > h2");
    }

    public Locator getProductIdDataAt(int row) {
        return table.getData(row, 0);
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
