package ru.dataart.academy.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String path1 = "somepath\\test.zip";
        String path2 = "somepath\\test1.zip";

        System.out.println("Calculator get number of 1: " +
                calculator.getNumberOfChar(path1, '1'));

        System.out.println("Calculator get max length: " +
                calculator.getMaxWordLength(path2));
    }
}