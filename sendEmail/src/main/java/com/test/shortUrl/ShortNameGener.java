package com.test.shortUrl;

import java.security.MessageDigest;

/**
 * 短地址生成方式验证
 *
 * @author lqt77
 * @date 2019-06-05-10:15
 */
public class ShortNameGener {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //长链接
        String sLongUrl = "http://474515923.qzone.qq.com";
        String name1 = "山东省德州市武城县武城县广运街道办事处前屯村卫生室";
        String name2 = "河南省安阳市内黄县石盘屯乡石瓮村卫生室";
        String name3 = "武城县广运街道办事处前屯村卫生室111000015111000178111001684";
        String name4 = "石盘屯乡石瓮村卫生室111000016111000186111001764";
        String aResult = shortUrl (name4);
        // 打印出结果
        for ( int i = 0; i < 1; i++) {
            System. out .println( ":::" + aResult);
        }
    }

    public static String shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "medical" ;
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"
        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult =  md5ByHex(key + url);
        String hex = sMD5EncryptResult;

        String resUrl = "";
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring( 8,  16);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong (sTempSubString, 16);
            String outChars = "" ;
            for ( int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[( int ) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl= outChars;

        return resUrl;
    }


    //MD5方法
    public static String md5ByHex(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = src.getBytes();
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            String hs = "";
            String stmp = "";
            for (int i = 0; i < hash.length; i++) {
                stmp = Integer.toHexString(hash[i] & 0xFF);
                if (stmp.length() == 1){
                    hs = hs + "0" + stmp;
                }else {
                    hs = hs + stmp;
                }
            }
            return hs.toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }
}
