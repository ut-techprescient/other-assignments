package com.ut.utils;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CmdUtil {

    public static void displayMessage(String msg){
        System.out.println(msg);
    }

    public static Scanner scannerInput(){
        return new Scanner(System.in);
    }

    public static Scanner genericInput(String msg){
        displayMessage(msg);
        return scannerInput();
    }

    public static String takeStringInput(String msg){
        return genericInput(msg).nextLine().trim();
    }

    public static int takeIntegerInput(String msg){
        return genericInput(msg).nextInt();
    }

    public static float takeFloatInput(String msg){
        return genericInput(msg).nextFloat();
    }

    public static double takeDoubleInput(String msg){
        return genericInput(msg).nextDouble();
    }

    public static char takeCharInput(String msg){
        return genericInput(msg).next().charAt(0);
    }

    public static Path takeFilePathInput(String msg) throws FileNotFoundException {
        Path filePath = Paths.get(genericInput(msg).nextLine().trim());
        if (!Files.exists(filePath)){
            throw new FileNotFoundException();
        }
        return filePath;
    }
}
