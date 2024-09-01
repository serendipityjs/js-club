package com.js.club.wx.utils;

import java.util.Random;

/*
 * 包好了二十六个字母和十个数字的字符数组
 * @param Length 需要的字符长度
 * @return 返回随机字母数字组合字符串
 */
public class GetVerificationCode {

    public static String getVerificationCode(int length) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            //随机数由0-9，a-z,A-Z组成，数字占10个，字母占52个，数字、字母占比1:5（标准的应该是10:52）
            //random.nextInt(6) 0-5中6个数取一个
            String charOrNum = (random.nextInt(6) + 6) % 6 >= 1 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母，输出比例为1:1
                int temp = random.nextInt(2) % 2 == 0 ? 97 : 65;
                //char（65）-char(90) 为大写字母A-Z；char(97)-char(122)为小写字母a-z
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(String.valueOf(random.nextInt(10)));
            }
        }
        return val.toString();

    }
}