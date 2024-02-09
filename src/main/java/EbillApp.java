

import java.util.List;
import java.util.Scanner;



import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class EbillApp {
	

	public static void main(String[] args) {
		
        String sourcePath = "src/main/java/EbillTest.java";
        String destPath = "src/test/java/EbillTest.java";
      copyFile(sourcePath, destPath);
            Result result = JUnitCore.runClasses(EbillTest.class);
        
        if (result.getFailureCount() == 0)
            System.out.println("There are No Failures...\n Test Passed...");
        else {
            for(Failure failure: result.getFailures()) {
                 System.out.println("The Test execution failed...\n" + failure.getMessage());
            }
        }
        System.out.println("Result" + result.wasSuccessful());
        try {
            String command = "mvn test";
            // For Windows, use something like: String command = "cmd /c echo Hello, World!";
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = 
                new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
            } else {
                // Something went wrong
                System.out.println("Abnormal execution!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}

    public static void copyFile(String sourcePathStr, String destPathStr) {
        // Convert string paths to Path objects
        Path sourcePath = Paths.get(sourcePathStr);
        Path destPath = Paths.get(destPathStr);
    
        try {
            // Copy the file from source to destination
            Files.copy(sourcePath, destPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while copying the file.");
            e.printStackTrace();
        }
    }
    
}
