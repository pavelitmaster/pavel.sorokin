package com.caesarcipher;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.caesarcipher.BruteForce.bruteForce;
import static com.caesarcipher.FileService.decryptFile;
import static com.caesarcipher.FileService.encryptFile;

public class Cli {
    static void cli() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (ENCRYPT/DECRYPT/BRUTE_FORCE):");
        String command = scanner.nextLine();
        System.out.println("Enter input file path:");
        String filePath = scanner.nextLine();

        try {
            if ("ENCRYPT".equalsIgnoreCase(command) || "DECRYPT".equalsIgnoreCase(command)) {
                System.out.println("Enter key:");
                int key = scanner.nextInt();
                if ("ENCRYPT".equalsIgnoreCase(command)) {
                    encryptFile(filePath, key);
                } else {
                    decryptFile(filePath, key);
                }
            } else if ("BRUTE_FORCE".equalsIgnoreCase(command)) {
                bruteForce(filePath);
            } else {
                System.out.println("Invalid command.");
            }
        } catch (InputMismatchException | IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
