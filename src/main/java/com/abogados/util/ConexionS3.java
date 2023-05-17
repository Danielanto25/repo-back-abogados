package com.abogados.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class ConexionS3 {

    @Value("${access.s3}")
    String accessKey;
    @Value("${secret.s3}")
    String secretKey;
    @Value("${bucket.s3}")
    String bucketName;


    private BasicAWSCredentials obtenerCredenciales() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    public boolean subir(String nombreArchivo, File archivo) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(obtenerCredenciales()))
                .withRegion("us-east-2")
                .build();
        try {

            PutObjectRequest request = new PutObjectRequest(bucketName, nombreArchivo, archivo);
            s3Client
                    .putObject(request)
                    .isRequesterCharged();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            s3Client.shutdown();
        }


    }

    public void elimiar(String nombreArchivo) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(obtenerCredenciales()))
                .withRegion("us-east-2")
                .build();
        try {
            s3Client.deleteObject(bucketName, nombreArchivo);
            s3Client.shutdown();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            s3Client.shutdown();
        }

    }

    public byte[] obtenerArchivo(String nombreArchivo) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(obtenerCredenciales()))
                .withRegion("us-east-2")
                .build();

        S3Object s3Object = s3Client.getObject(bucketName, nombreArchivo);
        try (InputStream inputStream = s3Object.getObjectContent()) {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        } finally {
            s3Client.shutdown();
        }

    }

}
