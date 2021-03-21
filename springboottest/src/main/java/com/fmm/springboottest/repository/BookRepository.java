package com.fmm.springboottest.repository;/*
 *  Fmm
 */

import com.fmm.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
