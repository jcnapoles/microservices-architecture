package com.acciona.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acciona.storage.entity.ValidatedTweet;

@Repository
public interface ValidatedTweetRepository extends JpaRepository<ValidatedTweet, Long>{

}
