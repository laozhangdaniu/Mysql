package com.zhang.test.sql;

import com.zhang.test.dao.Earr;
import com.zhang.test.euppr.CMUtility;

public class MysqlXg {
    public  void Up() {
        boolean s = true;
        Earr e;
        while (s) {
            MysqlCx.St();
            System.out.println("\t" + "\t" + "===请输入你要修改的ID===" + "\t" + "\t");
            int ID = CMUtility.readInt();
            System.out.println("\t" + "\t" + "===请输入你要修改的姓名===" + "\t" + "\t");
            String Name = CMUtility.readString(4);
            System.out.println("\t" + "\t" + "===请输入你要修改的年龄===" + "\t" + "\t");
            int Age = CMUtility.readInt();
            System.out.println("\t" + "\t" + "===请输入你要修改的性别===" + "\t" + "\t");
            String Sex = CMUtility.readString(3);
            System.out.println("\t" + "\t" + "===请输入你要修改的电话号码===" + "\t" + "\t");
            String Phone = CMUtility.readString(11);
            String s1 = MySql.Update(Name, Age, Sex, Phone, ID);
            System.out.println(s1);
            System.out.println("\t" + "\t" + "===继续请按任意键,结束修改请按n===" + "\t" + "\t");
            String key = CMUtility.readString(4);
            e = new Earr(Name, Age, Sex, Phone);
            System.out.println(e.getName());
            if (key.equals("n")) {
                s = false;
            }
        }
    }
}
