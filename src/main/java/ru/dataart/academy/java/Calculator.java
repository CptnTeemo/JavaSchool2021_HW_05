package ru.dataart.academy.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipInputStream;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        //Task implementation

        int count = 0;
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath))) {

            while ((zin.getNextEntry()) != null) {
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    if (character == c) {
                        count++;
                    }
                }
                zin.closeEntry();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        int maxLength = 0;
        String longest;
        StringBuilder builder = new StringBuilder();

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath))) {

            while ((zin.getNextEntry()) != null) {

                for (int c = zin.read(); c != -1; c = zin.read()) {
                    char ch = (char) c;
                    builder.append(ch);
                }
                builder.append("\n");
                zin.closeEntry();
            }
            longest = Arrays.stream(builder.toString().split("[\\s.,]"))
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");
            maxLength = longest.length();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return maxLength;

//        String cleanedText = builder.toString().replaceAll("\\s", "\n");
//        String[] word = cleanedText.split("\\s");
//
//        String longest2 = "";
//        for(int i=0; i < word.length; i++)
//        {
//            if(word[i].length() >= longest2.length())
//            {
//                longest2 = word[i];
//            }
//        }
//        return longest2.length();

    }

}
