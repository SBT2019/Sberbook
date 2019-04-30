package ru.sberbook.sberbookroot;

import lombok.NonNull;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Violetta on 2019-04-19
 */
@AllArgsConstructor
@Getter
@Setter
@Table
public class User {
    @PrimaryKey
    private @NonNull long id;
    private @NonNull String hashPass;
}
