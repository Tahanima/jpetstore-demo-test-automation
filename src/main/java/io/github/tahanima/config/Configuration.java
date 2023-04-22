package io.github.tahanima.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

/**
 * @author tahanima
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:config.properties"})
public interface Configuration extends Config {
    @Key("base.report.path")
    String baseReportPath();

    @Key("base.screenshot.path")
    String baseScreenshotPath();

    @Key("base.test.data.path")
    String baseTestDataPath();

    @Key("base.url")
    String baseUrl();

    @Key("browser")
    String browser();

    @Key("headless")
    boolean headless();

    @Key("slow.motion")
    int slowMotion();

    @Key("timeout")
    int timeout();
}
