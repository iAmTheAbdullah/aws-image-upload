package com.iamtheabdullah.awsimageuploaddemo.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {
    private UUID userProfileId;
    private String username;
    private String userProfileImageLink; // S3 key

    public UserProfile(UUID userProfileId,
                       String username,
                       String userProfileImageLink) {

        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userProfileImageLink);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null || getClass() != obj.getClass()) return false;

        UserProfile that = (UserProfile) obj;

        return Objects.equals(userProfileId, that.userProfileId)
                && Objects.equals(username, that.username)
                && Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }
}