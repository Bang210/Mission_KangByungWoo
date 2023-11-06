package com.ll;

import java.util.HashMap;
import java.util.Map;

class Rq {
    private String action;
    private Map<String, Integer> requests = new HashMap<>();
    Rq(String cmd) {
        //입력된 명령, param, id를 구분하여 저장
        System.out.printf("입력된 명령어 : %s\n", cmd);
        String[] cmdQuery = cmd.split("\\?", 2);
        action = cmdQuery[0];
        if (cmdQuery.length == 1) {
            return;
        } else {
            String[] query = cmdQuery[1].split("&");
            for (int i = 0; i < query.length; i++) {
                String[] query2 = query[i].split("=");
                String param = query2[0];
                try {
                    int idNum = Integer.parseInt(query2[1]);
                    requests.put(param, idNum);
                } catch ( Exception e) {
                    //id값에 이상이 있다면 id를 -1로 변환
                    requests.put(param, -1);
                }
            }
        }
    }
    String getAction() {
        //입력된 명령 리턴
        return action;
    }
    int getId() {
        try {
            return requests.get("id");
        } catch (Exception e) {
            //index값에 이상이 있다면 index값을 -1로 변환
            return -1;
        }
    }
}