import config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTitleTest {
    private Logger logger = LogManager.getLogger(CheckTitleTest.class);
    protected static WebDriver driver;
    TestConfig config = ConfigFactory.create(TestConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Веб драйвер успешно запущен");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Веб драйвер успешно завершен");
        }
    }

    @Test
    public void checkTitle() {
        driver.get(config.key());
        logger.info("Открыта страница " + config.key());

        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        assertEquals(expectedTitle, actualTitle);
    }
}
