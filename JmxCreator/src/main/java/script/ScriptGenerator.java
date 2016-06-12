package script;

import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

/**
 * Created by shantonu on 6/12/16.
 */
public class ScriptGenerator {
    private static HashTree jmxTree = null;
    public static HashTree addResultINJMX(HashTree jmx, String jtlPath){
        Summariser summary = new Summariser();
        String name = JMeterUtils.getPropDefault("summriser.name", "summary");
        ResultCollector rc = new ResultCollector(summary);
        rc.setFilename(jtlPath);
        jmx.add(jmx.getArray()[0],rc);
        return jmx;
    }
    private static HashTree getTestPlan() {
        if(jmxTree==null){
            jmxTree = new HashTree();
        }
        return jmxTree;
    }
    public static HashTree createTestPlan(String name){
        HashTree testPlanTree = getTestPlan();
        TestPlan testPlan = new TestPlan(name);
        jmxTree.add("testPlan", testPlan);
        //jmxTree.add("loopController",getLoopController("Loop",5));
        jmxTree.add("threadGroup",getThreadGroup("MyThreadGroup",20, 600, getLoopController("Loop",200)));
        jmxTree.add("httpSampler",getAnHttp("Google"));
        return testPlanTree;

    }
}
