package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @Test
    public void testJDBCtemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //Book book = new Book();
        //book.setUserId("1");
        //book.setUsername("javaaha");
        //book.setUstatus("aaab");
        ////bookService.addBook(book);
        ////bookService.updateBook(book);
        //bookService.deleteBook(book);

        //int count = bookService.findCount();
        //System.out.println(count);

        //Book one = bookService.findOne("1");
        //System.out.println(one);

        //List<Book> all = bookService.findAll();
        //for(Book b : all) {
        //    System.out.println(b);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        //Object[] o3 = {"javv3","c","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        //batchArgs.add(o3);

        bookService.batchdelete(batchArgs);

        }
    }
