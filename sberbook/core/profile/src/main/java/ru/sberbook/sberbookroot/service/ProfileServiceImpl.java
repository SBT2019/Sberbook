package ru.sberbook.sberbookroot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;
import ru.sberbook.sberbookroot.util.ProfileUtils;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepo profileRepo;

    @Override
    public boolean createUser(ProfileDto profileDto) {
        String credential = profileDto.getCredential();
        boolean isEmail = credential.contains("@");

        Profile profile = new Profile();
        profile.setPassword(profileDto.getPasswordHash());

        boolean userInDB = checkInDb(credential, isEmail);

        if (userInDB) {
            throw new IllegalStateException("User " + credential + " already exists");
        }

        if (isEmail) {
            profile.setEmail(credential);
        } else {
            profile.setPhone(credential);
        }

        profileRepo.save(profile);
        return true;
    }

    @Override
    public Profile findProfile(String credential) {
        return credential.contains("@") ?
                profileRepo.findByEmail(credential)
                : profileRepo.findByPhone(credential);
    }

    @Override
    public long getUserId(String credential) {
        if(ProfileUtils.isPhone(credential)) {
            Profile profile = profileRepo.findByPhone(credential);
            return profile.getUser_id();
        }

        if(ProfileUtils.isEmail(credential)) {
            Profile profile = profileRepo.findByEmail(credential);
            return profile.getUser_id();
        }
        return -1;
    }

    @Override
    public boolean checkUser(String credential) {
        if(ProfileUtils.isPhone(credential)) {
            Profile profile = profileRepo.findByPhone(credential);
            return profile != null;
        }

        if(ProfileUtils.isEmail(credential)) {
            Profile profile = profileRepo.findByEmail(credential);
            return profile != null;
        }
        return false;
    }

    @Override
    public Profile findUserByConfirmationCode(String confirmationCode) {
        Profile profile = profileRepo.findByConfirmationCode(confirmationCode);
        return profile;
    }

    @Override
    public Profile findUserByToken(String token) {
        Profile profile = profileRepo.findByToken(token);
        return profile;
    }

    /**
     * Проверяет есть ли в базе такой профиль
     *
     * @param credential - мыло или телефон
     * @param email      - параметр, какой именно credential
     * @return возвращает, bool есть или нет в базе
     */
    private boolean checkInDb(String credential, boolean email) {
        Profile profile = email ?
                profileRepo.findByEmail(credential) :
                profileRepo.findByPhone(credential);

        return profile != null;
    }
}
