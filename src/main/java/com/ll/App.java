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
    //idCount 초기화
    public static int idCount = 1;
    public void run() {
        //초기 메세지
        System.out.println("=============================명언 앱=============================\n");
        quotationController.cmdList();
        quotationController.load();
        while (true) {
            System.out.print("명령) ");
            //명령 입력
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getAction()) {
                case "종료" -> {return;}
                case "등록" -> quotationController.register();
                case "목록" -> quotationController.listup();
                case "삭제" -> quotationController.delete(quotationController.getIndexIdById(rq.getId()));
                case "수정" -> quotationController.correct(quotationController.getIndexIdById(rq.getId()));
                case "빌드" -> quotationController.save();
                case "정렬" -> quotationController.sortId();
                case "명령어" -> quotationController.cmdList();
                default -> System.out.println("잘못된 명령입니다.");
            }
        }
    }
}