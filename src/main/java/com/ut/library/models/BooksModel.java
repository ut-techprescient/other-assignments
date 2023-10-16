package com.ut.library.models;

import lombok.*;

@Data
@Setter @Getter
@AllArgsConstructor
public class BooksModel {
private String author;
private String country;
private String imageLink;
private String language;
private String link;
private Integer pages;
private String title;
private Integer year;
}
