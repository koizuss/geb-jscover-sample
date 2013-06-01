import org.openqa.selenium.chrome.ChromeDriver
import geb.report.ScreenshotAndPageSourceReporter

driver = { new ChromeDriver() }

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