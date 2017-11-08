package com.mike.common;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mike on 2017/11/7.
 */
public class UtilGenerateID {
    private static UtilGenerateID utilComm = new UtilGenerateID();
    public static final URL CLASSES_ROOT_URL = Thread.currentThread().getContextClassLoader().getResource("");
    public static final String CLASSES_ROOT_PATH;
    private static long curgenerateID;

    private UtilGenerateID() {
    }

    public static UtilGenerateID getInstance() {
        return utilComm;
    }

    public static synchronized String generateID(String pre) {
        long time = (new Date()).getTime();
        if(time == curgenerateID) {
            ++time;
        }

        curgenerateID = time;

        try {
            Thread.sleep(1L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

        return (pre + Long.toHexString(time).toString()).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        UtilGenerateID var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
        var10001 = utilComm;
        System.out.println(generateID(""));
    }

    static {
        CLASSES_ROOT_PATH = CLASSES_ROOT_URL.getPath();
        curgenerateID = 0L;
    }
}
