package com.ll.simpleDb;

public class SimpleDb {
    private boolean devMode;
    SimpleDb(String a,String b,String c,String d) {
        devMode = false;
    }
    void setDevMode(boolean bool) {
        devMode = bool == true? true : false;
    }

    void run(String query) {

    }
    void run(String query, String query2, String query3, boolean bool) {

    }
    Sql genSql() {
        return new Sql();
    }
}
