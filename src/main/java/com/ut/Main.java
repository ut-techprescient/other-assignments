package com.ut;

import com.ut.base.IAssignment;
import com.ut.hangman.HangmanApp;
import com.ut.library.LibraryApp;
import com.ut.student.StudentApp;
import com.ut.utils.CmdUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static String readBanner(){
        try {

            return Files.readString(Paths.get("src/main/resources/banner.txt"));
        }catch(IOException ex){
            return "Banner not found";
        }
    }


    public static void main(String[] args) {
        System.out.println(readBanner());
        System.out.println("Application Will Be Starting...");

        String message = "\n ======= App Choice ===== \n";
        message += "===  Select Application From Choices Below: ====";
        message += "\n 1. Student App";
        message += "\n 2. Hangman App";
        message += "\n 3. Library App";
        message += "\n  ==== End ===== \n";

        int choice = CmdUtil.takeIntegerInput(message);

        switch (choice){
            case 1: {
                IAssignment app = new StudentApp();
                app.run();
                break;
            }

            case 2: {
                IAssignment app = new HangmanApp();
                app.run();
                break;
            }

            case 3: {
                IAssignment app = new LibraryApp();
                app.run();
                break;
            }

            default:{
                CmdUtil.displayMessage("No choice provided");
                break;
            }
        }

    }
}