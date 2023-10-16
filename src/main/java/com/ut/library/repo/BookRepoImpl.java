package com.ut.library.repo;

import com.ut.library.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepoImpl implements ILibraryRepo{
    private List<BooksModel> booksList = new ArrayList<>();


    public BookRepoImpl(List<BooksModel> bookList){
        this.booksList = bookList;
    }

    public void create(BooksModel bookModel){
        booksList.add(bookModel);
    }

    public List<BooksModel> search(int page){
        int pageSize = (booksList.size() <= page+10)? 0 : page;
        return booksList.subList(pageSize, pageSize+10);
    }

    public List<BooksModel> searchByTitle(String title){
        return booksList.stream().filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());

    }

}
