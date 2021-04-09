package com.acciona.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acciona.storage.entity.HashtagItem;

@Repository
public interface HashtagItemRepository extends JpaRepository<HashtagItem, Long>{

}
