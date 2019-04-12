package com.design.patterns.adapter.bookclassifier;

import com.design.patterns.adapter.bookclassifier.librarya.Book;
import com.design.patterns.adapter.bookclassifier.librarya.Classifier;
import com.design.patterns.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.design.patterns.adapter.bookclassifier.libraryb.Book> books = new HashMap<>();
        for(Book book : bookSet) {
            books.put(new BookSignature(book.getSignature()), new com.design.patterns.adapter.bookclassifier.libraryb.Book(
                    book.getAuthor(),
                    book.getTitle(),
                    book.getPublicationYear()
            ));
        }
        return medianPublicationYear(books);
    }
}
