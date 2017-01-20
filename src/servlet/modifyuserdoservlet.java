 package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dbConnector.dbCon;

public class modifyuserdoservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req,resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		

		// String flag = request.getParameter("FLAG");
		String useridmodify = request.getParameter("LoginName");
		String userPwd=request.getParameter("Password1");
		String userPwdmodify = request.getParameter("Password2");
		String userPwdconfirm = request.getParameter("Password3");
        int flag=0;
		
		System.out.println("alert(" + useridmodify + ")");
		System.out.println("alert(" + userPwd + ")");
		System.out.println("alert(" + userPwdmodify + ")");
		System.out.println("alert(" + userPwdconfirm + ")");
		
		
		
		// String modifyok = "before";
		// devicemodify.setTagID(tagidmodify);
		// String flag="before";
         if(!(userPwdmodify.equalsIgnoreCase(userPwdconfirm)||userPwdconfirm.equalsIgnoreCase(userPwdmodify))){
        	 int res;				
				res=JOptionPane.showConfirmDialog(null,"新密码与确认密码不一致，请重试","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION||res==JOptionPane.NO_OPTION)
				{
					response.sendRedirect("ChangePassword.jsp");
				}

              }
         else{
		try {
			dbCon con = new dbCon();
			String sql = "select * from User where UID ='"+useridmodify+"';";
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				if(rs.getString("UPass").equals(userPwd)){
		         flag=1;
				}
			}
	     
			else{
				
				int res;				
				res=JOptionPane.showConfirmDialog(null,"登录名或密码错误，请重试","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION||res==JOptionPane.NO_OPTION)
				{
					response.sendRedirect("ChangePassword.jsp");
				}
		   }
			rs.close();
			stmt.close();
			con.getCon().close();
				
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(flag==1)
		{
			
			try {
				dbCon connect = new dbCon();
				PreparedStatement ps = connect
						.getCon()
						.prepareStatement(
								"update User set "
										+ "UPass=?"
										+ " where UID = '" + useridmodify + "'");
			
				ps.setString(1, userPwdmodify);

				ps.execute();
				// modifyok = "ok";
				ps.close();
	            int res;				
				res=JOptionPane.showConfirmDialog(null,"修改成功，是否返回登录界面？","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
				if(res==JOptionPane.YES_OPTION)
				{
					response.sendRedirect("Login.jsp");
				}
				if(res==JOptionPane.NO_OPTION)
				{
					response.sendRedirect("ChangePassword.jsp");
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}                     							
		}
		else
		{
			int res;				
			res=JOptionPane.showConfirmDialog(null,"登录名或密码错误，请重试","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
			if(res==JOptionPane.YES_OPTION||res==JOptionPane.NO_OPTION)
			{
				response.sendRedirect("ChangePassword.jsp");
			}
	   }
		
		}
		
		
         }
	}


