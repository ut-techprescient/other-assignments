package com.ut.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class HangmanRepo {
    private final Path filePath4 = Paths.get("src/main/resources/word_letter_4.txt");
    private final Path filePath5 = Paths.get("src/main/resources/word_letter_5.txt");
    private final Path filePath6 = Paths.get("src/main/resources/word_letter_6.txt");

    private List<String> loadDictionary(int letterChoice) throws IOException {
        Path dictPath = (letterChoice == 4)? filePath4:
                (letterChoice == 5)? filePath5: filePath6;
        return Files.readAllLines(dictPath);
    }

    private String selectRandomWord(List<String> dictionary){
        Random rand = new Random();
        return dictionary.get(rand.nextInt(dictionary.size()));
    }


    public String getWord(int letterChoice){
        try {
            List<String> dictionary = this.loadDictionary(letterChoice);
            return selectRandomWord(dictionary);
        }catch (IOException exp){
            System.out.println(exp);
            return "RandomWord";
        }
    }


}
