package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookDao {

    void add(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);
}
