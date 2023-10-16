package com.ut.library;

import com.ut.base.IAssignment;
import com.ut.library.models.BooksModel;
import com.ut.library.repo.BookRepoImpl;
import com.ut.utils.CmdUtil;

import java.util.List;

public class LibraryApp implements IAssignment {

    private BookRepoImpl repo;

    private void initApp(){
        repo = Utils.loadBookDB();
    }


    private void showBook(BooksModel book){
        CmdUtil.displayMessage("**\t\t Book Details \t\t**");
        CmdUtil.displayMessage("**\t\t Book Title: "+ book.getTitle()+" \t\t**");
        CmdUtil.displayMessage("**\t\t Book Author: "+ book.getAuthor()+" \t\t**");
        CmdUtil.displayMessage("**\t\t ============ \t\t**\n");
    }
    private void showBooks(List<BooksModel> books){
        for(BooksModel book: books){
            showBook(book);
        }
    }


    private void listAllBooks(){
        List<BooksModel> allBooks = repo.search(0);
        showBooks(allBooks);
    }

    private void searchByTitle(){
        String searchString = CmdUtil.takeStringInput("Enter Book Title: ");
        showBooks(repo.searchByTitle(searchString));
    }

    private void borrow(){
        String searchString = CmdUtil.takeStringInput("Enter Book Title You want to borrow: ");
        List<BooksModel> book = repo.searchByTitle(searchString);
        if(!book.isEmpty()){
            showBooks(book);
            CmdUtil.displayMessage("** Borrowed..** \n\n");
            return;
        }
        CmdUtil.displayMessage("Sorry Book not present");
    }

    private void askOperations(){
        String choiceMessage = "Enter Operations: \n";
        choiceMessage += "1. List all books \n";
        choiceMessage += "2. Search By Title \n";
        choiceMessage += "3. Borrow Book  \n";
        choiceMessage += "q: to quit \n";

        String choice = CmdUtil.takeStringInput(choiceMessage);

        switch (choice){
            case "1": {
                listAllBooks();
                break;
            }

            case "2": {
                searchByTitle();
                break;
            }

            case "3": {
                borrow();
                break;
            }

            case "q": {
                CmdUtil.displayMessage("Quiting Application");
                System.exit(0);
            }

            default:{
                CmdUtil.displayMessage("No Valid Choices");
                break;
            }
        }

    }

    @Override
    public void run() {
        CmdUtil.displayMessage(".. Library App ...");
        CmdUtil.displayMessage("Welcome to MY Library");

        try {
            initApp();
        }catch (Exception exp){
            System.out.println(exp);
        }

        int ct = 0;
        while(true) {
            askOperations();
            if (ct > 5){
                break;
            }
            ct++;
        }

        CmdUtil.displayMessage("Come Back");

    }
}
