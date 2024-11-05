package edu.local;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;

@ApplicationScoped
public class S3ClientConfig {

    @ConfigProperty(name = "aws.access-key-id")
    String accessKey;

    @ConfigProperty(name = "aws.secret-access-key")
    String secretKey;

    @ConfigProperty(name = "aws.region")
    String region;

//    @Produces
//    @ApplicationScoped
//    public S3Client s3Client() {
//        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
//
//        return S3Client.builder()
//                .region(Region.of(region))
//                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
//                .build();
//    }
}
