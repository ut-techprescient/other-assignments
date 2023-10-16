package com.ut.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ut.library.models.BooksModel;
import com.ut.library.repo.BookRepoImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Utils {

    private final static Path BOOK_CSV = Paths.get("src/main/resources/books.json");

    public static List<BooksModel> readBooks(){
        List<BooksModel> jsonObj = null;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(String.valueOf(BOOK_CSV)));
            Type listType = new TypeToken<List<BooksModel>>(){}.getType();
            Gson gson = new Gson();
            jsonObj =  gson.fromJson(buff, listType);
        }catch (IOException exp){
            System.out.println("File Error: " + exp.toString());
        }
        return jsonObj;
    }

    static BookRepoImpl loadBookDB(){
        return new BookRepoImpl(readBooks());

    }


}
