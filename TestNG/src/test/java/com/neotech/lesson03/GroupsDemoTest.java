package com.neotech.lesson03;

import com.neotech.utils.CommonMethods;
import org.testng.annotations.Test;

public class GroupsDemoTest extends CommonMethods {

    @Test(groups = "smoke")
    public void test1() {
        System.out.println("Test1 in GroupDemo");
    }

    @Test(groups = {"smoke", "regression", "sprint4"})
    public void test2() {
        System.out.println("Test2 in GroupDemo");
    }

    @Test(groups = "sprint4")
    public void test3() {
        System.out.println("Test3 in GroupDemo");
    }

    @Test(groups = {"smoke", "regression", "broken"})
    public void test4() {
        System.out.println("Test4 in GroupDemo");
    }

}
