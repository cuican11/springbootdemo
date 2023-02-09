package com.hwgif.interview;

import java.time.LocalDate;

/**
 *网友的面试考题
 */
public class InterviewQuestion {
    public static void main(String[] args) {
        InterviewQuestion cl = new InterviewQuestion();
       // System.out.println( cl.digui(100));
        cl.dateexc();
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int digui(int n){
        if (n >= 1){
            return n + digui(n -1);
        }
        return n;
    }

    /**
     * 日期相关
     */
    public void dateexc(){
        System.out.println(LocalDate.now());
        return;
    }

}
