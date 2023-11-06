package com.ll;

import static com.ll.App.*;

class QuotationController {
    void register() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        quotes.add(new Quotation(idCount, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", idCount);
        idCount++;
    }
    void listup() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------------");
        if (quotes.size() == 0) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (int i = 0; i < quotes.size(); i++) {
                System.out.printf("%d / %s / %s\n", quotes.get(i).getId(), quotes.get(i).getAuthor(), quotes.get(i).getContent());
            }
        }
    }
    void delete(int[] indexId) {
        if (indexId[1] == -1) {
            System.out.println("정확한 id를 입력해주세요.");
            return;
        }
        if (indexId[0] == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", indexId[1]);
        } else {
            quotes.remove(indexId[0]);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", indexId[1]);
        }
    }
    int[] getIndexId(int id) {
        int[] indexId = {-1, id};
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).getId() == id) {
                indexId[0] = i;
                break;
            }
        }
        return indexId;
    }
}
