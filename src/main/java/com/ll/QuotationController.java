package com.ll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
        if (quotes.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (Quotation quote : quotes) {
                System.out.printf("%d / %s / %s\n", quote.getId(), quote.getAuthor(), quote.getContent());
            }
        }
    }
    void delete(int[] indexId) {
        if (indexId[1] == -1) {
            //id값의 이상
            System.out.println("정확한 id를 입력해주세요.");
            return;
        }
        if (indexId[0] == -1) {
            //index값의 이상
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", indexId[1]);
        } else {
            quotes.remove(indexId[0]);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", indexId[1]);
        }
    }
    void correct(int[] indexId) {
        if (indexId[1] == -1) {
            //id값의 이상
            System.out.println("정확한 id를 입력해주세요.");
            return;
        }
        if (indexId[0] == -1) {
            //index값의 이상
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", indexId[1]);
        } else {
            System.out.printf("명언(기존): %s\n", quotes.get(indexId[0]).getContent());
            System.out.print("명언: ");
            String content = scanner.nextLine();
            System.out.printf("작가(기존): %s\n", quotes.get(indexId[0]).getAuthor());
            System.out.print("작가: ");
            String author = scanner.nextLine();
            quotes.get(indexId[0]).setContent(content);
            quotes.get(indexId[0]).setAuthor(author);
            System.out.printf("%d번 명언이 수정되었습니다.\n", indexId[1]);
        }
    }
    int[] getIndexIdById(int id) {
        int[] indexId = {-1, id};
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).getId() == id) {
                indexId[0] = i;
                break;
            }
        }
        return indexId;
    }
    void save() {
        //data.txt 파일을 통한 데이터 저장
        File file = new File("data.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (Quotation quote : quotes) {
                byte[] bytes = (String.valueOf(quote.getId()) + ',' + quote.getContent() + ',' + quote.getAuthor() + '/').getBytes();
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void load() {
        //data.txt 파일에서 데이터 불러오기
        File file = new File("data.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            if (data.length == 0) {
                //데이터가 없을 경우 실행하지 않음.
                return;
            }
            fis.read(data);
            String dataString = new String(data);
            String[] dataArray = dataString.split("/");
            for (String datas : dataArray) {
                String[] quoteData = datas.split(",");
                quotes.add(new Quotation(Integer.parseInt(quoteData[0]), quoteData[1], quoteData[2]));
                idCount = Integer.parseInt(quoteData[0]) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
