package com.fmm.springboottest.controller;/*
 *  Fmm
 */

import com.fmm.springboottest.entity.Book;
import com.fmm.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        //由于指定了页数，所以findAll方法不能是查询所有了，而是点到第几页展示第几页的数据
        //JPA的findAll提供了许多重载的方法，可以传递分页信息,Pageable是一个接口，
        //使用它的实现类PageRequest，of方法把第几页和数据条数传递，页码信息从0开始，
        //比如0,6表示，第1页，取6条数据，用户传1过来，那么我取第0页才是用户想要的第一页数据
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);//返回的是一个Page对象，多以需要更
    }
    //由于前端传过来的是json，所以需要加@RequestBody来转为java对象
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
