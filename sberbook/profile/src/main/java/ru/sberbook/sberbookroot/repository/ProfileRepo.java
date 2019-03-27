package ru.sberbook.sberbookroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbook.sberbookroot.entity.Profile;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
    Profile findByEmail(String email);

    Profile findByLogin(String login);
}
