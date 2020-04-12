package com.iamtheabdullah.awsimageupload.profile;

import java.util.List;
import java.util.UUID;

public interface UserProfileRepositoryInterface {
    List<UserProfile> getUserProfiles();
    UserProfile getUserById(UUID userProfileId);
}
