package com.fmm.springboottest.repository;

import com.fmm.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/*
 *  Fmm
 */
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }
    @Test
    void findById(){
        //该方法的返回对象是一个Optional，它是jdk8新添的一个特性，
        //方式返回对象时为空等抛出异常，这个类型相当于把对象又包了一层，不会抛异常
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }
}
