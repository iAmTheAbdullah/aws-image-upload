package com.iamtheabdullah.awsimageupload.profile;

import com.iamtheabdullah.awsimageupload.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileRepository {
    private final FakeUserProfileDataStore userProfileDataStore;

    @Autowired
    public UserProfileRepository(FakeUserProfileDataStore userProfileDataStore) {
        this.userProfileDataStore = userProfileDataStore;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfileDataStore.getUserProfiles();
    }

    public UserProfile getUserByUserProfileId(UUID userProfileId) {
        return userProfileDataStore.getUserByUserProfileId(userProfileId);
    }
}
