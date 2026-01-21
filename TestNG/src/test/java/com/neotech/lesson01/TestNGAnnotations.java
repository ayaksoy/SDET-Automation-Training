package com.neotech.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
    }

    @Test
    public void test1() {
        System.out.println("This is test method1");
    }

    @Test
    public void test2() {
        System.out.println("This is test method2");
    }

}
