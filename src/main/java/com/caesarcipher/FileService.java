package com.caesarcipher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.caesarcipher.CaesarCipher.decryptChar;
import static com.caesarcipher.CaesarCipher.encryptChar;

public class FileService {
    static void encryptFile(String filePath, int key) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(filePath);
            outputStream = new FileOutputStream(filePath + "[ENCRYPTED]");

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                char originalChar = (char) bytesRead;
                char encryptedChar = encryptChar(originalChar, key);
                outputStream.write((int) encryptedChar);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    static void decryptFile(String filePath, int key) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(filePath);
            outputStream = new FileOutputStream(filePath + "[DECRYPTED]");

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                char encryptedChar = (char) bytesRead;
                char decryptedChar = decryptChar(encryptedChar, key);
                outputStream.write((int) decryptedChar);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
