package com.rest.restcontrollerexample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Writer {

    @Id
    @GeneratedValue
    private Integer idx;

    @Column
    private String name;

    @Column
    private Integer age;

    @Builder
    public Writer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
