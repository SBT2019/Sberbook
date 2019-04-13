package ru.sberbook.sberbookroot.service;

import ru.sberbook.sberbookroot.entity.Profile;

public interface ProfileUiService {
    Profile getProfile(String credential);
    Profile setProfile(Profile profile);
}
