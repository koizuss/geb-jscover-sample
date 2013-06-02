import org.openqa.selenium.chrome.ChromeDriver
import geb.report.ScreenshotAndPageSourceReporter
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.Proxy

driver = {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();

    // for chromedriver
    // capabilities.setCapability("chrome.switches", [
    //                            "--proxy-server=http://localhost:9999",
    //                            "--allow-file-access-from-files"
    //                            ]);

    // for chromedriver2
    Proxy proxy = new Proxy()
    proxy.setHttpProxy("http://localhost:9999")
    capabilities.setCapability("proxy", proxy)

    ChromeOptions options = new ChromeOptions()
    options.addArguments("--allow-file-access-from-files")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    ChromeDriver driver = new ChromeDriver(capabilities);

    // @see https://code.google.com/p/chromedriver/wiki/CapabilitiesAndSwitches
}

waiting {
    timeout = 10
    retryInterval = 1
}

reporter = new ScreenshotAndPageSourceReporter() {
    @Override
    protected escapeFileName(String name) {4
        // name.replaceAll("[^\\w\\s-]", "_")
        name.replaceAll('[\\\\/:\\*?\\"<>\\|]', '_')
    }
}

// reportsDir = System.properties['geb.build.reportsDir']