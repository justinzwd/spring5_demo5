package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    //注入
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        //1.sql语句
        String sql = "insert into t_user values(?,?,?)";

        //2.调用方法实现
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus()};
        int update = jdbcTemplate.update(sql,args);

        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        //1.sql语句
        String sql = "update t_user set username=?,ustatus=? where user_id=?";

        //2.调用方法实现
        Object[] args = {book.getUsername(), book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql,args);

        System.out.println(update);
    }

    @Override
    public void deleteBook(String id) {
        //1.sql语句
        String sql = "delete from t_user where user_id=?";

        //2.调用方法实现
        int update = jdbcTemplate.update(sql,id);

        System.out.println(update);
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_user where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_user";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;

    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_user values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from t_user where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_user set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println();
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
}
