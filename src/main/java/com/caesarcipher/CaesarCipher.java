package com.caesarcipher;

public class CaesarCipher {
    final String alphabetEu = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"':!? ";

    char encryptChar(char character, int key) {
        int index = alphabetEu.indexOf(character);
        if (index != -1) {
            int newIndex = (index + key) % alphabetEu.length();
            return alphabetEu.charAt(newIndex);
        } else {
            return character;
        }
    }

    char decryptChar(char character, int key) {
        int index = alphabetEu.indexOf(character);
        if (index != -1) {
            int newIndex = (index - key + alphabetEu.length()) % alphabetEu.length();
            return alphabetEu.charAt(newIndex);
        } else {
            return character;
        }
    }
}
