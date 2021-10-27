package com.zhang.test.sql;

import com.zhang.test.dao.Earr;
import com.zhang.test.euppr.CMUtility;

import java.sql.*;
import java.util.ArrayList;

public class MySql {
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet set;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://localhost:3306/Cun?serverTimezone=UTC";
            String username = "root";
            String password = "123";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CloseAll(Connection conn, PreparedStatement ps, ResultSet set) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Earr> SelectAll() {
        String sql = "select * from evo";
        ArrayList<Earr> array = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            set = ps.executeQuery();
            array = new ArrayList<>();
            while (set.next()) {
                array.add(
                        new Earr(set.getString("Name"),
                                set.getInt("Age"),
                                set.getString("Sex"),
                                set.getString("Phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static String Insert(String Name, int Age, String Sex, String Phone) {
        String sql = "insert into evo(Name,Age,Sex,Phone) values(?,?,?,?)";
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setInt(2, Age);
            ps.setString(3, Sex);
            ps.setString(4, Phone);
             i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == 0) {
            return "\t" + "\t" + "===增加失败，请检查条件===" + "\t" + "\t";
        } else return "\t" + "\t" + "===增加成功！增加了===" + i + "条数据" + "\t" + "\t";
    }

    public static String Delete(int ID) {
        String sql = "delete from evo where ID  = ?";
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == 0) {
            return "\t" + "\t" + "===删除失败，请检查条件===" + "\t" + "\t";
        } else return "\t" + "\t" + "===删除成功！删除了===" + i + "条数据" + "\t" + "\t";
    }

    public static String Update(String Name, int Age, String Sex, String Phone, int ID) {
        String sql = "update evo set Name=?,Age=?,Sex=?,Phone=? where ID  = ?";
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setInt(2, Age);
            ps.setString(3, Sex);
            ps.setString(4, Phone);
            ps.setInt(5, ID);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == 0) {
            return "\t" + "\t" + "===修改失败，请检查条件！===" + "\t" + "\t";
        } else return "\t" + "\t" + "===修改成功！修改了" + i + "条数据===" + "\t" + "\t";
    }
}