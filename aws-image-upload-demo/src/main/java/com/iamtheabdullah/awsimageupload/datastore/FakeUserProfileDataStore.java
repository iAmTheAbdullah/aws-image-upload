package com.iamtheabdullah.awsimageupload.datastore;

import com.iamtheabdullah.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "john.doe", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "jane.doe", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

    public UserProfile getUserByUserProfileId(UUID userProfileId) {
        return USER_PROFILES.stream()
                .filter(user -> user.getUserProfileId().equals(userProfileId))
                .findFirst()
                .get();
    }
}
