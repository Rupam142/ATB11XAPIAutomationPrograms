package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TestNG_AlwaysRun {

    @Test
    public void test_new_register() {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test_loginPage() {
        Assert.assertTrue(true);
    }

    // If we mention "enabled = false" then will not run even it is mention "always = run" also
//    @Test(alwaysRun = true , enabled = false)
//    public void test_loginPage() {
//        Assert.assertTrue(true);
//    }

    @Test
    public void test_normal() {
        Assert.assertTrue(true);
    }


}
