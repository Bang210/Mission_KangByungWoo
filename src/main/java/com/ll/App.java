package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    //스캐너 객체 생성
    public static Scanner scanner = new Scanner(System.in);
    //QuotationController객체 생성
    QuotationController quotationController = new QuotationController();
    //Quototation객체를 담을 리스트 생성
    public static List<Quotation> quotes = new ArrayList<>();
    public static int idCount = 1;
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
                case "등록" :
                    quotationController.register();
                    break;
                case "목록" :
                    quotationController.listup();
                    break;
                case "삭제" :
                    quotationController.delete(quotationController.getIndexIdById(rq.getId()));
                    break;
                case "수정" :
                    quotationController.correct(quotationController.getIndexIdById(rq.getId()));
                    break;
            }
        }
    }
}