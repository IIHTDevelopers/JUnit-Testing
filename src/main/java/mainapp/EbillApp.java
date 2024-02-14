package mainapp;



import java.util.List;
import java.util.Scanner;



import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.ebill.test.EbillTest;

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
		
        String sourcePath = "src/main/java/com/ebill/test/EbillTest.java";
        String destPath = "src/test/java/com/ebill/test/EbillTest.java";
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

        try {
            String command = "awk -F'\"' '{"
            + "    for(i=1; i<=NF; i++){"
            + "        if($i == \" missed=\") {"
            + "             missed = $(i+1);"
            + "        }"
            + "        if($i == \" covered=\") {"
            + "             covered = $(i+1);"
            + "        }"
            + "    }"
            + "} END {"
            + "    total = missed + covered;"
            + "    if(total > 0) {"
            + "        coverage = (covered / total) * 100;"
            + "        printf \"Total Line Coverage: %.2f%%\\n\", coverage;"
            + "    } else {"
            + "        print \"Coverage data not found.\";"
            + "    }"
            + "}' target/site/jacoco/jacoco.xml";
        
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
