package com.zhang.test.sql;

import com.zhang.test.dao.Earr;

import java.util.ArrayList;

public class MysqlCx {
    public static void St() {
        ArrayList<Earr> arrayList = MySql.SelectAll();
        System.out.println("\t" + "\t" + "姓名" + "\t" + "\t" + "年龄" + "\t" + "\t" + "性别" + "\t" + "\t" + "电话");
        for (Earr e : arrayList) {
            System.out.println("\t" + "\t" + e.getName() + "\t" + "\t" + e.getAge() + "\t" + "\t" + e.getSex() + "\t" + "\t" + e.getPhone());
        }
    }
}
