package com.design.patterns.adapter.bookclassifier;

import com.design.patterns.adapter.bookclassifier.libraryb.Book;
import com.design.patterns.adapter.bookclassifier.libraryb.BookSignature;
import com.design.patterns.adapter.bookclassifier.libraryb.BookStatistics;
import com.design.patterns.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    Statistics statistics = new Statistics();

    @Override
    public int avaragePublicationYear(Map<BookSignature, Book> books) {
        return statistics.avaragePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistics.medianPublicationYear(books);
    }

}
