package com.ut.hangman;

import com.ut.base.IAssignment;
import com.ut.utils.CmdUtil;

import java.util.*;

public class HangmanApp implements IAssignment {

    private int takeUserChoice() throws Exception {
        String msg = "Enter No. of Letter want to predict (4, 5, 6)";
        int choice = CmdUtil.takeIntegerInput(msg);
        if (choice < 4 || choice > 6){
            CmdUtil.displayMessage("Choice not allowed");
            throw new Exception("Invalid choice");
        }
        return choice;
    }

    private StringBuilder generateBlankString(String word){
        StringBuilder newWord = new StringBuilder();
        for(String c: word.split("\\s*")){
            newWord.append("_");
        }
        return newWord;
    }

    public static List<Integer> generateNonRepeatingRandomNumbers(int min, int max, int count) {
        if (count > (max - min + 1) || min > max) {
            throw new IllegalArgumentException("Invalid input. Unable to generate non-repeating numbers.");
        }

        List<Integer> generatedNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < count) {
            int randomNumber = random.nextInt(max - min + 1) + min;

            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
                generatedNumbers.add(randomNumber);
            }
        }

        return generatedNumbers;
    }

    private String generateWord(String word, int size){
        char[] strChar = word.toCharArray();
        List<Integer> choices = generateNonRepeatingRandomNumbers(0, word.length()-1, size);
        for (int i = 0; i < strChar.length; i++) {
            if(choices.contains(i)){
                continue;
            }
            strChar[i] = '_';
        }
        return Arrays.toString(strChar);
    }

    private void showSuggestions(String word, int iteration){
        CmdUtil.displayMessage("Suggestion Word\n" + word);
        CmdUtil.displayMessage("Suggestion \n" + iteration);
        CmdUtil.displayMessage("\n Word: "+ generateWord(word, iteration));
    }

    private String takeSuggestedWord(){
        return CmdUtil.takeStringInput("Enter word: ");
    }

    private String selectWord(int letterChoice){
        HangmanRepo repo = new HangmanRepo();
        return repo.getWord(letterChoice);
    }

    @Override
    public void run() {
        CmdUtil.displayMessage("*** Welcome to Hangman Game ***");
        int choice = 4;
        try {
            choice = this.takeUserChoice();
        }catch (Exception exp){
            CmdUtil.displayMessage("Invalid Choice of chars");
            System.exit(0);
        }

        String word = selectWord(choice);
        int iteration = 1;
        int maxIteration = word.length();
        iteration += 1;
        this.showSuggestions(word, iteration);

        while (iteration < maxIteration){
            String usrWord = takeSuggestedWord();
            if (word.equals(usrWord)){
                CmdUtil.displayMessage("You predicted correct word actual: " + word + " your entered word: "+ usrWord);
                break;
            }
            iteration++;
            this.showSuggestions(word, iteration);
        }

        if(iteration >= maxIteration){
            CmdUtil.displayMessage("You aren't able to predicted correct word actual: " + word);
        }

        CmdUtil.displayMessage("*** Thanks for playing game ***");
    }
}
