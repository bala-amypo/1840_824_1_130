package com.example.demo.util;

public class ValidationUtil {
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
