package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {


    @Test(invocationCount = 2)    // if we want to run 2 times the will mention "(invocationCount = 2)"
    public void test01(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3)   // if we want to run 2 times the will mention "(invocationCount = 3)"
    public void test02(){
        System.out.println("Hi");
    }

    @Test                        // if we will not mention "invocationCount" then it will run by default 1.
    public void test03(){
        System.out.println("Hi");
    }



}
