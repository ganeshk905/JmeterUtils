package org.automation;

import org.apache.jmeter.util.ShutdownClient;

import java.io.IOException;

/**
 * Created by shantonu on 7/12/16.
 */
public class Appplication {
    public static void main(String[] args) {
        try {
            ShutdownClient.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
