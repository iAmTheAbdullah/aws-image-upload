package com.iamtheabdullah.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AmazonConfig {
    private enum AmazonKeysTypeEnum {
        ACCESS,
        SECRET
    }

    @Bean
    public AmazonS3 s3() throws IOException {
        String accessKey = readAmazonKeys(AmazonKeysTypeEnum.ACCESS);
        String secretKey = readAmazonKeys(AmazonKeysTypeEnum.SECRET);

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    @Bean
    private String readAmazonKeys(AmazonKeysTypeEnum keyType) throws IOException {
        final String CSV_FILENAME = "./rootkey.csv";

        String readLine = "";
        Map<String, String> keys = new HashMap();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSV_FILENAME));

            while ((readLine = reader.readLine()) != null) {
                String[] keyValueString = readLine.split("=");
                keys.put(keyValueString[0], keyValueString[1]);
            }

            reader.close();
        }
        catch (IOException ex) {
            throw new IOException("File not found", ex);
        }

        switch (keyType) {
            case ACCESS:
                return keys.get("AWSAccessKeyId");
            case SECRET:
                return keys.get("AWSSecretKey");
            default:
                return "";
        }
    }
}