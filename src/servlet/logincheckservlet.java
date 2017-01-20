package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



import bean.user;
import bean.Building;
import dbConnector.dbCon;

public class logincheckservlet extends HttpServlet {

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

		doPost(req, resp);
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
		response.setCharacterEncoding("utf-8");
	
	
		
		int i=0;
		String userID = request.getParameter("LoginName");
		String userpwd = request.getParameter("Password");
		System.out.println(userID);
		System.out.println(userpwd);
		
		request.getSession().setAttribute("start","0");
		
		user u = new user();
		Building building;

		String username = "before";
		
		try{
			dbCon con = new dbCon();
			String sql = "select * from User where UID ='"+userID+"';";
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				if(rs.getString("UPass").equals(userpwd)){
					System.out.println("login sucess!");
					u.setUserName(rs.getString("UName"));
					username=rs.getString("UName");
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
				}
				else{}
			}
			rs.close();
			stmt.close();
			con.getCon().close();
		}catch(Exception e){
			e.printStackTrace();
		}

		  
		//用户名或密码输入错误
		if("before".equals(username)){
			int res;
			
			res=JOptionPane.showConfirmDialog(null,"用户名或密码输入错误，请重试！","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
			if(res==JOptionPane.YES_OPTION||res==JOptionPane.NO_OPTION)
			{
				response.sendRedirect("Login.jsp");
			}	
		}
		else if(null == u.getUserName()){
			int res;
			res=JOptionPane.showConfirmDialog(null,"登录错误，请重试","Warning",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
			if(res==JOptionPane.YES_OPTION||res==JOptionPane.NO_OPTION)
			{
				response.sendRedirect("Login.jsp");
			}	
			
		}
		//成功登录
		else if(null != u.getUserName()){
			System.out.println(username);
			System.out.println(u.getUserName());
			
			request.setAttribute("loguser", u);
			
			request.getRequestDispatcher("/example.jsp?username="+username).forward(request,
					response);
			return;
		}
		
		 request.getSession().removeAttribute("rand");
		}
  }
	
	

	

/*}*/
