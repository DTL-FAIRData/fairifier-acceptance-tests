import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    def phantomjs = new PhantomJSDriver(new DesiredCapabilities())
    phantomjs
}