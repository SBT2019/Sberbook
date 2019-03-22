package ru.sberbook.sberbookroot.service;

import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.Dto.ProfileDto;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Override
    public boolean createUser(ProfileDto profile) {
        return false;
    }

    @Override
    public ProfileDto findProfile(String credential) {
        return null;
    }
}
