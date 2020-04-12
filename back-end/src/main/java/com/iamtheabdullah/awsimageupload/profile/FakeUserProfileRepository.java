package com.iamtheabdullah.awsimageupload.profile;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fake")
public class FakeUserProfileRepository implements UserProfileRepositoryInterface {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "john.doe", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "jane.doe", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

    public UserProfile getUserById(UUID userProfileId) {
        return USER_PROFILES.stream()
                .filter(user -> user.getUserProfileId().equals(userProfileId))
                .findFirst()
                .get();
    }
}
