package com.js.subject.infrastructure.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库加密util(对数据库连接密码等进行加密,防止明文)
 *
 * @author jiaoshuai
 * @date 2024/6/24 11:24
 */
public class DruidEncryptUtil {
    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey = " + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey = " + publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密
     *
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText) {
        String encrypt = null;
        try {
            encrypt = ConfigTools.encrypt(privateKey, plainText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("encrypt = " + encrypt);
        return encrypt;
    }


    /**
     * 解密
     *
     * @param encryptText
     * @return
     */
    public static String decrypt(String encryptText) {
        String decrypt = null;
        try {
            decrypt = ConfigTools.decrypt(publicKey, encryptText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decrypt;
    }


    public static void main(String[] args) {
        String password = encrypt("123456");
        System.out.println("password = " + password);
    }


}
