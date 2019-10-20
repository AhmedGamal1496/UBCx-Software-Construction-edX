package model.book;

import model.library.Library;

public class Book {

    private String title;
    private String author;
    private BookType type;
    private int year;
    private int edition;
    private Library homeLibrary;
    private boolean isOnLoan;

    public Book(String title, String author, BookType type, int year, int ed) {
        //TODO: complete the implementation of this method
        this.title = title;
        this.author = author;
        this.type = type;
        this.year = year;
        this.edition = ed;
        homeLibrary = null;
        isOnLoan = false;
    }

    // getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public BookType getType() { return type; }
    public int getYear() { return year; }
    public int getEdition() { return edition; }
    public Library getHomeLibrary() { return homeLibrary; }

    // MODIFIES: this
    // EFFECTS: set the book to be not on loan
    public void notOnLoan() { this.isOnLoan = false; }

    // EFFECTS: return true if this book is on loan, else return false
    public boolean onLoan() {
        //TODO: complete the implementation of this method
        if (isOnLoan) { return true; }
        else { return false; }
    }

    // MODIFIES: this
    // EFFECTS: set the book to be on loan
    public void nowOnLoan() {
        //TODO: complete the implementation of this method
        this.isOnLoan = true;
    }

    // REQUIRES: home != null
    // MODIFIES: this
    // EFFECTS: sets this book's home library to the one passed as parameter
    public void setHomeLibrary(Library home) {
        //TODO: complete the implementation of this method
        this.homeLibrary = home;
        home.storeBook(this);
    }


}