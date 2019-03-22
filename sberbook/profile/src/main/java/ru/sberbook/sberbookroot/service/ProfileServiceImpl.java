package ru.sberbook.sberbookroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepo profileRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public boolean createUser(ProfileDto profileDto) {
        String credential = profileDto.getCredential();
        boolean notMail = !credential.contains("@");

        Profile profile = new Profile();
        profile.setPassword(profileDto.getPasswordHash());

        boolean userInDB = checkInDb(credential, notMail);

        if (!userInDB) {
            if (notMail) {
                profile.setLogin(credential);
            } else {
                profile.setEmail(credential);
            }
        } else {
            throw new RuntimeException("Пользователь с такими данными уже существует");
        }
        profileRepo.save(profile);
        return true;
    }

    @Override
    public Profile findProfile(String credential) {
        Profile profile;
        if (credential.contains("@")) {
            profile = profileRepo.findByEmail(credential);
        } else {
            profile = profileRepo.findByLogin(credential);
        }
        return profile;
    }

    /**
     * Проверяет есть ли в базе такой профиль
     * @param credential - мыло или логин
     * @param NotEmail - параметр, какой именно credential
     * @return возвращает, bool есть или нет в базе
     */
    private boolean checkInDb(String credential, Boolean NotEmail) {
        if(NotEmail) {
            Profile profile = profileRepo.findByLogin(credential);
            return profile != null;
        } else {
            Profile profile = profileRepo.findByEmail(credential);
            return profile != null;
        }
    }
}
