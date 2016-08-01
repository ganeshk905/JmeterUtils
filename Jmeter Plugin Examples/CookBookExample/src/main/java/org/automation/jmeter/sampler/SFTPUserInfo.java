package org.automation.jmeter.sampler;

import com.jcraft.jsch.UserInfo;

import java.io.Serializable;

/**
 * Created by shantonu on 8/1/16.
 */
public class SFTPUserInfo implements UserInfo, Serializable {
    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean promptPassword(String s) {
        return false;
    }

    @Override
    public boolean promptPassphrase(String s) {
        return false;
    }

    @Override
    public boolean promptYesNo(String s) {
        return false;
    }

    @Override
    public void showMessage(String s) {

    }
}
