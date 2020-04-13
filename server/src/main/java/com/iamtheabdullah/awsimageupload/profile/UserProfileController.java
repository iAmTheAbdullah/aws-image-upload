package com.iamtheabdullah.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("")
//@CrossOrigin("*") -- disabled (commented out) for security reasons
@CrossOrigin("http://localhost:3000") // change port number to the one that your front-end application is on
public class UserProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(
            path = "users"
    )
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }

    @GetMapping(
            path = "user/{userProfileId}"
    )
    public UserProfile getUserProfile(@PathVariable("userProfileId") UUID userProfileId) {
        return userProfileService.getUserProfile(userProfileId);
    }

    @PostMapping(
            path = "user/{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId,
                                       @RequestParam("file") MultipartFile file) {
         userProfileService.uploadUserProfileImage(userProfileId, file);
    }
}