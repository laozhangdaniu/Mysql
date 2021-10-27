package com.zhang.test.demo;

import com.zhang.test.euppr.CMUtility;
import com.zhang.test.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet set;
    public static void main(String[] args) {
        boolean f = true;
        do {
            System.out.println("登录请输入‘1’退出请输入‘2’");
            int Kye = CMUtility.readInt(2);
            if (Kye == 1) {
                System.out.println("\t" + "\t" + "===请输入用户名===" + "\t" + "\t");
                String ursename = CMUtility.readString(10);
                System.out.println("\t" + "\t" + "===请输入密码===" + "\t" + "\t");
                String paasword = CMUtility.readString(10);
                if (ursename.equals("1") && paasword.equals("1")) {
                    Test.Sql();
                } else System.out.println("\t" + "\t" + "===密码或者账号错误===" + "\t" + "\t");
            } else if (Kye == 2) {
                System.out.println("\t" + "\t" + "===退出请按n,返回请按任意键===" + "\t" + "\t");
                String ev = CMUtility.readString(3);
                if (ev.equals("n")) {
                    f = false;
                    MySql.CloseAll(conn, ps, set);
                }
            }
        } while (f);
    }

    public static void Sql() {
        MysqlZj zj = new MysqlZj();
        MysqlXg xg = new MysqlXg();
        boolean f = true;
        do {
            System.out.println("\t" + "\t" + "===请输入数字来选择操作===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===1:查询所有用户===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===2:增加一条用户信息===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===3:删除一条用户信息===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===4:修改一条用户信息===" + "\t" + "\t");
            System.out.println("\t" + "\t" + "===5:返回上一级系统===" + "\t" + "\t");
            int Values = CMUtility.readInt();
            switch (Values) {
                case 1:
                    MysqlCx.St();
                    break;
                case 2:zj.In();
                    break;
                case 3:
                    MysqlSc.De();
                    break;
                case 4:
                    xg.Up();
                    break;
                case 5:
                    System.out.println("\t" + "\t" + "===退出请按n,返回请按任意键===" + "\t" + "\t");
                    String V = CMUtility.readString(3);
                    if (V.equals("n")) {
                      return;
                    }
            }
        } while (f);
    }
}