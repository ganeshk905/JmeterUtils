import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.report.dashboard.ExportException;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.poi.util.SystemOutLogger;
import utils.JmeterEngineUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by shantonu on 6/6/16.
 * This run the Jmeter via main
 */
public class JmeterTestRunner {

    private static JMeterEngine jmeter = null;

    public static void main(String... args) {
        runLocalJmx();
    }

    public static void runLocalJmx() {
        jmeter = JmeterEngineUtils.initLocalJmeter();
        JmeterEngineUtils.start(jmeter);

    }

    public void runWithJmx(String jmxPath, String propertyPath, String homePath) {
    }


}
