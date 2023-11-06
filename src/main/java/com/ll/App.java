package com.ll;

import java.util.Scanner;

class App {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        //초기 메세지
        System.out.println("==명언 앱==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getAction()) {
                case "종료" :
                    return;
            }
        }
    }
}
