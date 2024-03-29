package com.ebill;

import java.util.List;
import java.util.Scanner;

import org.junit.platform.commons.JUnitException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.ebill.test.EbillTest;




public class EbillApp {
	

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(EbillTest.class);
        
        if (result.getFailureCount() == 0)
            System.out.println("There are No Failures...\n Test Passed...");
        else {
            for(Failure failure: result.getFailures()) {
                 System.out.println("The Test execution failed...\n" + failure.getMessage());
            }
        }
        System.out.println("Result" + result.wasSuccessful());

	}
}
