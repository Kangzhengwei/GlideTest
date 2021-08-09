package com.example.glidetest;

public class Test {

    public static void main(String[] args){
        String url="skip://www.fengshi.com/open?bookId=2&chapter_id=1";
        String bookId = url.substring(url.indexOf("bookId="), url.indexOf("&"));
        String chapterId=url.substring(url.indexOf("chapter_id="));
        System.out.println("========"+bookId+"/"+chapterId);
    }
}
