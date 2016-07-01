package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;

import net.sf.json.JSONObject;

public class Login {
	public static Boolean login(String username, String password) throws Exception {

		String dbpassword=null;
		Connection conn = com.util.DBUtil.getConnection();
		String sql = "select * from user where username=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dbpassword = rs.getString("password");
		}
		if (password.equals(dbpassword)) {
			return true;
//			User user = new User();
//			user.setUserName(username);
//			user.setPassword(dbpassword);
//			JSONObject jo = new JSONObject();
//			jo.accumulate("success", true);
//			jo.accumulate("user", user);
//			System.out.println("µÇÂ¼³É¹¦");
		} else {
			return false;
//			System.out.println("µÇÂ¼Ê§°Ü");
		}
	}
}
