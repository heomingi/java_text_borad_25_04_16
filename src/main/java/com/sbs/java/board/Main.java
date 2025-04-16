package com.sbs.java.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("==자바 텍스트 게시판==");
    System.out.println("텍스트 게시판을 시작합니다");

    int lastArticleId=0;
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
        Article article = new Article();
        article.id = id;
        article.subject = subject;
        article.content = content;

        System.out.println("생성된 게시물 객체:"+article);

        System.out.printf("%d번 게시물이 등록되었습니다.",id);
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

  @Override
  public String toString(){
    return "{id:%d,subject:\"%s\",content:\"%s\"}".formatted(id,subject,content);

  }
}