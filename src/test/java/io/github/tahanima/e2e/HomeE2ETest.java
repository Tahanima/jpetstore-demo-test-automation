package io.github.tahanima.e2e;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static io.github.tahanima.util.DataProviderUtils.processCsv;

import static org.testng.Assert.assertEquals;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import io.github.tahanima.data.HomeTestData;
import io.github.tahanima.ui.page.HomePage;
import io.github.tahanima.ui.page.SearchResultPage;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author tahanima
 */
public class HomeE2ETest extends BaseE2ETest {
    private static final String CSV_FILE_PATH = "e2e/home.csv";
    private static final String IMG_FILE_PATH = "baseline/";
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @Override
    public void initialize() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
        homePage = createInstance(HomePage.class);
        searchResultPage = createInstance(SearchResultPage.class);

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

    @DataProvider(name = "homeData")
    public Object[][] getHomeData(Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processCsv(HomeTestData.class, getTestDataFilePath(CSV_FILE_PATH), testCaseId);
    }

    @Test(
            testName = "TC-1",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testPageTitleShouldBeCorrect(HomeTestData testData) {
        assertThat(page).hasTitle(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-2",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testLogoLinkShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getLogo().getLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-3",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testLogoImageShouldBeCorrect(HomeTestData testData) {
        homePage.captureWebElementScreenshot(homePage.getHeader().getLogo().getImage(), "logo");

        BufferedImage expected =
                ImageComparisonUtil.readImageFromResources(
                        getTestDataFilePath(IMG_FILE_PATH + "logo.png"));

        BufferedImage actual =
                ImageComparisonUtil.readImageFromResources(getScreenshotFilePath("logo.png"));

        ImageComparisonResult imageComparisonResult =
                new ImageComparison(expected, actual).compareImages();

        assertEquals(imageComparisonResult.getImageComparisonState(), ImageComparisonState.MATCH);
    }

    @Test(
            testName = "TC-4",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testShoppingCartLinkShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getMenu().getShoppingCartLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-5",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSignInLinkShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getMenu().getSignInLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-6",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSignInTextShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getMenu().getSignInLink())
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-7",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testHelpLinkShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getMenu().getHelpLink())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-8",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testHelpTextShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getMenu().getHelpLink())
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-9",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSearchButtonTextShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getHeader().getSearch().getSearchButton())
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-10",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSearchWithKeywordShouldTakeToSearchResult(HomeTestData testData) {
        homePage.getHeader()
                .getSearch()
                .fillInSearchKeywordTextBox(testData.getSearchKeyword())
                .clickOnSearchButton();

        assertThat(searchResultPage.getTable().get()).hasCount(1);
    }

    @Test(
            testName = "TC-11",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testQuickLinkForFishShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getQuickLinks().getFishLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-12",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testQuickLinkForDogsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getQuickLinks().getDogsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-13",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testQuickLinkForReptilesShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getQuickLinks().getReptilesLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-14",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testQuickLinkForCatsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getQuickLinks().getCatsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-15",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testQuickLinkForBirdsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getQuickLinks().getBirdsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-16",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarLinkForFishShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getFishLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-17",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarLinkForDogsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getDogsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-18",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarLinkForReptilesShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getReptilesLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-19",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarLinkForCatsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getCatsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-20",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarLinkForBirdsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getBirdsLink())
                .hasAttribute("href", Pattern.compile(testData.getExpectedOutcome().trim()));
    }

    @Test(
            testName = "TC-21",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testSidebarTextContentShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getSidebar().getContent())
                .hasText(testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-22",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForBirdsInCenterShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getBirdsArea(true))
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-23",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForFishShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getFishArea())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-24",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForDogsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getDogsArea())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-25",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForReptilesShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getReptilesArea())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-26",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForCatsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getCatsArea())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-27",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testMainImageLinkForBirdsShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getMainImage().getBirdsArea(false))
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }

    @Test(
            testName = "TC-28",
            dataProvider = "homeData",
            groups = {"regression"})
    public void testPoweredByLinkInFooterShouldBeCorrect(HomeTestData testData) {
        assertThat(homePage.getFooter().getPoweredByLink())
                .hasAttribute("href", testData.getExpectedOutcome().trim());
    }
}
