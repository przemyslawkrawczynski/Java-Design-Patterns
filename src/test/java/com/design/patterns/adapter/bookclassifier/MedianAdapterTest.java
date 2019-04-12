package com.design.patterns.adapter.bookclassifier;

import com.design.patterns.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTest {

    @Test
    public void publicationYearMedian() {
        //Given
        Book b1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 2015, "AM1");
        Book b2 = new Book("Henryk Sienkiewicz", "Krzyżacy", 2014, "AM2");
        Book b3 = new Book("Henryk Sienkiewicz", "Potop", 2013, "AM3");
        Book b4 = new Book("Henryk Sienkiewicz", "Ogniem i mieczem", 2012, "AM4");

        Set<Book> books = new HashSet<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianLibraryA = medianAdapter.publicationYearMedian(books);

        //Then
        Assert.assertEquals(2014, medianLibraryA);

    }
}