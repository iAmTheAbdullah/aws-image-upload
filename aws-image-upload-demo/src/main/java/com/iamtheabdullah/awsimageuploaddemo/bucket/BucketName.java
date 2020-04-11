package com.iamtheabdullah.awsimageuploaddemo.bucket;

public enum BucketName {
    PROFILE_IMAGE("iamtheabdullah-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
