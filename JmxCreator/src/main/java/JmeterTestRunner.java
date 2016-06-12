import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.report.dashboard.ExportException;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

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
        new JmeterTestRunner().run();
    }

    public void run() {

    }

    public void runWithJmx(String jmxPath, String propertyPath, String homePath) {
    }

    public static void start() {
        try {
            jmeter.runTest();
        } catch (JMeterEngineException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        try {
            jmeter.stopTest(true);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void initLocalJmeter(){
        String home = System.getProperty("user.dir")+"/apacheJmeter";
        initLocalJmeter(jmeter, home+"/bin/jmeter.properties",home);
    }
    public static JMeterEngine initLocalJmeter(JMeterEngine engine,String propertyPath, String homePath){
        engine = new StandardJMeterEngine();
        if(homePath.equals(null)){
            homePath=System.getProperty("user.dir")+ File.separator+"RunJmeter";
        }
        if(propertyPath.equals(null)){
            propertyPath = homePath+File.separator+"bin"+File.separator+"jmeter.properties";
        }

        JMeterUtils.loadJMeterProperties(propertyPath);
        JMeterUtils.setJMeterHome(homePath);
        JMeterUtils.initLogging();
        JMeterUtils.initLocale();
        try {
            SaveService.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return engine;
    }

    public static JMeterEngine loadJmx(JMeterEngine engine, String path) throws IOException {
            //FileInputStream fis = new FileInputStream(new File(path)); => old way, you need to close
        HashTree jmx =  SaveService.loadTree(new File(path));
        engine.configure(jmx);
        return engine;
    }
}
