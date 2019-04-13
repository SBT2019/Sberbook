package ru.sberbook.sberbookroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;

@Service
public class ProfileUiServiceImpl implements ProfileUiService {

    private final ProfileRepo profileRepo;

    @Autowired
    public ProfileUiServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile getProfile(String credential) {
        return credential.contains("@") ?
                profileRepo.findByEmail(credential)
                : profileRepo.findByPhone(credential);
    }

    @Override
    public Profile setProfile(Profile profile) {
        //TODO
        return null;
    }

    //TODO убрать отсюда, дублируется
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
