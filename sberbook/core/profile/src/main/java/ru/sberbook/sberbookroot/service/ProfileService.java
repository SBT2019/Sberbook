package ru.sberbook.sberbookroot.service;

import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;

public interface ProfileService {
    boolean createUser(ProfileDto profileDto);

    Profile findProfile(String credential);
}
