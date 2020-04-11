package com.iamtheabdullah.awsimageuploaddemo.config;

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
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AmazonConfig {
    private enum AmazonKeysTypeEnum {
        ACCESS,
        SECRET
    }

    @Bean
    public AmazonS3 s3() {
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
    private String readAmazonKeys(AmazonKeysTypeEnum keyType) {
        final String CSV_FILENAME = "./rootkey.csv";

        String readLine = "";
        List<String[]> keys = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(CSV_FILENAME));

            while ((readLine = reader.readLine()) != null) {
                keys.add(readLine.split("="));
            }

            reader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        switch (keyType) {
            case ACCESS:
                return keys.get(0)[1];
            case SECRET:
                return keys.get(1)[1];
            default:
                return "";
        }
    }
}