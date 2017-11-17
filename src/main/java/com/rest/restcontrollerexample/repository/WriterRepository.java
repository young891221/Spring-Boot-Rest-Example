package com.rest.restcontrollerexample.repository;


import com.rest.restcontrollerexample.domain.Writer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {
}
