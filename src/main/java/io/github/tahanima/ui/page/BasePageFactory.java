package io.github.tahanima.ui.page;

import com.microsoft.playwright.Page;

/**
 * @author tahanima
 */
public final class BasePageFactory {
    private BasePageFactory() {}

    public static <T extends BasePage> T createInstance(Page page, Class<T> clazz) {
        try {
            BasePage instance = clazz.getDeclaredConstructor().newInstance();

            instance.setAndConfigurePage(page);
            instance.initializeComponents();

            return clazz.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Page class instantiation failed.");
    }
}
