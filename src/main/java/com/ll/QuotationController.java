package com.ll;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.List;

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
        //data.json을 통한 데이터 저장
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(quotes);
        try (FileWriter fileWriter = new FileWriter("data.json")) {
            fileWriter.write(json);
            System.out.println("data.json 파일의 내용이 갱신되었습니다.");
        } catch (Exception e) {
            System.out.println("갱신실패");
        }
    }
    void load() {
        //data.json을 통한 데이터 불러오기
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader("data.json")) {
            quotes = gson.fromJson(reader, new TypeToken<List<Quotation>>(){}.getType());
            idCount = quotes.get(quotes.size() - 1).getId() + 1;
        } catch (Exception e) {
        }
    }
}