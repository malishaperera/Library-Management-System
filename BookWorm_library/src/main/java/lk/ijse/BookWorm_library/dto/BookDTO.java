package lk.ijse.BookWorm_library.dto;

import lk.ijse.BookWorm_library.entity.Books;

public class BookDTO {
    String bookId;


    String bookTitle;
    String bookAuthor;
    int bookQty;
    String bookBranch;
    String bookGenre;

    private byte[] bookImg;

    public BookDTO() {
    }

    public BookDTO(String bookId, String bookTitle, String bookAuthor, int bookQty, String bookBranch, String bookGenre, byte[] bookImg) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookQty = bookQty;
        this.bookBranch = bookBranch;
        this.bookGenre = bookGenre;
        this.bookImg = bookImg;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public String getBookBranch() {
        return bookBranch;
    }

    public void setBookBranch(String bookBranch) {
        this.bookBranch = bookBranch;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public byte[] getBookImg() {
        return bookImg;
    }

    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }









    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookQty=" + bookQty +
                ", bookBranch='" + bookBranch + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                '}';
    }

    public Books toEntity() {
        Books books = new Books();
        books.setBookId(this.bookId);
        books.setBookTitle(this.bookTitle);
        books.setBookAuthor(this.bookAuthor);
        books.setBookQty(this.bookQty);
        books.setBookGenre(this.bookGenre);
        books.setBookBranch(this.bookBranch);
        books.setBookImg(this.bookImg);
        return books;
    }

}
