package com.zhang.test.sql;

import com.zhang.test.euppr.CMUtility;

public class MysqlZj {
    public  void In() {
        boolean f = true;
        do {
            System.out.println("\t" + "\t" + "===这是增加一条用户信息===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===请输入你要增加的姓名===" + "\t" + "\t");
            String Name = CMUtility.readString(3);
            System.out.println("\t" + "\t" + "===请输入要增加的年龄" + "\t" + "\t");
            int Age = CMUtility.readInt();
              String Sex = CMUtility.readString(3);
            System.out.println("\t" + "\t" + "===请输入要增加的电话好号码===" + "\t" + "\t");
            String Phone = CMUtility.readString(3);
            String s = MySql.Insert(Name, Age, Sex, Phone);
            System.out.println(s);
            System.out.println("\t" + "\t" + "===继承增加请按任意键,退出请按n===" + "\t" + "\t");
            String key = CMUtility.readString(2);
            if (key.equals("n")) {
                f = false;
            }
        } while (f);
    }
}
