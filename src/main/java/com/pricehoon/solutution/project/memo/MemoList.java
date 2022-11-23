package com.pricehoon.solutution.project.memo;

import java.time.LocalDateTime;
import java.util.*;

public class MemoList {
    private static final MemoList memoList_1 = new MemoList();

    private List<Memo> memoList = new ArrayList<>();

    //하나의 객체를 지속적으로 사용하기 위한 메서드
    public static MemoList getInstance() {

        if (memoList_1 == null) {
            return new MemoList();
        }
        return memoList_1;
    }

    public void addPost(Memo memo) {

        memoList.add(memo);
        System.out.println("메모가 정상적으로 저장되었습니다.");
    }

    public void showAll() {

        Collections.sort(memoList, new Comparator<Memo>() {
            @Override
            public int compare(Memo o1, Memo o2) {
                if(o1.getDate().isBefore(o2.getDate())){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        for (int i = 0; i < memoList.size(); i++) {
            System.out.print(i + 1 + " ");
            System.out.print(memoList.get(i).getName() + " ");
            System.out.print(memoList.get(i).getContent() + " ");
            System.out.println(memoList.get(i).getDate());

        }
    }

    public Boolean confirmNum(int num) {

        if (num > memoList.size() - 1) {

            System.out.println("잘못된 게시글 번호입니다!");
            return false;
        }
        return true;
    }

    public Boolean confirmPwd(int num, String pwd) {

        for (int i = 0; i < memoList.size(); i++) {

            if (memoList.get(num) != null) {
                String confirmPwd = memoList.get(num).getPwd();
                if (confirmPwd.equals(pwd)) {
                    return true;
                } else {
                    System.out.println("비밀번호가 틀립니다!");
                    return false;
                }
            } else {
                System.out.println("오류");
            }
        }
        return false;
    }


    public void deletePost(int num) {

        System.out.println("삭제가 완료되었습니다!");
        memoList.remove(num);

    }

    public void update(int num, String content) {

        System.out.println("수정이 완료되었습니다!");
        LocalDateTime dateTime = LocalDateTime.now();

        memoList.get(num).setContent(content);
        memoList.get(num).setDate(dateTime);


    }



}
