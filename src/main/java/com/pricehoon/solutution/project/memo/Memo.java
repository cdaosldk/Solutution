package com.pricehoon.solutution.project.memo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Memo  {


    private String name;
    private String pwd;

    private String content;
    private LocalDateTime date;


    public Memo(String name,LocalDateTime date ,String pwd,String content) {
//        this.memo_num = memo_num;
        this.name = name;
        this.pwd = pwd;
        this.date = date;
        this.content = content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent(){
        return content;
    }


    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
