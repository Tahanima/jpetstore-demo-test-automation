package io.github.tahanima.ui.page;

import static io.github.tahanima.config.ConfigurationManager.config;

import io.github.tahanima.ui.component.MainImage;
import io.github.tahanima.ui.component.Sidebar;

import lombok.Getter;

/**
 * @author tahanima
 */
public class HomePage extends BasePage {
    @Getter private Sidebar sidebar;
    @Getter private MainImage mainImage;

    @Override
    public void initializeComponents() {
        super.initializeComponents();

        sidebar = new Sidebar(page);
        mainImage = new MainImage(page);
    }

    public void navigateToUrl() {
        page.navigate(config().baseUrl());
    }
}
