package com.practice;

import org.testng.annotations.Test;

public class IndependentTest 
{
    @Test(threadPoolSize = 3, invocationCount = 6, timeOut = 2000)
    public void testMethod() 
    {
        Long id = Thread.currentThread().getId();
        System.out.println("Test method executing on thread with id: " + id);
    }
}