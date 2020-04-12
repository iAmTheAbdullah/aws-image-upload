package com.iamtheabdullah.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {
    private final UserProfileRepositoryInterface userProfileRepository;

    @Autowired
    public UserProfileService(@Qualifier("fake") UserProfileRepositoryInterface userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileRepository.getUserProfiles();
    }

    UserProfile getUserProfile(UUID userProfileId) {
        return userProfileRepository.getUserById(userProfileId);
    }

    void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
            
    }
}