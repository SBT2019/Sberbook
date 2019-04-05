package ru.sberbook.sberbookroot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;

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
            throw new IllegalStateException("User " + profile.getLogin() + " already exists");
        }

        if (isEmail) {
            profile.setEmail(credential);
        } else {
            profile.setLogin(credential);
        }

        profileRepo.save(profile);
        return true;
    }

    @Override
    public Profile findProfile(String credential) {
        return credential.contains("@") ?
                profileRepo.findByEmail(credential)
                : profileRepo.findByLogin(credential);
    }

    /**
     * Проверяет есть ли в базе такой профиль
     *
     * @param credential - мыло или логин
     * @param email      - параметр, какой именно credential
     * @return возвращает, bool есть или нет в базе
     */
    private boolean checkInDb(String credential, boolean email) {
        Profile profile = email ?
                profileRepo.findByEmail(credential) :
                profileRepo.findByLogin(credential);

        return profile != null;
    }
}
