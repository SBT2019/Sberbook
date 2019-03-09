package ru.sberbook.sberbookroot.repo;

import ru.sberbook.sberbookroot.domain.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Member;
import java.security.MessageDigest;
import java.util.List;


public interface TweetsRepo extends CrudRepository<Tweet, Long>{
    List<Tweet>  findTweetsByTag(String tag);  // Руководство по JPA репозиториям: https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation

}
