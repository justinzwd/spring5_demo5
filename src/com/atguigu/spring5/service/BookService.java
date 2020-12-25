package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入DAO
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(Book book) {
        bookDao.deleteBook(book.getUserId());
    }

    public int findCount() {
        return bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(String id) {
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll() {
        return bookDao.findAllBook();
    }

    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    public void batchupdate(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchdelete(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }





}
