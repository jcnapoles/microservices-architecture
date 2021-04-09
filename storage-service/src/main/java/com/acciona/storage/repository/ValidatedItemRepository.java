package com.acciona.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acciona.storage.entity.ValidatedItem;

@Repository
public interface ValidatedItemRepository extends JpaRepository<ValidatedItem, Long>{

}
