package com.test;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;


import java.io.IOException;

/**
 * 解析浏览器
 *
 * @author lqt77
 * @date 2019-04-24-11:37
 */
public class UserAgentUtil {

    static UASparser uasParser = null;

    // 初始化uasParser对象
    static {
        try {
            uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        //String str = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36";
        //String str = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36";
        String str = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_4_1 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12H321 MicroMessenger/6.3.8 wxdebugger/0.1.0 Language/zh_CN webviewId/0";
        System.out.println(str);
        try {
            UserAgentInfo userAgentInfo = UserAgentUtil.uasParser.parse(str);
            System.out.println("操作系统名称："+userAgentInfo.getOsFamily());
            System.out.println("操作系统："+userAgentInfo.getOsName());
            System.out.println("浏览器名称："+userAgentInfo.getUaFamily());
            System.out.println("浏览器版本："+userAgentInfo.getBrowserVersionInfo());
            System.out.println("设备类型："+userAgentInfo.getDeviceType());
            System.out.println("浏览器:"+userAgentInfo.getUaName());
            System.out.println("类型："+userAgentInfo.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
