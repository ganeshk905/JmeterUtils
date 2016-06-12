package script;

import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

/**
 * Created by shantonu on 6/12/16.
 */
public class ScriptGenerator {

    public static HashTree addResultINJMX(HashTree jmx, String jtlPath){
        Summariser summary = new Summariser();
        String name = JMeterUtils.getPropDefault("summriser.name", "summary");
        ResultCollector rc = new ResultCollector(summary);
        rc.setFilename(jtlPath);
        jmx.add(jmx.getArray()[0],rc);
        return jmx;
    }
}
