package ru.sberbook.sberbookroot;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Violetta on 2019-04-19
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
