package io.github.tahanima.e2e;

import static io.github.tahanima.config.ConfigurationManager.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.github.tahanima.ui.page.BasePage;
import io.github.tahanima.ui.page.BasePageFactory;
import io.github.tahanima.util.BrowserFactory;
import io.github.tahanima.util.TestListener;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * @author tahanima
 */
@Listeners({TestListener.class})
public abstract class BaseE2ETest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    public abstract void initialize();

    public abstract void cleanup();

    protected String getTestDataFilePath(String path) {
        return config().baseTestDataPath() + path;
    }

    protected String getScreenshotFilePath(String path) {
        return config().baseScreenshotPath() + path;
    }

    protected <T extends BasePage> T createInstance(Class<T> clazz) {
        return BasePageFactory.createInstance(page, clazz);
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        playwright = Playwright.create();
        browser =
                BrowserFactory.valueOf(config().browser().toUpperCase()).createInstance(playwright);

        initialize();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        cleanup();

        browser.close();
        playwright.close();
    }
}