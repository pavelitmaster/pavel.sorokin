package com.caesarcipher;

public class CaesarCipher {
    protected static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"':!? ";

    static char encryptChar(char character, int key) {
        int index = ALPHABET.indexOf(character);
        if (index != -1) {
            int newIndex = (index + key) % ALPHABET.length();
            return ALPHABET.charAt(newIndex);
        } else {
            return character;
        }
    }

    protected static char decryptChar(char character, int key) {
        int index = ALPHABET.indexOf(character);
        if (index != -1) {
            int newIndex = (index - key + ALPHABET.length()) % ALPHABET.length();
            return ALPHABET.charAt(newIndex);
        } else {
            return character;
        }
    }
}
