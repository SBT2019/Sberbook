package ru.sberbook.sberbookroot.service;

import ru.sberbook.sberbookroot.dto.ProfileData;

public interface ProfileUiService {
    ProfileData getProfile(String credential);
    boolean setProfile(ProfileData profile);
}
