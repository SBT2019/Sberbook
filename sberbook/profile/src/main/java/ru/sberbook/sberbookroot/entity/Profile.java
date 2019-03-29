package ru.sberbook.sberbookroot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String login;
    private String email;
    private String phone;
    private Date birth_date;
    private String img;

    @JsonIgnore
    private String password;

    public Profile(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
