package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting016_TestNG_Priority_2 {

    @Test(priority = 1)   // Suppose i will add the Priority
                        // then it will run according to the priority Basis.
                        // Generally we avoid the Priority
    public void t1(){
        System.out.println("1");
    }

    @Test(priority = 3)
    public void t2(){
        System.out.println("3");
    }

    @Test(priority = 2)
    public void t3(){
        System.out.println("2");
    }

    @Test(priority = 4)
    public void t4(){
        System.out.println("4");
    }

}


// So, result will be 1,2,3,4

