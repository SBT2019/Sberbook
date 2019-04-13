package ru.sberbook.sberbookroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbook.sberbookroot.dto.ProfileData;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;
import ru.sberbook.sberbookroot.util.ProfileUtils;

@Service
public class ProfileUiServiceImpl implements ProfileUiService {

    private final ProfileRepo profileRepo;

    @Autowired
    public ProfileUiServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public ProfileData getProfile(String credential) {
        ProfileData profileData = new ProfileData();
        Profile profile = new Profile();
        if (ProfileUtils.isEmail(credential)) {
            profile = profileRepo.findByEmail(credential);
        }
        if (ProfileUtils.isPhone(credential)) {
            profile = profileRepo.findByPhone(credential);
        }

        if (profile != null) {
            profileData.setLogin(profile.getLogin());
            profileData.setEmail(profile.getEmail());
            profileData.setPhone(profile.getPhone());
            profileData.setImg(profile.getImg());
        }

        return profileData;
    }

    @Override
    public boolean setProfile(ProfileData profileData) {
        //TODO
        //1) get credential of current user from autorization
        //2) get this user from db
        //3) set params from profileData
        //4) save in db
        //5) check
        return false;
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
