package com.rest.restcontrollerexample.repository;


import com.rest.restcontrollerexample.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
