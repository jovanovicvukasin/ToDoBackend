package com.vux.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vux.project.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
