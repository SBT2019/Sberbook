package ru.sberbook.sberbookroot.service;

import ru.sberbook.sberbookroot.Dto.ProfileDto;

public interface ProfileService {
    boolean createUser(ProfileDto profile);
    ProfileDto findProfile(String credential);
}
