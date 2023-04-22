package io.github.tahanima.e2e;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static io.github.tahanima.util.DataProviderUtils.processCsv;

import io.github.tahanima.data.CategoryTestData;
import io.github.tahanima.ui.page.CategoryPage;
import io.github.tahanima.ui.page.HomePage;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author tahanima
 */
public class CategoryE2ETest extends BaseE2ETest {
    private static final String CSV_FILE_PATH = "e2e/category.csv";
    private HomePage homePage;
    private CategoryPage categoryPage;

    @Override
    public void initialize() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
        homePage = createInstance(HomePage.class);
        categoryPage = createInstance(CategoryPage.class);

        homePage.navigateToUrl();
    }

    @Override
    public void cleanup() {
        browserContext.close();
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailureAndRedirectToHomePage(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            homePage.captureFullPageScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }

        homePage.navigateToUrl();
    }

    @DataProvider(name = "categoryData")
    public Object[][] getCategoryData(Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processCsv(CategoryTestData.class, getTestDataFilePath(CSV_FILE_PATH), testCaseId);
    }

    @Test(
            testName = "TC-1",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testHeaderTextShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getCatalogHeader()).hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-2",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testProductIdShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getProductIdDataAt(Integer.parseInt(testData.getRow().trim())))
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-3",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testProductNameShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getNameDataAt(Integer.parseInt(testData.getRow().trim())))
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-4",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testProductIdLinkShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getProductIdLinkAt(Integer.parseInt(testData.getRow().trim())))
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-5",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testBackLinkShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getBackLink())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-6",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testBackLinkTextShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getBackLink()).hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-7",
            dataProvider = "categoryData",
            groups = {"regression"})
    public void testTableHeaderTextsShouldBeCorrect(CategoryTestData testData) {
        switch (testData.getCategory()) {
            case "Fish" -> homePage.getQuickLinks().clickOnFishLink();
            case "Dogs" -> homePage.getQuickLinks().clickOnDogsLink();
            case "Reptiles" -> homePage.getQuickLinks().clickOnReptilesLink();
            case "Cats" -> homePage.getQuickLinks().clickOnCatsLink();
            case "Birds" -> homePage.getQuickLinks().clickOnBirdsLink();
        }

        assertThat(categoryPage.getTable().getAllColumnHeaders())
                .hasText(testData.getExpectedOutcome().trim().split("\\|"));
    }
}
