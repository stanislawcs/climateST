package com.example.climatest.code.util.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class UsernameAndPasswordGenerator {
    public static String generateUsername(){
        return RandomStringUtils.randomAlphabetic(12);
    }

    public static String generatePassword(){
        return RandomStringUtils.randomAlphabetic(20);
    }
}
