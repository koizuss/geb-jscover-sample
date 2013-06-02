import org.openqa.selenium.chrome.ChromeDriver
import geb.report.ScreenshotAndPageSourceReporter
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.Proxy

driver = {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    // Add the WebDriver proxy capability.
    // Proxy proxy = new Proxy();
    // proxy.setHttpProxy("localhost:9999");
    // capabilities.setCapability("proxy", proxy)

    // capabilities.setCapability("args",
    //     Arrays.asList("--disable-web-security","--allow-file-access-from-files"))

    // Add ChromeDriver-specific capabilities through ChromeOptions.
    // ChromeOptions options = new ChromeOptions()
    // options.addArguments("--disable-web-security")
    // options.addArguments("--allow-file-access-from-files")
    // options.addArguments("--user-data-dir=" + new File('.').getAbsolutePath())
    // capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    capabilities.setCapability("chrome.switches", [
                               "--proxy-server=http://localhost:9999",
                               "--allow-file-access-from-files"
                               ]);

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