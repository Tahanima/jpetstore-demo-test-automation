package io.github.tahanima.ui.page;

import static io.github.tahanima.config.ConfigurationManager.config;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import io.github.tahanima.ui.component.Footer;
import io.github.tahanima.ui.component.Header;
import io.github.tahanima.ui.component.QuickLinks;

import lombok.Getter;

import java.nio.file.Path;

/**
 * @author tahanima
 */
public class BasePage {
    protected Page page;

    @Getter private Header header;
    @Getter private Footer footer;
    @Getter private QuickLinks quickLinks;

    public void setAndConfigurePage(Page page) {
        this.page = page;
        page.setDefaultTimeout(config().timeout());
    }

    public void initializeComponents() {
        header = new Header(page);
        footer = new Footer(page);
        quickLinks = new QuickLinks(page);
    }

    public Locator getBackLink() {
        return page.locator("#BackLink > a");
    }

    public void clickOnBackLink() {
        getBackLink().click();
    }

    private String getScreenshotFilePath(String path) {
        return config().baseScreenshotPath() + path;
    }

    public void captureFullPageScreenshot(String fileName) {
        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Path.of(String.format("%s.png", getScreenshotFilePath(fileName))))
                        .setFullPage(true));
    }

    public void captureWebElementScreenshot(Locator locator, String fileName) {
        locator.screenshot(
                new Locator.ScreenshotOptions()
                        .setPath(
                                Path.of(String.format("%s.png", getScreenshotFilePath(fileName)))));
    }
}
