package ru.sberbook.sberbookroot.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sberbook.sberbookroot.dto.ProfileDto;
import ru.sberbook.sberbookroot.entity.Profile;
import ru.sberbook.sberbookroot.repository.ProfileRepo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplTest {
//    @Autowired
//    private ProfileService profileService;
//
//    @MockBean
//    private ProfileRepo profileRepo;
//
//    private Profile profile = new Profile();
//    private ProfileDto profileDtoLogin = new ProfileDto();
//    private ProfileDto profileDtoEmail = new ProfileDto();
//
//
//    @Before
//    public void setUp() {
//
//        profile.setLogin("admin");
//        profile.setEmail("admin@");
//        profile.setPassword("hash123");
//
//        profileDtoEmail.setCredential("admin@");
//        profileDtoEmail.setPasswordHash("hash123");
//
//        profileDtoLogin.setCredential("admin");
//        profileDtoLogin.setPasswordHash("hash123");
//    }
//
//    @Test
//    public void createUser() {
//        Mockito.when(profileRepo.findByLogin(profile.getLogin()))
//                .thenReturn(profile);
//        boolean result = profileService.createUser(profileDtoLogin);
//        //assertThat(result).isEqualTo(false);
//    }

    @Test
    public void findProfile() {
    }
}