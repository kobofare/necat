package necat.share;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public BaseTest() {
        init();
    }

    public void init() {
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-5p[%d][%t]%C(%L):%m%n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.setTarget("System.out");
        consoleAppender.setEncoding("UTF-8");
        consoleAppender.activateOptions();

        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        // configures the root logger
        rootLogger.removeAllAppenders();
        rootLogger.addAppender(consoleAppender);
    }
}
