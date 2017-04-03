import org.openqa.selenium.Dimension
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

driver = {
    def phantomjs = new PhantomJSDriver(new DesiredCapabilities())
    phantomjs.manage().window().setSize(new Dimension(1024, 768))
    phantomjs
}
