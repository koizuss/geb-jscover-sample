import org.openqa.selenium.chrome.ChromeDriver
import geb.report.ScreenshotAndPageSourceReporter
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability("chrome.switches",
                               [
                                "--proxy-server=http://localhost:3128",
                                "--allow-file-access-from-files"
                                ]);
    new ChromeDriver(capabilities)
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