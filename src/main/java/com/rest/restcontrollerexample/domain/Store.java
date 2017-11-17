package com.rest.restcontrollerexample.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Store {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private String name;

    @Column
    private String location;

    @ManyToMany
    private List<Book> book;

    @Builder
    public Store(String name, String location, List<Book> bookList) {
        this.name = name;
        this.location = location;
        this.book = bookList;
    }
}
