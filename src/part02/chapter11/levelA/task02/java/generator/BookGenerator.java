package part02.chapter11.levelA.task02.java.generator;

import part02.chapter11.levelA.task02.java.model.book.Book;
import part02.chapter11.levelA.task02.java.model.book.BooksUsingTerms;

import java.util.*;

public class BookGenerator {

    private final Random random;

    public BookGenerator() {
        random = new Random();
    }

    public GeneratedBooksData generateBooks(int count, int idLength) {
        IdGenerator idGenerator = new IdGenerator();
        Set<String> bookIds = new TreeSet<>();
        HashSet<Book> books = new HashSet<>();
        for (int i = 0; i < count; i++) {
            String id;
            do {
                id = idGenerator.generateId(idLength);
            } while (!bookIds.add(id));
            BooksUsingTerms booksUsingTerms = generateUsingTerms();
            books.add(new Book(id, booksUsingTerms));
        }
        return new GeneratedBooksData(books, new HashSet<>(bookIds));
    }

    private BooksUsingTerms generateUsingTerms() {
        EnumSet<BooksUsingTerms> terms = EnumSet.allOf(BooksUsingTerms.class);
        return terms.toArray(new BooksUsingTerms[0])[random.nextInt(terms.size())];
    }

    public static class GeneratedBooksData {
        private final HashSet<Book> books;
        private final HashSet<String> bookIDs;

        public GeneratedBooksData(HashSet<Book> books, HashSet<String> bookIDs) {
            this.books = books;
            this.bookIDs = bookIDs;
        }

        public HashSet<Book> getBooks() {
            return books;
        }

        public HashSet<String> getBookIDs() {
            return bookIDs;
        }
    }
}