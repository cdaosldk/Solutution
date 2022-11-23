package com.pricehoon.solutution.Java;

import com.pricehoon.solutution.project.memo.Memo;
import com.pricehoon.solutution.project.memo.MemoList;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        //Switch는 그대로 가는걸로
        //수정 삭제 추가하기
        //예외처리

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1:추가, 2:전체보기, 3:삭제, 4.수정, 5.종료");
            int select = sc.nextInt();


            if (select == 5) {
                System.out.println("종료");
                break;
            }

            switch (select) {
                case 1:
                    insertPost();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    update();
                    break;

                default:
                    System.out.println("알맞은 번호를 선택하세요!");
                    break;

            }
        }
    }

    public static void insertPost() {

        MemoList memoList = MemoList.getInstance();

        LocalDateTime dateTime = LocalDateTime.now();

        Scanner sc = new Scanner(System.in);
        System.out.println("메모추가하기");
        System.out.print("이름 :");
        String name = sc.next();
        System.out.print("비밀번호 : ");
        String pwd = sc.next();
        sc.nextLine();
        System.out.print("메모내용 : ");
        String content = sc.nextLine();



        Memo memo = new Memo(name,dateTime ,pwd, content);

        memoList.addPost(memo);
    }


    public static void showAll() {

        MemoList memoList = MemoList.getInstance();
        memoList.showAll();
    }

    public static void delete(){

        MemoList memoList = MemoList.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("--게시글 삭제하기--");
        System.out.println("삭제하고자 하는 게시글의 번호를 입력하세요!");
        int num = sc.nextInt();

        if(!memoList.confirmNum(num-1)){
            return;
        }

        System.out.println("비밀번호를 입력하세요!");
        String pwd = sc.next();

        if(!memoList.confirmPwd(num-1,pwd)){
            return;
        }
        memoList.deletePost(num-1);

    }

    public static void update(){
        MemoList memoList = MemoList.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("--게시글 수정하기--");
        System.out.println("수정하고자 하는 게시글의 번호를 입력하세요!");
        int num = sc.nextInt();

        if(!memoList.confirmNum(num-1)){
            return;
        }
        System.out.println("비밀번호를 입력하세요!");
        String pwd = sc.next();
        if(!memoList.confirmPwd(num-1,pwd)){
            return;
        }
        sc.nextLine();
        System.out.println("수정하고자 하는 내용을 입력하세요! : ");
        String content = sc.next();

        memoList.update(num-1,content);

    }
}
