package com.sbs.java.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<Article> articles = new ArrayList<>();

    int lastArticleId=0;
    Article lastArticle = null;

    System.out.println("==자바 텍스트 게시판==");
    System.out.println("텍스트 게시판을 시작합니다");

    while (true) {
      System.out.println("명령)");
      String cmd = sc.nextLine();
      if(cmd.equals("/user/article/write")){
        System.out.println("==게시물 작성==");
        System.out.println("제목: ");
        String subject = sc.nextLine();

        if(subject.trim().isEmpty()){
          System.out.println("제목을 입력해주세요.");
          continue;
        }

        System.out.println("내용: ");
        String content = sc.nextLine();

        if(content.trim().isEmpty()){
          System.out.println("내용을 입력해주세요.");
          continue;
        }

        int id =++lastArticleId;
        Article article = new Article(id,subject,content);
        lastArticle = article;

        articles.add(article);

        System.out.println("생성된 게시물 객체:"+article);

        System.out.printf("%d번 게시물이 등록되었습니다.",id);
      }

      else if(cmd.equals("/user/article/list")) {
        if (articles.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }
        System.out.println("==게시물 리스트==");
        System.out.println("번호 | 제목");

/*        for(int i=0; i<articles.size(); i++){
          Article article = articles.get(i);

          System.out.printf("%d | %s \n",article.id,article.subject);*/

      /*  for(Article article :articles){
          System.out.printf("%d | %s \n",article.id,article.subject);
        }
      }*/

        articles.forEach((article)
            -> System.out.printf("%d | %s \n", article.id, article.subject));

      }
      else if(cmd.equals("/user/article/detail")){

        Article article=lastArticle;

        if(article==null){
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("==게시물 상세보기==");
        System.out.printf("번호 : %d \n",article.id);
        System.out.printf("번호 : %s \n",article.subject);
        System.out.printf("번호 : %s \n",article.content);
      }

      else if(cmd.equals("exit")){
        System.out.println("텍스트 게시판을 종료합니다.");
        break;
      }

      else{
        System.out.println("잘못 입력 된 명령어입니다.");
      }


      System.out.printf("입력받은 명령어 : %s\n", cmd);

    }


    System.out.println("텍스트 게시판을 종료합니다");
    System.out.println("==자바 텍스트 게시판 종료==");

    sc.close();

  }
}


class Article{

  int id;

  String subject;

  String content;

  Article(int id,String subject,String content){
    this.id=id;
    this.subject=subject;
    this.content=content;
  }

  @Override
  public String toString(){
    return "{id:%d,subject:\"%s\",content:\"%s\"}".formatted(id,subject,content);

  }
}