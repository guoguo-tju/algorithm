package com.guoguo.datastructureandalgorithm.utils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @program: algorithm
 * @description:
 * @author: Karl Guo
 * @create: 2018-10-24 11:54
 **/
public class DowLoadFromAWS {


    public static String key = "123.mp3";


    /**
     * keyID
     */
    public static String accessKeyID = "123";

    /**
     * secretKey
     */
    public static String secretKey = "123";

    /**
     * 以理解为一个很大的磁储硬盘，其容量以T为单位
     */
    public static String bucketName = "123";

    /**
     * 上传文件地址
     */
    public static String localPath = "E:XXX/XXX.JPG";

    /**
     * 存储新对象的键
     */
    public static String s3Path = "amazonS3";



    public static void main(String[] args) {

        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyID, secretKey);

        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials));
        builder.setRegion(Regions.AP_SOUTHEAST_1.getName());
        AmazonS3 s3Client = builder.build();

        String targetFilePath = "D:\\test\\demofile.mp3";

        amazonS3Downloading(s3Client,bucketName,key,targetFilePath);

    }

    public static void amazonS3Downloading(AmazonS3 s3Client,String bucketName,String key,String targetFilePath){
        S3Object object = s3Client.getObject(new GetObjectRequest(bucketName,key));
        if(object!=null){
            System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
            InputStream input = null;
            FileOutputStream fileOutputStream = null;
            byte[] data = null;
            try {
                //获取文件流
                input=object.getObjectContent();
                data = new byte[input.available()];
                int len = 0;
                fileOutputStream = new FileOutputStream(targetFilePath);
                while ((len = input.read(data)) != -1) {
                    fileOutputStream.write(data, 0, len);
                }
                System.out.println("下载文件成功");
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(fileOutputStream!=null){
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(input!=null){
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
