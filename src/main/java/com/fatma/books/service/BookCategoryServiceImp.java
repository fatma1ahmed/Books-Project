package com.fatma.books.service;

import com.fatma.books.exception.RecordNotFoundException;
import com.fatma.books.model.dto.BookRequset;
import com.fatma.books.model.dto.CategoryDto;
import com.fatma.books.model.entity.Author;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Category;
import com.fatma.books.repositry.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service

public class BookCategoryServiceImp implements BookCategoryService{
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private FileService fileService;
    @Override
    public ResponseEntity<?> assignBookToCategory(BookRequset bookDto) throws IOException {
         byte [] fileBytes=fileService.decodeBase64(bookDto.getPdf());
         bookDto.setPdf(fileService.saveFile(fileBytes));

        Category category = Category.toEntity(categoryService.getCategoryById(bookDto.getCategoryId()));
        Author author = authorService.getAuthorById(bookDto.getAuthorId());
        Book book=Book.toEntity(bookDto);
        book.setCategory(category);
        book.setAuthor(author);
        return bookService.addBook(book);
    }

    @Override
    public Optional<Book> findBookByName(String bookName) {
        Optional<Book> book=bookRepo.findByBookName(bookName);

        if(book.isPresent()) {
            Book book1=book.get();
            CategoryDto categoryDto=categoryService.getCategoryById(book1.getCategory().getId());
            Author author=authorService.getAuthorById(book1.getAuthor().getId());
            book1.setCategory(Category.toEntity(categoryDto));
            book1.setAuthor(author);
            return book;
        }
        else {
            throw new RecordNotFoundException("the book with name " + bookName + " not found");
        }


    }

    @Override
    public ResponseEntity<?> updateBook(BookRequset bookDto) {
        Book exitingBook=bookService.checkBookIfExistOrThrowException(bookDto.getId());
        Category category= Category.toEntity(categoryService.getCategoryById(bookDto.getCategoryId()));
        Author author=authorService.getAuthorById(bookDto.getAuthorId());
        Book book=Book.toEntity(bookDto);
        book.setCategory(category);
        book.setAuthor(author);
        return bookService.updateBook(book);
    }

    @Override
    public ResponseEntity<?> deleteBook(int categoryId) {
//       bookService.deleteAllBooksFromCategory(categoryId);
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.ok().body("All products from category " + categoryId + " have been deleted.");

    }


}


