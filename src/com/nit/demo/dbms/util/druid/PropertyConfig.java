package com.nit.demo.dbms.util.druid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {
    protected String configName;
    private Properties p;

    public String getConfigName() {
        return configName;
    }

    protected PropertyConfig(String configName) {
        p = new Properties();
        String configPath = ConfigFileUtil.getPath(PropertyConfig.class, configName);
        if (configPath != null) {
            try {
                InputStream input = new FileInputStream(configPath);
                p.load(input);
                this.configName = configName;
            } catch (FileNotFoundException e) {
                this.configName = null;
            } catch (IOException e) {
                this.configName = null;
            }
        } else {
            System.err.println("没有发现配置文件");
            this.configName = null;
        }
    }

    /**
     * 根据配置文件中的键，返回其字符串类型的值
     *
     * @param key the key
     * @return the value
     */
    public String getValue(String key) {
        String value = p.getProperty(key);
        return value;
    }

    /**
     * 根据配置文件中的键，返回其整数类型的值，如果不能转化为整数，返回0.
     *
     * @param key the key
     * @return the int
     */
    public int getInt(String key) {
        String str = getValue(key);
        int valueInt = 0;
        if (str != null) {
            try {
                valueInt = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        return valueInt;
    }

    public Properties getProperties() {
        return p;
    }


}

