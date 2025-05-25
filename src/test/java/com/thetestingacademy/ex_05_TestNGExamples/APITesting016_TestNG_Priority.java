package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting016_TestNG_Priority {

    @Test
    public void t1(){
        System.out.println("1");
    }

    @Test
    public void t2(){
        System.out.println("3");
    }

    @Test
    public void t3(){
        System.out.println("2");
    }

    @Test
    public void t4(){
        System.out.println("4");
    }

}
