package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UsersLogin
 */
public class UsersLogin extends HttpServlet {
	public UsersLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean flag = false;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			flag = Login.login(userName, password);
			if (flag) {
				User user = new User();
				user.setPassword(password);
				user.setUserName(userName);
				JSONObject json = new JSONObject();
//				json.accumulate("user", user);
				json.accumulate("erorrcode", 200);//·µ»Ø³É¹¦µÄ×´Ì¬Âë
				PrintWriter pw = response.getWriter();
				pw.println("<html><body>");
				pw.println(json.toString());
				pw.println("</body></html>");
			}
			else
			{
				JSONObject json = new JSONObject();
				json.accumulate("erorrcode", 404);//·µ»ØµÇÂ¼Ê§°ÜµÄ×´Ì¬Âë
				PrintWriter pw = response.getWriter();
				pw.println("<html><body>");
				pw.println(json.toString());
				pw.println("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}