package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Sql extends Article{
    Sql append(String query) {
        return this;
    }
    Sql append(String query, String query2) {
        return this;
    }

    Sql append(String query, int int1, int int2, int int3, int int4) {
        return this;
    }
    Sql append(String query, int int1, int int2, int int3) {
        return this;
    }
    long insert() {
        long id = 10;
        return id;
    }
    public long update() {
        long udt = 3;
        return udt;
    }
    long delete() {
        long dlt = 2;
        return dlt;
    }
    LocalDateTime selectDatetime() {
        return LocalDateTime.now();
    }
    long selectLong() {
        long sltlong = 1;
        return sltlong;
    }
    String selectString() {
        return "제목1";
    }
    Map<String, Object> selectRow() {
        Map<String, Object> articleMap = new HashMap<>() {{
           put("id", 1L);
           put("title", "제목1");
           put("body", "내용1");
           put("createdDate", LocalDateTime.now());
           put("modifiedDate", LocalDateTime.now());
           put("isBlind", false);
        }};
        return articleMap;
    }
}
