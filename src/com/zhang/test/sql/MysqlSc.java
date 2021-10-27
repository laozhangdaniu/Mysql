package com.zhang.test.sql;

import com.zhang.test.euppr.CMUtility;

public class MysqlSc {
    public static void De() {
        boolean f = true;
        do {
            System.out.println("\t" + "\t" + "===请输入你要删除的ID===" + "\t" + "\t");
            int Values = CMUtility.readInt();
            String delete = MySql.Delete(Values);
            System.out.println(delete);
            System.out.println("\t" + "\t" + "===继续删除请按任意键,结束删除请按n===" + "\t" + "\t");
            String Key = CMUtility.readString(3);
            if (Key.equals("n")) {
                f = false;
            }
        } while (f);
    }
}
