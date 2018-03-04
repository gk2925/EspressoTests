package com.mytaxi.android_demo.app.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.mytaxi.android_demo.app.utils.TestConstants.ESPRESSO_TAG;

public class PropertiesUtils {
    private static final String DEFAULT_TEST_PROFILE = "login_1";
    private static final java.util.Properties prop = new Properties();

    public static void initPropertiesFromResources(String filename) {
        filename = (null == filename) ? DEFAULT_TEST_PROFILE : filename;
        try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream(filename + ".properties")) {

            //load a properties file from class path, inside static method
            prop.load(input);

        } catch (IOException ex) {
            Log.e(ESPRESSO_TAG, "Sorry, unable to load properties", ex);
        }
    }

    public static String getProperty(@NonNull final String property) {

        return StringUtils.defaultString(prop.getProperty(property));
    }

    public static List<String> getProperties(List<String> keys) {
        List<String> values = new ArrayList<>();
        keys.toArray(new String[keys.size()]);

        for (String key : keys) {
            values.add(getProperty(key));
        }

        return values;
    }

    public static void setProperty(@NonNull final String property, @NonNull final String value) {
        prop.setProperty(property, value);
    }

    public static boolean getBoolean(@NonNull final String property) {
        return Boolean.valueOf(StringUtils.defaultString(prop.getProperty(property)));
    }
}
