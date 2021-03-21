package com.fmm.springboottest.entity;/*
 *  Fmm
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //如果数据库中id是自增的，则还需要添加一个注解用以声明
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String author;
}
