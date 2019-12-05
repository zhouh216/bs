package com.fiction.crawler.web;

/**
 * @program: crawler
 * @description: 数据源
 * @author: zh
 * @create: 2019-11-29 11:34
 **/
public class DataBaseContextHolder {
    public enum DataBaseType {
        uts1("uts1"), uts2("uts2");
        private String code;

        DataBaseType(String dbName) {
            code = dbName;
        }

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    }
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();

    public static Object getDataBaseType() {
        return contextHolder.get() == null ? DataBaseType.uts1 : contextHolder.get();
    }

    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null)
            throw new NullPointerException("dataBaseType不允许为空.");
        contextHolder.set(dataBaseType);
    }

    public static void clearContextHolder() {
        contextHolder.remove();
    }
}
