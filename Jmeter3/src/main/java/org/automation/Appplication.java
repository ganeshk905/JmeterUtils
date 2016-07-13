package org.automation;

import org.apache.jmeter.NewDriver;
import org.apache.jmeter.util.ShutdownClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by shantonu on 7/12/16.
 * todo
 */
public class Appplication {
    public static void main(String[] args) {
        NewDriver.main(args);
       // createFolders();
    }

    public static void createJmeterFileStructure() {

    }

    public static void createFolders() {
        new File(System.getProperty("user.dir") + "/bin").mkdir();
        new File(System.getProperty("user.dir") + "/lib").mkdir();
        new File(System.getProperty("user.dir") + "/lib" + "/ext").mkdir();
        new File(System.getProperty("user.dir") + "/lib" + "/junit").mkdir();
    }

    //copy all maven items to lib & bin
    private static void downloadResources(){

    }

    private static void makeJmeterProperties(){

    }

}
